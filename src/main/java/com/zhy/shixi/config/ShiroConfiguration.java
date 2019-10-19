package com.zhy.shixi.config;

import com.zhy.shixi.filter.URLPathMatchingFilter;
import com.zhy.shixi.realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by HeyYun
 * Date 2019/10/8
 */
@Configuration
public class ShiroConfiguration {
    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //登陆成功要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权跳转的链接
        shiroFilterFactoryBean.setUnauthorizedUrl("/userLogin");
        //拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        //自定义拦截器
        Map<String, Filter> customisedFilter = new HashMap<>();
        customisedFilter.put("url",  getURLPathMatchingFilter());

        //配置映射关系
        filterChainDefinitionMap.put("/userLogin", "anon");
        filterChainDefinitionMap.put("/userRegister", "anon");
        filterChainDefinitionMap.put("/index", "anon");
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/style/**", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/positions", "anon");
        filterChainDefinitionMap.put("/departments", "anon");
        filterChainDefinitionMap.put("/categories", "anon");
        filterChainDefinitionMap.put("/user/**", "anon");
        filterChainDefinitionMap.put("/config/**", "anon");
        filterChainDefinitionMap.put("/logout", "logout");
        ;
        filterChainDefinitionMap.put("/**", "url");
        shiroFilterFactoryBean.setFilters(customisedFilter);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;

    }

    public URLPathMatchingFilter getURLPathMatchingFilter() {
        return new URLPathMatchingFilter();
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getUserRealm());
        return securityManager;
    }

    @Bean
    public UserRealm getUserRealm() {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }


    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }

    /**
     * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
