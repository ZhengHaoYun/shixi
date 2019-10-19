package com.zhy.shixi.service;

import com.zhy.shixi.dao.CategoryDAO;
import com.zhy.shixi.dao.FavorDAO;
import com.zhy.shixi.dao.PositionDAO;
import com.zhy.shixi.pojo.Category;
import com.zhy.shixi.pojo.Company;
import com.zhy.shixi.pojo.Position;
import com.zhy.shixi.pojo.User;
import com.zhy.shixi.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HeyYun
 * Date 2019/10/9
 */
@Service
public class PositionService {

    @Autowired
    PositionDAO positionDAO;

    @Autowired
    CategoryDAO categoryDAO;

    @Autowired
    FavorDAO favorDAO;

    public Page4Navigator<Position> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "positionId");
        Page page = positionDAO.findAll(PageRequest.of(start, size, sort));
        return new Page4Navigator<>(page, navigatePages);
    }

    public List<Position> list() {
        return positionDAO.findAll();
    }

    public Page4Navigator<Position> listByCategory(int cid, int start, int size, int navigatePages) {
        Category category = categoryDAO.getOne(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "positionId");
        Page<Position> pageFromJPA = positionDAO.findByCategory(category, PageRequest.of(start, size, sort));
        return new Page4Navigator<>(pageFromJPA, navigatePages);
    }

    public Position get(int pid) {
        Position position = positionDAO.getOne(pid);
        return position;
    }

    public boolean isFavor(Position position, User user) {
        return favorDAO.findByPositionAndUser(position,user) != null;
    }


}
