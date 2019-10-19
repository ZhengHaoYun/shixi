package com.zhy.shixi;

import com.zhy.shixi.pojo.Category;
import com.zhy.shixi.pojo.Position;
import com.zhy.shixi.service.CategoryService;
import com.zhy.shixi.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShixiApplicationTests {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    CategoryService categoryService;

    @Test
    public void test() {

    }

}
