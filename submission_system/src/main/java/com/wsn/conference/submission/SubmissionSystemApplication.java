package com.wsn.conference.submission;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author leyao
 * @version 2018-7-12
 */
// @ComponentScan
// @Configuration
// @EnableAutoConfiguration
@SpringBootApplication
@EnableTransactionManagement
public class SubmissionSystemApplication {
    private static Logger logger = LoggerFactory.getLogger(SubmissionSystemApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SubmissionSystemApplication.class, args);
        logger.info("===== Hello World! ===== leyao =====");
    }

    /**
     * 跨域配置
     *
     * @return CorsConfiguration
     */
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 增加允许访问的域名
        // corsConfiguration.addAllowedOrigin("http://10.112.245.33:8088");
        // corsConfiguration.addAllowedOrigin("http://10.112.245.33:8888");
        // corsConfiguration.addAllowedOrigin("http://10.112.0.79:8088");
        corsConfiguration.addAllowedOrigin("*");

        // 设置跨域允许发送cookie，默认不允许
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    /**
     * 跨域过滤器
     *
     * @return CorsFilter
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}


