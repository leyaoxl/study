//package com.wsn.conference.Config;
//
//import com.wsn.conference.Bean.User;
//import com.wsn.conference.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
////配置拦截器
//public class MyInterceptor extends HandlerInterceptorAdapter {
//    @Autowired
//    UserService userService;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //获取cookie
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            boolean result = false;
//            for (int i = 0; i < cookies.length; i++) {
//                Cookie tempCookie = cookies[i];
//                String userName = tempCookie.getValue();
//                User registeredUser = userService.selectRegisteredUser(userName);
//                if (registeredUser != null) {
//                    result = true;
//                    break;
//                }
//            }
//            //登录成功
//            if (result) {
//                return true;
//            } else {
//                //跳转登录页面,重新登录
//                //添加登录页面修改
//                //response.sendRedirect(login);
//                return false;
//            }
//        }
//        //添加登录页面修改
//        //response.sendRedirect(login);
//        return false;
//    }
//}