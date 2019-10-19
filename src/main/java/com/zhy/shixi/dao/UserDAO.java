package com.zhy.shixi.dao;

import com.zhy.shixi.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by HeyYun
 * Date 2019/10/8
 */
public interface UserDAO extends JpaRepository<User,Integer> {
    User getUserByEmail(String email);
}
