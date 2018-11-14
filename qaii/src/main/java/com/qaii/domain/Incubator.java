package com.qaii.domain;

import java.util.Date;

public class Incubator {
    private Integer id;

    private Integer pid;

    private String companyName;

    private String creditCode;

    private Date establishTime;

    private String companyType;

    private String companyLocation;

    private String legalRepresentative;

    private String registeredCapital;

    private String businessScope;

    private String incubatorName;

    private Date hatchingTime;

    private String businessLisence;

    private String changes;

    private String limitedPeriod;

    private Byte isThousandSailEnterprise;

    private Byte isHighTechnologyEnterprise;

    private Byte isTechnologyEnterprise;

    private Byte isBillionEnterprise;

    private Date certificateTime;

    private String certificateCode;

    private Integer annexId;

    private String incomingRegistrationCode;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode == null ? null : creditCode.trim();
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
        this.companyType = companyType == null ? null : companyType.trim();
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation == null ? null : companyLocation.trim();
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative == null ? null : legalRepresentative.trim();
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital == null ? null : registeredCapital.trim();
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    public String getIncubatorName() {
        return incubatorName;
    }

    public void setIncubatorName(String incubatorName) {
        this.incubatorName = incubatorName == null ? null : incubatorName.trim();
    }

    public Date getHatchingTime() {
        return hatchingTime;
    }

    public void setHatchingTime(Date hatchingTime) {
        this.hatchingTime = hatchingTime;
    }

    public String getBusinessLisence() {
        return businessLisence;
    }

    public void setBusinessLisence(String businessLisence) {
        this.businessLisence = businessLisence == null ? null : businessLisence.trim();
    }

    public String getChange() {
        return changes;
    }

    public void setChange(String change) {
        this.changes = change == null ? null : change.trim();
    }

    public String getLimitedPeriod() {
        return limitedPeriod;
    }

    public void setLimitedPeriod(String limitedPeriod) {
        this.limitedPeriod = limitedPeriod == null ? null : limitedPeriod.trim();
    }

    public Byte getIsThousandSailEnterprise() {
        return isThousandSailEnterprise;
    }

    public void setIsThousandSailEnterprise(Byte isThousandSailEnterprise) {
        this.isThousandSailEnterprise = isThousandSailEnterprise;
    }

    public Byte getIsHighTechnologyEnterprise() {
        return isHighTechnologyEnterprise;
    }

    public void setIsHighTechnologyEnterprise(Byte isHighTechnologyEnterprise) {
        this.isHighTechnologyEnterprise = isHighTechnologyEnterprise;
    }

    public Byte getIsTechnologyEnterprise() {
        return isTechnologyEnterprise;
    }

    public void setIsTechnologyEnterprise(Byte isTechnologyEnterprise) {
        this.isTechnologyEnterprise = isTechnologyEnterprise;
    }

    public Byte getIsBillionEnterprise() {
        return isBillionEnterprise;
    }

    public void setIsBillionEnterprise(Byte isBillionEnterprise) {
        this.isBillionEnterprise = isBillionEnterprise;
    }

    public Date getCertificateTime() {
        return certificateTime;
    }

    public void setCertificateTime(Date certificateTime) {
        this.certificateTime = certificateTime;
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode == null ? null : certificateCode.trim();
    }

    public Integer getAnnexId() {
        return annexId;
    }

    public void setAnnexId(Integer annexId) {
        this.annexId = annexId;
    }

    public String getIncomingRegistrationCode() {
        return incomingRegistrationCode;
    }

    public void setIncomingRegistrationCode(String incomingRegistrationCode) {
        this.incomingRegistrationCode = incomingRegistrationCode == null ? null : incomingRegistrationCode.trim();
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