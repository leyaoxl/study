package com.wsn.conference.Service.impl;

import com.wsn.conference.Util.RandomUtil;
import com.wsn.conference.Util.ResultJsonUtil;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.Config.WebAppSecurityConfig;
import com.wsn.conference.Dao.UserDao;
import com.wsn.conference.Bean.User;
import com.wsn.conference.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service("userService")
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserDao userDao;

    //登录验证
    @Override
    public JSONObject loginVerify(String username, String password, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        User user = userDao.selectRegisteredUser(username);
        if (user == null) {
            return ResultJsonUtil.ResultJson(404,false,"当前用户没有注册");
        } else {
            if (password.equals(user.getPassword())) {
                WebAppSecurityConfig.COOKIE_VALUE = username;
                Cookie cookie = new Cookie(WebAppSecurityConfig.COOKIE_KEY, WebAppSecurityConfig.COOKIE_VALUE);
                //设置有效期限为7天
                cookie.setMaxAge(7 * 24 * 60 * 60);
                response.addCookie(cookie);
               return  ResultJsonUtil.ResultJson(200,true,"登录成功");
            } else {
                return   ResultJsonUtil.ResultJson(400,false,"密码验证失败，重新登录");
            }
        }

    }


    //注册用户
    @Override
    public JSONObject registerUser(User user) {
        JSONObject jsonObject = new JSONObject();
        //注册
        userDao.register(user);
        //查询注册用户
        User registeredUser = userDao.selectRegisteredUser(user.getUsername());
        if (registeredUser == null) {
            return ResultJsonUtil.ResultJson(404,false,"注册失败");
        } else {
            return ResultJsonUtil.ResultJson(200,true,"注册成功");
        }
    }

    //注销
    @Override
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie(WebAppSecurityConfig.COOKIE_KEY, WebAppSecurityConfig.COOKIE_VALUE);
        cookie.setValue(null);
        cookie.setMaxAge(0);//cookie失效
        response.addCookie(cookie);
        String url = "redirect:/login";
        return url;
    }

    //查询注册用户
    @Override
    public User selectRegisteredUser(String username) {
        User registeredUser = userDao.selectRegisteredUser(username);
        return registeredUser;
    }

    //重置密码
    @Override
    public JSONObject resetPassword(String username){
        JSONObject jsonObject=new JSONObject();
        //产生6位随机密码
        String randomPassword= RandomUtil.randomCode();
        userDao.updatePassword(username,randomPassword);
        User user=userDao.selectUpdatePasswordUser(username,randomPassword);
        if(user!=null){
            return ResultJsonUtil.ResultJson(200,true,"重置密码成功");
        }else{
            return ResultJsonUtil.ResultJson(404,false,"重置密码失败");
        }
    }
}

