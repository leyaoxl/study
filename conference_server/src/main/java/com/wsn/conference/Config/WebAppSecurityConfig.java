package com.wsn.conference.Config;

import com.wsn.conference.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import java.util.ArrayList;

@Configuration
public class WebAppSecurityConfig extends WebMvcConfigurerAdapter {
    //声明一个session存储的用户
    public static final String COOKIE_KEY = "user";
    public static  String COOKIE_VALUE="userName";
    @Resource
    UserService userService;
    //声明拦截器实例
//    @Bean
//    public MyInterceptor getMyInterceptor() {
//        return new MyInterceptor();
//    }
//
//    //添加相应配置信息
//    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration addInterceptor = registry.addInterceptor(getMyInterceptor());
//        String login = "/login";
//        String register = "/register";
//        String index = "index";
//        String loginHandle="/loginHandle";
//        String registerHandle="/registerHandle";
//        String test="/test";
//        String resetPassword="/resetPasswordHandle";
//
//        ArrayList<String> allowUrls = new ArrayList<String>();
//        allowUrls.add(login);
//        allowUrls.add(register);
//        allowUrls.add(index);
//        allowUrls.add(loginHandle);
//        allowUrls.add(registerHandle);
//        allowUrls.add(test);
//        allowUrls.add(resetPassword);
//
//        //配置放行URL
//        for (String allowUrl : allowUrls) {
//            addInterceptor.excludePathPatterns(allowUrl);
//        }
////        addInterceptor.addPathPatterns("/**");
//    }
}
