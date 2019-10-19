package com.zhy.shixi.dao;

import com.zhy.shixi.pojo.Category;
import com.zhy.shixi.pojo.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by HeyYun
 * Date 2019/10/9
 */
public interface PositionDAO extends JpaRepository<Position, Integer> {
    Page<Position> findByCategory(Category category, Pageable pageable);
}
