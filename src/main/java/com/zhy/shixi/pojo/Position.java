package com.zhy.shixi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by HeyYun
 * Date 2019/10/9
 */
@Entity
@Table(name = "position")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "positionId")
    private int positionId;
    private String title;
    private String requirement;
    private int quantity;
    private String workCity;
    private int salaryUp;
    private int salaryDown;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;

    @Transient
    private boolean isFavor;

    public boolean isFavor() {
        return isFavor;
    }

    public void setFavor(boolean favor) {
        isFavor = favor;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getWorkCity() {
        return workCity;
    }

    public void setWorkCity(String workCity) {
        this.workCity = workCity;
    }

    public int getSalaryUp() {
        return salaryUp;
    }

    public void setSalaryUp(int salaryUp) {
        this.salaryUp = salaryUp;
    }

    public int getSalaryDown() {
        return salaryDown;
    }

    public void setSalaryDown(int salaryDown) {
        this.salaryDown = salaryDown;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
