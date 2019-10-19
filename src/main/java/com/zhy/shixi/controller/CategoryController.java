package com.zhy.shixi.controller;

import com.zhy.shixi.pojo.Category;
import com.zhy.shixi.pojo.Department;
import com.zhy.shixi.service.CategoryService;
import com.zhy.shixi.service.DepartmentService;
import com.zhy.shixi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by HeyYun
 * Date 2019/10/10
 */
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/categories/{depId}")
    public Result listByDepartment(@PathVariable("depId") int depId) {
        Department department = departmentService.get(depId);
        List<Category> categories = categoryService.listByDepartment(department);
        return Result.success(categories);
    }

    @GetMapping("/categories")
    public Result list() {
        return Result.success(categoryService.list());
    }

}
