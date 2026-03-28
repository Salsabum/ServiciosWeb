//package com.trabajo.gateway_service;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FilterConfig {
//
//    @Bean
//    public FilterRegistrationBean<JwtFilter> jwtFilter() {
//        FilterRegistrationBean<JwtFilter> registration = new FilterRegistrationBean<>();
//        registration.setFilter(new JwtFilter());
//        registration.addUrlPatterns("/datos"); // solo protege esta ruta
//        return registration;
//    }
//}
