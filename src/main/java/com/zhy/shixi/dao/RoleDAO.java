package com.zhy.shixi.dao;

import com.zhy.shixi.pojo.Role;
import com.zhy.shixi.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by HeyYun
 * Date 2019/10/17
 */
public interface RoleDAO extends JpaRepository<Role,Integer> {
    List<Role> findByUser(User user);
}
