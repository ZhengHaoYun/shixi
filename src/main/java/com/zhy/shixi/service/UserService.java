package com.zhy.shixi.service;

import com.zhy.shixi.dao.UserDAO;
import com.zhy.shixi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.Id;

/**
 * Created by HeyYun
 * Date 2019/10/8
 */
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public void add(User user) {
        userDAO.save(user);
    }

    public void delete(int userId) {
        userDAO.deleteById(userId);
    }

    public void update(User user) {
        userDAO.save(user);
    }

    public User get(int userId) {
        return userDAO.getOne(userId);
    }

    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    public boolean isExist(String email) {
        return getUserByEmail(email) != null;
    }
}
