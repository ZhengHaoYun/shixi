package com.zhy.shixi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by HeyYun
 * Date 2019/10/9
 */
@Entity
@Table(name = "resume")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resumeId")
    private int resumeId;

    private String resumeName;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setResumeName(String resumeName) {
        this.resumeName = resumeName;
    }

    public String getResumeName() {
        return resumeName;
    }
}
