package com.zhy.shixi.service;

import com.zhy.shixi.dao.FavorDAO;
import com.zhy.shixi.pojo.Favor;
import com.zhy.shixi.pojo.Position;
import com.zhy.shixi.pojo.Resume;
import com.zhy.shixi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HeyYun
 * Date 2019/10/13
 */
@Service
public class FavorService {

    @Autowired
    FavorDAO favorDAO;

    public List<Favor> listByUser(User user) {
        return favorDAO.findByUser(user);
    }

    public void add(Favor favor) {
        favorDAO.save(favor);
    }

    public void delete(Favor favor) {
        favorDAO.delete(favor);
    }

    public Favor getByPositionAndUser(Position position, User user) {
        return favorDAO.findByPositionAndUser(position, user);
    }
}
