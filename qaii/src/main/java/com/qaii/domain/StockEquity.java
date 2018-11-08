package com.qaii.domain;

import java.util.Date;

public class StockEquity {
    private Integer id;

    private String shareholderName;

    private String contributionAmount;

    private String contributionProportion;

    private Date contributionTime;

    private String shareholderPosition;

    private String remark;

    private String alternativeOne;

    private String alternativeTwo;

    private String alternativeThreee;

    private Date gmtCreate;

    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShareholderName() {
        return shareholderName;
    }

    public void setShareholderName(String shareholderName) {
        this.shareholderName = shareholderName == null ? null : shareholderName.trim();
    }

    public String getContributionAmount() {
        return contributionAmount;
    }

    public void setContributionAmount(String contributionAmount) {
        this.contributionAmount = contributionAmount == null ? null : contributionAmount.trim();
    }

    public String getContributionProportion() {
        return contributionProportion;
    }

    public void setContributionProportion(String contributionProportion) {
        this.contributionProportion = contributionProportion == null ? null : contributionProportion.trim();
    }

    public Date getContributionTime() {
        return contributionTime;
    }

    public void setContributionTime(Date contributionTime) {
        this.contributionTime = contributionTime;
    }

    public String getShareholderPosition() {
        return shareholderPosition;
    }

    public void setShareholderPosition(String shareholderPosition) {
        this.shareholderPosition = shareholderPosition == null ? null : shareholderPosition.trim();
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

    public String getAlternativeThreee() {
        return alternativeThreee;
    }

    public void setAlternativeThreee(String alternativeThreee) {
        this.alternativeThreee = alternativeThreee == null ? null : alternativeThreee.trim();
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