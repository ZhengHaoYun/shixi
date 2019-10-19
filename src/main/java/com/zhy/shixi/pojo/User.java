package com.zhy.shixi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Created by HeyYun
 * Date 2019/10/8
 */

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;
    private String salt;
    @Column(name = "email")
    private String email;
    private String password;
    private String name;
    private String school;
    private String major;
    private String mobile;
    //毕业年份
    private int graYear;


    @Transient
    private List<Resume> resumes;

    @Transient
    private List<Favor> favors;

    public List<Favor> getFavors() {
        return favors;
    }

    public void setFavors(List<Favor> favors) {
        this.favors = favors;
    }

    public List<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(List<Resume> resumes) {
        this.resumes = resumes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGraYear() {
        return graYear;
    }

    public void setGraYear(int graYear) {
        this.graYear = graYear;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public User() {
    }


}
