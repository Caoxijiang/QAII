package com.qaii.domain;

import java.util.Date;
import java.util.List;

public class SigningAgreement {
    private Integer id;

    private String directionCooperation;

    private String signingTime;

    private String colleageIncubator;

    private String cooperationUnit;

    private String remake;

    private Date createTime;

    private Date modifyTime;

    private List<SigningAgreementFiles> listFile;

    public List<SigningAgreementFiles> getListFile() {
        return listFile;
    }

    public void setListFile(List<SigningAgreementFiles> listFile) {
        this.listFile = listFile;
    }

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

    public String getSigningTime() {
        return signingTime;
    }

    public void setSigningTime(String signingTime) {
        this.signingTime = signingTime == null ? null : signingTime.trim();
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

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake == null ? null : remake.trim();
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