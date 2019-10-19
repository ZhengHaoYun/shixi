package com.zhy.shixi.realm;

import com.zhy.shixi.pojo.Role;
import com.zhy.shixi.pojo.User;
import com.zhy.shixi.service.RoleService;
import com.zhy.shixi.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by HeyYun
 * Date 2019/10/8
 */
public class UserRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        // 通过service获取角色
        User user = userService.getUserByEmail(userName);
        List<Role> roles = roleService.listByUser(user);
        Set<String> roleNames = new HashSet<>();
        for (Role role : roles) {
            roleNames.add(role.getRoleName());
        }
        // 授权对象
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        // 把通过service获取到的放进去
        s.setRoles(roleNames);
        return s;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        User user = userService.getUserByEmail(username);
        String passwordInDB = user.getPassword();
        String salt = user.getSalt();
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, passwordInDB, ByteSource.Util.bytes(salt),
                getName());
        return authenticationInfo;
    }
}
