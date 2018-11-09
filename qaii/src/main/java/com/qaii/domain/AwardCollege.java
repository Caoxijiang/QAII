package com.qaii.domain;

import java.util.Date;

public class AwardCollege {
    private Integer id;

    private Integer pid;

    private Date awardTime;

    private String awardLevel;

    private String awardUnit;

    private String awardName;

    private String activityName;

    private String orgnizer;

    private String remark;

    private String alternativeOne;

    private String alternativeTwo;

    private String alternativeThree;

    private Date gmtCreate;

    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getAwardTime() {
        return awardTime;
    }

    public void setAwardTime(Date awardTime) {
        this.awardTime = awardTime;
    }

    public String getAwardLevel() {
        return awardLevel;
    }

    public void setAwardLevel(String awardLevel) {
        this.awardLevel = awardLevel == null ? null : awardLevel.trim();
    }

    public String getAwardUnit() {
        return awardUnit;
    }

    public void setAwardUnit(String awardUnit) {
        this.awardUnit = awardUnit == null ? null : awardUnit.trim();
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName == null ? null : awardName.trim();
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getOrgnizer() {
        return orgnizer;
    }

    public void setOrgnizer(String orgnizer) {
        this.orgnizer = orgnizer == null ? null : orgnizer.trim();
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