package com.zhy.shixi.service;

import com.zhy.shixi.dao.RoleDAO;
import com.zhy.shixi.pojo.Role;
import com.zhy.shixi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HeyYun
 * Date 2019/10/17
 */
@Service
public class RoleService {

    @Autowired
    RoleDAO roleDAO;

    public List<Role> listByUser(User user) {
        return roleDAO.findByUser(user);
    }
}
