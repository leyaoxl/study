package com.wsn.conference.submission.controller;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.submission.entity.UserInfo;
import com.wsn.conference.submission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

/**
 * @author leyao
 * @version 2018-7-12
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     *
     * @param account
     * @param password
     * @param prefix
     * @param username
     * @param degree
     * @param email
     * @param country
     * @param city
     * @param address
     * @param postalCode
     * @param phone
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public JSONObject register(
            @RequestParam(name = "account") String account,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "prefix") String prefix,
            @RequestParam(name = "username") String username,
            @RequestParam(name = "degree", required = false) String degree,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "country") String country,
            @RequestParam(name = "city") String city,
            @RequestParam(name = "school") String school,
            @RequestParam(name = "address") String address,
            @RequestParam(name = "postalCode") String postalCode,
            @RequestParam(name = "phone", required = false) String phone
    ) throws Exception {
        logger.info("===== start register ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = userService.register(account, password, prefix, username, degree, email, country, city, school, address, postalCode, phone);
        logger.info("===== end register ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 用户登录
     *
     * @param response
     * @param account
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(HttpServletResponse response, @RequestParam(name = "account") String account, @RequestParam(name = "password") String password) throws Exception {
        logger.info("===== start login ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = userService.login(response, account, password);
        logger.info("===== end login ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 用户注销
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject logout(HttpServletRequest request, HttpServletResponse response) {
        logger.info("===== start logout ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = userService.logout(request, response);
        logger.info("===== end logout ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 密码重置邮件功能
     *
     * @param email
     * @return
     */
    @RequestMapping(value = "/reset/email", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject resetEmail(String email) {
        logger.info("===== start reset email ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = userService.resetEmail(email);
        logger.info("===== end reset email ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 密码重置
     *
     * @param safeUserId
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject reset(@RequestParam(name = "safeUserId") String safeUserId, @RequestParam(name = "password") String password) throws Exception {
        logger.info("===== start reset ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = userService.reset(safeUserId, password);
        logger.info("===== end reset ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 更新用户角色信息
     *
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/role", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateUserRole(UserInfo userInfo) {
        logger.info("===== start update user role ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = userService.updateUserRole(userInfo);
        logger.info("===== end update user role ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 查询用户信息列表，按照角色
     *
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/info/list", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getUserInfoList(UserInfo userInfo) {
        logger.info("===== start get userInfo list ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = userService.getUserInfoList(userInfo);
        logger.info("===== end get userInfo list ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }

    /**
     * 查询用户信息
     *
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getUserInfo(UserInfo userInfo) {
        logger.info("===== start get userInfo list ===== " + this.getClass().getName() + " ===== leyao =====");
        JSONObject result = userService.getUserInfo(userInfo);
        logger.info("===== end get userInfo list ===== " + this.getClass().getName() + " ===== leyao =====");
        return result;
    }
}
