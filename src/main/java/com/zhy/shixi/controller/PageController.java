package com.zhy.shixi.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by HeyYun
 * Date 2019/10/8
 */
@Controller
public class PageController {

    /* 后台部分 */
    @GetMapping(value = "/admin/listCompany")
    public String listCompany(HttpSession session) {
        return "admin/listCompany";
    }

    @GetMapping(value = "/adminLogin")
    public String adminLogin() {
        return "admin/adminLogin";
    }


    /* 前端部分 */
    @GetMapping(value = "/userLogin")
    public String userLogin() {
        return "login";
    }

    @GetMapping(value = "/userRegister")
    public String userRegister() {
        return "register";
    }

    @GetMapping(value = "/index")
    public String home1() {
        return "index";
    }

    @GetMapping(value = "/")
    public String home2() {
        return "index";
    }

    @GetMapping(value = "/positionList")
    public String positionList() {
        return "list";
    }

    @GetMapping(value = "/companyList")
    public String companyList() {
        return "companyList";
    }

    @GetMapping(value = "/resume")
    public String resume() {
        return "resume";
    }

    @GetMapping(value = "/position")
    public String jobdetail() {
        return "jobdetail";
    }

    @GetMapping(value = "/favorList")
    public String favorList() {
        return "favorlist";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        session.removeAttribute("user");
        return "redirect:/index";
    }
}
