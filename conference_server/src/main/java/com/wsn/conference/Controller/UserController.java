package com.wsn.conference.Controller;

import com.wsn.conference.Bean.User;
import com.wsn.conference.Dao.UserDao;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin(origins="*")

public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;

    Logger logger= LoggerFactory.getLogger(this.getClass());

    //登录处理
    @RequestMapping(value = {"/api/loginHandle"},method= RequestMethod.POST)
    public @ResponseBody String loginHandle(String username, String password, HttpServletResponse response)
            throws Exception{
        logger.info("登录处理!");
        JSONObject jsonObject=userService.loginVerify(username,password,response);
        if(jsonObject.get("code").equals(200)){
            return "index";
        }else{
            return "login";
        }
    }

    //注册处理
    @Transactional
    @RequestMapping(value = {"/api/registerHandle"},method= RequestMethod.POST)
    public @ResponseBody JSONObject registerHandle(User user) throws Exception{
        logger.info("注册处理！");
        JSONObject jsonObject=userService.registerUser(user);
        return jsonObject;
    }

    //测试数据库连接
    @RequestMapping(value = {"/test"},method= RequestMethod.GET)
    public @ResponseBody Map<String,Object> test() throws Exception{
        Map<String,Object> result=new HashMap<>();
        User user=userDao.selectUser();
        result.put("message",user);
        return result;
    }

    //重置密码
    @RequestMapping(value = {"/api/resetPasswordHandle"},method= RequestMethod.POST)
    public @ResponseBody JSONObject resetPasswordHandle(String username) throws Exception{
        logger.info("重置密码处理！");
        JSONObject jsonObject=userService.resetPassword(username);
        return  jsonObject;
}


}
