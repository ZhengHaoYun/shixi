package com.zhy.shixi.service;

import com.zhy.shixi.dao.CategoryDAO;
import com.zhy.shixi.pojo.Category;
import com.zhy.shixi.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

/**
 * Created by HeyYun
 * Date 2019/10/10
 */
@Service
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> listByDepartment(Department department){
        return categoryDAO.findByDepartment(department);
    }

    public List<Category> list(){
        return categoryDAO.findAll();
    }

    public Category get(int cid) {
        return categoryDAO.getOne(cid);
    }
}
