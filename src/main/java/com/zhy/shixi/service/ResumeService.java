package com.zhy.shixi.service;

import com.zhy.shixi.dao.ResumeDAO;
import com.zhy.shixi.dao.UserDAO;
import com.zhy.shixi.pojo.Resume;
import com.zhy.shixi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HeyYun
 * Date 2019/10/12
 */
@Service
public class ResumeService {

    @Autowired
    ResumeDAO resumeDAO;

    @Autowired
    UserDAO userDAO;

    public List<Resume> getByUserId(int userId) {
        User user = userDAO.getOne(userId);
        return resumeDAO.findByUser(user);
    }

    public Resume get(int resumeId) {
        return resumeDAO.getOne(resumeId);
    }

    public void delete(int resumeId) {
        resumeDAO.deleteById(resumeId);
    }

    public void add(Resume resume) {
        resumeDAO.save(resume);
    }
}
