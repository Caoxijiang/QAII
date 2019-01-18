package com.qaii.domain;

import java.util.Date;

public class SigningAgreement {
    private Integer id;

    private String directionCooperation;

    private Date signingTime;

    private String colleageIncubator;

    private String cooperationUnit;

    private Date createTime;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDirectionCooperation() {
        return directionCooperation;
    }

    public void setDirectionCooperation(String directionCooperation) {
        this.directionCooperation = directionCooperation == null ? null : directionCooperation.trim();
    }

    public Date getSigningTime() {
        return signingTime;
    }

    public void setSigningTime(Date signingTime) {
        this.signingTime = signingTime;
    }

    public String getColleageIncubator() {
        return colleageIncubator;
    }

    public void setColleageIncubator(String colleageIncubator) {
        this.colleageIncubator = colleageIncubator == null ? null : colleageIncubator.trim();
    }

    public String getCooperationUnit() {
        return cooperationUnit;
    }

    public void setCooperationUnit(String cooperationUnit) {
        this.cooperationUnit = cooperationUnit == null ? null : cooperationUnit.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}