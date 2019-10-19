package com.zhy.shixi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by HeyYun
 * Date 2019/10/9
 */
@Entity
@Table(name = "favor")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Favor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorId")
    private int favorId;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    @OneToOne
    @JoinColumn(name = "pid")
    private Position position;

    public int getFavorId() {
        return favorId;
    }

    public void setFavorId(int favorId) {
        this.favorId = favorId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
