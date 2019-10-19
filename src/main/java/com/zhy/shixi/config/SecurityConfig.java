//package com.zhy.shixi.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by HeyYun
// * Date 2019/10/14
// */
//@Configuration
//public class SecurityConfig extends WebMvcConfig {
//    @Bean
//    public SecurityInterceptor getSecurityInterceptor() {
//        return new SecurityInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
//        List<String> urls = new ArrayList<>();
//        urls.add("/positionList");
//        urls.add("/companyList");
//        urls.add("/resume");
//        urls.add("/favorList");
//        urls.add("/position");
//        addInterceptor.addPathPatterns(urls);
//    }
//
//    private class SecurityInterceptor extends HandlerInterceptorAdapter {
//
//        @Override
//        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//                throws Exception {
//            HttpSession session = request.getSession();
//            if (session.getAttribute("user") != null) {
//                return true;
//            }
//            // 跳转登录
//            String url = "/userLogin";
//            response.sendRedirect(url);
//            return false;
//        }
//
//
//    }
//}
