package com.zhy.shixi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by HeyYun
 * Date 2019/10/8
 */

@Entity
@Table(name = "admin")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adminId")
    private int adminId;

    private String username;

    private String password;


    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Admin() {
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }



}
