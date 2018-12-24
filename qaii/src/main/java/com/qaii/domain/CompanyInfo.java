package com.qaii.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by kunpeng on 2018/12/10 14:50
 */
public class CompanyInfo {
    private Integer id;
    private Integer incubatorid;
    private String companyName;
    private String creditCode;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date establishTime;
    private String companyType;
    private String legalRepresentative;
    private String shareholderName;
    private String contributionProportion;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date contributionTime;
    private String shareholderPosition;

    public Integer getIncubatorid() {
        return incubatorid;
    }

    public void setIncubatorid(Integer incubatorid) {
        this.incubatorid = incubatorid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public Date getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(Date establishTime) {
        this.establishTime = establishTime;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getShareholderName() {
        return shareholderName;
    }

    public void setShareholderName(String shareholderName) {
        this.shareholderName = shareholderName;
    }

    public String getContributionProportion() {
        return contributionProportion;
    }

    public void setContributionProportion(String contributionProportion) {
        this.contributionProportion = contributionProportion;
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
        this.shareholderPosition = shareholderPosition;
    }

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", creditCode='" + creditCode + '\'' +
                ", establishTime=" + establishTime +
                ", companyType='" + companyType + '\'' +
                ", legalRepresentative='" + legalRepresentative + '\'' +
                ", shareholderName='" + shareholderName + '\'' +
                ", contributionProportion='" + contributionProportion + '\'' +
                ", contributionTime=" + contributionTime +
                ", shareholderPosition='" + shareholderPosition + '\'' +
                '}';
    }
}
