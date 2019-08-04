// package com.wsn.conference.submission.config;
//
// import com.wsn.conference.submission.util.CookieUtil;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
// import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
// import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
//
// /**
//  * @author leyao
//  * @version 2018-9-3
//  */
// @Configuration
// public class WebAppSecurityConfig extends WebMvcConfigurerAdapter {
//     /**
//      * 装配一个bean
//      *
//      * @return MyInterceptor
//      */
//     @Bean
//     public MyInterceptor getMyInterceptor() {
//         return new MyInterceptor();
//     }
//
//     /**
//      * 为项目添加拦截器，当cookie中的信息不正确时，将重定向至失败页面
//      * 但排除了user及returnPage接口，二者可以正常访问
//      *
//      * @param registry
//      */
//     @Override
//     public void addInterceptors(InterceptorRegistry registry) {
//         InterceptorRegistration registration = registry.addInterceptor(getMyInterceptor());
//         registration.excludePathPatterns("/api/user/**");
//         registration.excludePathPatterns("/api/returnPage/**");
//     }
// }
//
// class MyInterceptor extends HandlerInterceptorAdapter {
//     /**
//      * 当cookie中有值的时候才能够进行拦截
//      *
//      * @param request
//      * @param response
//      * @param handler
//      * @return boolean
//      * @throws Exception
//      */
//     @Override
//     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//         long userId = CookieUtil.getUserId(request);
//         String userName = CookieUtil.getUserName(request);
//         if (userId == -1L && userName.equals("=====")) {
//             response.sendRedirect("/api/returnPage/failed/login");
//             return false;
//         }
//         return true;
//     }
// }
