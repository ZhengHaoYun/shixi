package com.zhy.shixi.controller;

import com.zhy.shixi.pojo.Department;
import com.zhy.shixi.service.DepartmentService;
import com.zhy.shixi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by HeyYun
 * Date 2019/10/9
 */
@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/departments")
    public Result list(){
        List<Department> departments = departmentService.list();
        return Result.success(departments);
    }
}
