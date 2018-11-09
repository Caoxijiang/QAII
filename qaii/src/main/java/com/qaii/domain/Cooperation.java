package com.qaii.domain;

import java.util.Date;
import java.util.List;

public class Cooperation {
    private Integer id;

    private String unitName;

    private String cooperationName;

    private String protocolName;

    private Date signTime;

    private String cooperationContent;

    private Integer fid;

    private String remark;

    private String alternativeOne;

    private String alternativeTwo;

    private String alternativeThree;

    private Date gmtCreate;

    private Date gmtModified;

    private List<CooperationFile> listFile;

    public List<CooperationFile> getListFile() {
        return listFile;
    }

    public void setListFile(List<CooperationFile> listFile) {
        this.listFile = listFile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public String getCooperationName() {
        return cooperationName;
    }

    public void setCooperationName(String cooperationName) {
        this.cooperationName = cooperationName == null ? null : cooperationName.trim();
    }

    public String getProtocolName() {
        return protocolName;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName == null ? null : protocolName.trim();
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public String getCooperationContent() {
        return cooperationContent;
    }

    public void setCooperationContent(String cooperationContent) {
        this.cooperationContent = cooperationContent == null ? null : cooperationContent.trim();
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getAlternativeOne() {
        return alternativeOne;
    }

    public void setAlternativeOne(String alternativeOne) {
        this.alternativeOne = alternativeOne == null ? null : alternativeOne.trim();
    }

    public String getAlternativeTwo() {
        return alternativeTwo;
    }

    public void setAlternativeTwo(String alternativeTwo) {
        this.alternativeTwo = alternativeTwo == null ? null : alternativeTwo.trim();
    }

    public String getAlternativeThree() {
        return alternativeThree;
    }

    public void setAlternativeThree(String alternativeThree) {
        this.alternativeThree = alternativeThree == null ? null : alternativeThree.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}