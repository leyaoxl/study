package com.wsn.conference.submission.service;

import com.alibaba.fastjson.JSONObject;
import com.wsn.conference.submission.entity.UserInfo;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author leyao
 * @version 2018-7-12
 */
public interface UserService {
    JSONObject register(String account, String password, String prefix, String username, String degree, String email, String country, String city, String school, String address, String postalCode, String phone) throws Exception;

    JSONObject login(HttpServletResponse response, String account, String password) throws Exception;

    JSONObject logout(HttpServletRequest request, HttpServletResponse response);

    JSONObject resetEmail(String email);

    JSONObject reset(String safeUserId, String password) throws Exception;

    JSONObject updateUserRole(UserInfo userInfo);

    JSONObject getUserInfoList(UserInfo userInfo);

    JSONObject getUserInfo(UserInfo userInfo);
}
