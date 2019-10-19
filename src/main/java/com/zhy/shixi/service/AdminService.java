package com.zhy.shixi.service;

import com.zhy.shixi.dao.AdminDAO;
import com.zhy.shixi.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by HeyYun
 * Date 2019/10/8
 */
@Service
public class AdminService {

    @Autowired
    AdminDAO adminDAO;

    public Admin get(String username){
        return adminDAO.getByUsername(username);
    }

}
