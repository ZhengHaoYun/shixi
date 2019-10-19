package com.zhy.shixi.dao;

import com.zhy.shixi.pojo.Resume;
import com.zhy.shixi.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by HeyYun
 * Date 2019/10/12
 */
public interface ResumeDAO extends JpaRepository<Resume,Integer> {
    List<Resume> findByUser(User user);
}
