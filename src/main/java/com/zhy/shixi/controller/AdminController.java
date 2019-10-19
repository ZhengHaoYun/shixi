package com.zhy.shixi.controller;

import com.zhy.shixi.pojo.Admin;
import com.zhy.shixi.service.AdminService;
import com.zhy.shixi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

/**
 * Created by HeyYun
 * Date 2019/10/16
 */
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/admin/login")
    public Result login(@RequestBody Admin admin,HttpSession session) {
        if (null == admin.getUsername()) {
            return Result.fail("请输入用户名");
        } else if (null == admin.getPassword()) {
            return Result.fail("请输入密码");
        }
        String username = admin.getUsername();
        username = HtmlUtils.htmlEscape(username);
        Admin admin1 = adminService.get(username);
        if (null == admin1) {
            return Result.fail("抱歉，您还不是管理员");
        }
        if (!admin1.getPassword().equals(admin.getPassword())) {
            return Result.fail("账户或者密码错误");
        }
        session.setAttribute("admin",admin);
        return Result.success();
    }
}
