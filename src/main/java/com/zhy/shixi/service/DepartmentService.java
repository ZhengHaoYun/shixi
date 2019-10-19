package com.zhy.shixi.service;

import com.zhy.shixi.dao.DepartmentDAO;
import com.zhy.shixi.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HeyYun
 * Date 2019/10/9
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentDAO departmentDAO;

    public List<Department> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "depId");
        return departmentDAO.findAll(sort);
    }

    public Department get(int depId) {
        return departmentDAO.getOne(depId);
    }
}
