package com.zhy.shixi.controller;

import com.zhy.shixi.pojo.Company;
import com.zhy.shixi.service.CompanyService;
import com.zhy.shixi.util.Page4Navigator;
import com.zhy.shixi.util.Result;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by HeyYun
 * Date 2019/10/9
 */
@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/companies")
    public Result add(@RequestBody Company company){
        companyService.add(company);
        return Result.success();
    }

    @GetMapping("/companiesByPage")
    public Result list(@RequestParam(defaultValue = "0",value = "start")int start,
                       @RequestParam(defaultValue = "5",value = "size")int size){
        start =start < 0?0:start;
        Page4Navigator<Company> page =companyService.list(start,size,5);
        return Result.success(page);
    }

    @GetMapping("/companies")
    public Result list(){
        List<Company> companies = companyService.list();
        return Result.success(companies);
    }

    @PutMapping("/companies")
    public Result update(@RequestBody Company company){
        companyService.update(company);
        return Result.success();
    }

    @DeleteMapping("companies/{id}")
    public Result delete(@PathVariable int id){
        companyService.delete(id);
        return Result.success();
    }
}
