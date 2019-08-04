package com.wsn.conference.Service;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.Bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface UserService {
    //登录
    JSONObject loginVerify(String username, String password, HttpServletResponse response);
    //注册用户
    JSONObject registerUser(User user);
    //注销退出
    String logout(HttpServletRequest request,HttpServletResponse response);
    //查询注册用户
    User selectRegisteredUser(String username);
    //重置密码
    JSONObject resetPassword(String username);

}
