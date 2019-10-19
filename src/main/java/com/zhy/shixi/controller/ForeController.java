package com.zhy.shixi.controller;

import com.zhy.shixi.pojo.User;
import com.zhy.shixi.service.UserService;
import com.zhy.shixi.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

/**
 * Created by HeyYun
 * Date 2019/10/8
 */
@RestController
public class ForeController {

    @Autowired
    UserService userService;

    @PostMapping("/user/register")
    public Result regitster(@RequestBody User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        if (null == email) {
            return Result.fail("请输入邮箱地址");
        }
        if (null == email) {
            return Result.fail("请输入密码");
        }
        email = HtmlUtils.htmlEscape(email);
        user.setEmail(email);
        boolean exist = userService.isExist(email);
        if (exist) {
            String message = "用户名已经被使用,不能使用";
            return Result.fail(message);
        }

        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";

        String encodedPassword = new SimpleHash(algorithmName, password, salt, times).toString();

        user.setSalt(salt);
        user.setPassword(encodedPassword);

        userService.add(user);

        return Result.success();
    }

    @PostMapping("/user/login")
    public Result login(@RequestBody User user) {
        if (null == user.getEmail()) {
            return Result.fail("请输入邮箱地址");
        }
        if (null == user.getPassword()) {
            return Result.fail("请输入密码");
        }
        String email = user.getEmail();
        email = HtmlUtils.htmlEscape(email);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(email, user.getPassword());
        try {
            subject.login(token);
            subject.getSession().setAttribute("user", userService.getUserByEmail(email));
            return Result.success();
        } catch (AuthenticationException e) {
            String message = "账号或者密码错误！";
            return Result.fail(message);
        }
    }


}
