package com.zhy.shixi.dao;

import com.zhy.shixi.pojo.Category;
import com.zhy.shixi.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by HeyYun
 * Date 2019/10/10
 */
public interface CategoryDAO extends JpaRepository<Category,Integer> {
    List<Category> findByDepartment(Department department);
}
