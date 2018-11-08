package com.qaii.domain;

import java.util.Date;

public class Ministry {
    private Integer id;

    private String ministryName;

    private String ministryProperty;

    private String contactPerson;

    private String contactMethod;

    private String ministryLocation;

    private Date ministryTime;

    private String ministryProject;

    private String ownselfUnit;

    private String ownselfContactPerson;

    private String ownselfContactMethod;

    private Integer fid;

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

    public String getMinistryName() {
        return ministryName;
    }

    public void setMinistryName(String ministryName) {
        this.ministryName = ministryName == null ? null : ministryName.trim();
    }

    public String getMinistryProperty() {
        return ministryProperty;
    }

    public void setMinistryProperty(String ministryProperty) {
        this.ministryProperty = ministryProperty == null ? null : ministryProperty.trim();
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson == null ? null : contactPerson.trim();
    }

    public String getContactMethod() {
        return contactMethod;
    }

    public void setContactMethod(String contactMethod) {
        this.contactMethod = contactMethod == null ? null : contactMethod.trim();
    }

    public String getMinistryLocation() {
        return ministryLocation;
    }

    public void setMinistryLocation(String ministryLocation) {
        this.ministryLocation = ministryLocation == null ? null : ministryLocation.trim();
    }

    public Date getMinistryTime() {
        return ministryTime;
    }

    public void setMinistryTime(Date ministryTime) {
        this.ministryTime = ministryTime;
    }

    public String getMinistryProject() {
        return ministryProject;
    }

    public void setMinistryProject(String ministryProject) {
        this.ministryProject = ministryProject == null ? null : ministryProject.trim();
    }

    public String getOwnselfUnit() {
        return ownselfUnit;
    }

    public void setOwnselfUnit(String ownselfUnit) {
        this.ownselfUnit = ownselfUnit == null ? null : ownselfUnit.trim();
    }

    public String getOwnselfContactPerson() {
        return ownselfContactPerson;
    }

    public void setOwnselfContactPerson(String ownselfContactPerson) {
        this.ownselfContactPerson = ownselfContactPerson == null ? null : ownselfContactPerson.trim();
    }

    public String getOwnselfContactMethod() {
        return ownselfContactMethod;
    }

    public void setOwnselfContactMethod(String ownselfContactMethod) {
        this.ownselfContactMethod = ownselfContactMethod == null ? null : ownselfContactMethod.trim();
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