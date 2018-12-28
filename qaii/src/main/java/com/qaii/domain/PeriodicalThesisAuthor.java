package com.qaii.domain;

public class PeriodicalThesisAuthor {
    private Integer id;

    private String authorName;

    private String authorLevel;

    private String authorUnit;

    private String authorDetails;

    private String authorRemark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public String getAuthorLevel() {
        return authorLevel;
    }

    public void setAuthorLevel(String authorLevel) {
        this.authorLevel = authorLevel == null ? null : authorLevel.trim();
    }

    public String getAuthorUnit() {
        return authorUnit;
    }

    public void setAuthorUnit(String authorUnit) {
        this.authorUnit = authorUnit == null ? null : authorUnit.trim();
    }

    public String getAuthorDetails() {
        return authorDetails;
    }

    public void setAuthorDetails(String authorDetails) {
        this.authorDetails = authorDetails == null ? null : authorDetails.trim();
    }

    public String getAuthorRemark() {
        return authorRemark;
    }

    public void setAuthorRemark(String authorRemark) {
        this.authorRemark = authorRemark == null ? null : authorRemark.trim();
    }
}