package com.qaii.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class AwardPersonal {
    private Integer id;

    private Integer pid;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date awardTime;

    private String awardLevel;

    private String personName;

    private String personUnit;

    private String awardName;

    private String activityName;

    private String orgnizer;

    private String alternativeOne;

    private String alternativeTwo;

    private String alternativeThree;

    private String remark;

    private Date gmtCreate;

    private Date gmtModified;

    private List<AwardPersonalFile> listFile;

    public List<AwardPersonalFile> getListFile() {
        return listFile;
    }

    public void setListFile(List<AwardPersonalFile> listFile) {
        this.listFile = listFile;
    }

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

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    public String getPersonUnit() {
        return personUnit;
    }

    public void setPersonUnit(String personUnit) {
        this.personUnit = personUnit == null ? null : personUnit.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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