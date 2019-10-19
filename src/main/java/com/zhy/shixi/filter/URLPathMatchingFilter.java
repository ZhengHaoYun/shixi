package com.zhy.shixi.filter;

import com.zhy.shixi.pojo.Role;
import com.zhy.shixi.pojo.User;
import com.zhy.shixi.service.RoleService;
import com.zhy.shixi.service.UserService;
import com.zhy.shixi.util.SpringContextUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.List;

public class URLPathMatchingFilter extends PathMatchingFilter {
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {
        if (null == roleService)
            roleService = SpringContextUtils.getContext().getBean(RoleService.class);
        if (null == userService)
            userService = SpringContextUtils.getContext().getBean(UserService.class);
        String requestURI = getPathWithinApplication(request);
        System.out.println("requestURI:" + requestURI);

        Subject subject = SecurityUtils.getSubject();
        // 如果没有登录，就跳转到登录页面
        if (!subject.isAuthenticated()) {
            WebUtils.issueRedirect(request, response, "/userLogin");
            return false;
        }
        String url = "/admin/listCompany";
        boolean needInterceptor = (requestURI.equals(url));
        if (!needInterceptor) {
            return true;
        } else {
            String username = subject.getPrincipal().toString();
            User user = userService.getUserByEmail(username);
            List<Role> roles = roleService.listByUser(user);
            for (Role role : roles) {
                if (role.getRoleName().equals("admin")) {
                    return true;
                }
            }
            UnauthorizedException ex = new UnauthorizedException("不好意思，您不是管理员");
            subject.getSession().setAttribute("ex", ex);
            WebUtils.issueRedirect(request, response, "/userLogin");
            return false;
        }

    }

}