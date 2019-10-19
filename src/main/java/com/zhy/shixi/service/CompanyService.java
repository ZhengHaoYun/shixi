package com.zhy.shixi.service;

import com.zhy.shixi.dao.CompanyDAO;
import com.zhy.shixi.pojo.Company;
import com.zhy.shixi.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HeyYun
 * Date 2019/10/9
 */
@Service
public class CompanyService {
    @Autowired
    CompanyDAO companyDAO;

    public Page4Navigator<Company> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "companyId");
        Page page = companyDAO.findAll(PageRequest.of(start, size, sort));
        return new Page4Navigator<>(page, navigatePages);
    }

    public List<Company> list() {
        return companyDAO.findAll();
    }

    public void add(Company company) {
        companyDAO.save(company);
    }

    public void delete(Integer companyId) {
        companyDAO.deleteById(companyId);
    }

    @CacheEvict(allEntries = true)
    public void update(Company company) {
        companyDAO.save(company);
    }
}
