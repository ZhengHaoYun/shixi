package com.zhy.shixi.dao;

import com.zhy.shixi.pojo.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by HeyYun
 * Date 2019/10/9
 */
public interface CompanyDAO extends JpaRepository<Company,Integer> {

}
