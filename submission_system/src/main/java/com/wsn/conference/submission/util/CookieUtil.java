package com.wsn.conference.submission.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author leyao
 * @version 2018-7-13
 */
public class CookieUtil {
    public static long getUserId(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return 6L;
        long userId = 0L;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId"))
                userId = Long.parseLong(cookie.getValue());
        }
        return userId;
    }

    public static String getUserName(HttpServletRequest request) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return "专家1";
        String userName = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username"))
                userName = URLDecoder.decode(cookie.getValue(), "UTF-8");
        }
        return userName;
    }

    public static String getRole(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return "expert";
        String role = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("role"))
                role = cookie.getValue();
        }
        return role;
    }
}
