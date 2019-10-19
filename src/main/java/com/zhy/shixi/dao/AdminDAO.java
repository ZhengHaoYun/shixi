package com.zhy.shixi.dao;

import com.zhy.shixi.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by HeyYun
 * Date 2019/10/8
 */
public interface AdminDAO extends JpaRepository<Admin,Integer> {
    Admin getByUsername(String username);

}
