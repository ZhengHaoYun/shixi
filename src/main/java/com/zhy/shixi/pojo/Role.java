package com.zhy.shixi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by HeyYun
 * Date 2019/10/17
 */
@Entity
@Table(name = "role")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId")
    private int roleId;

    private String roleName;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;


    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
