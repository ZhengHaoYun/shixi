package com.zhy.shixi.dao;

import com.zhy.shixi.pojo.Favor;
import com.zhy.shixi.pojo.Position;
import com.zhy.shixi.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by HeyYun
 * Date 2019/10/13
 */
public interface FavorDAO extends JpaRepository<Favor, Integer> {
    List<Favor> findByUser(User user);

    Favor findByPositionAndUser(Position position, User user);

}
