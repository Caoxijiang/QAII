package com.qaii.domain;

import java.util.Date;
import java.util.List;

public class PeriodicalThesis {
    private Long id;

    private String topic;

    private String author;

    private String authorUnit;

    private String publishtime;

    private String periodicalName;

    private String pageNumber;

    private String keyword;

    private String englishSummary;

    private String contentType;

    private String recordType;

    private String level;

    private String unit;

    private Byte isPass;

    private Date gmtCreate;

    private Date gmtModified;
    
    private List<PeriodicalThesisFile> listFile;

    private List<PeriodicalThesisAuthor> listAuthor;

    public List<PeriodicalThesisAuthor> getListAuthor() {
        return listAuthor;
    }

    public void setListAuthor(List<PeriodicalThesisAuthor> listAuthor) {
        this.listAuthor = listAuthor;
    }

    public List<PeriodicalThesisFile> getListFile() {
		return listFile;
	}

	public void setListFile(List<PeriodicalThesisFile> listFile) {
		this.listFile = listFile;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic == null ? null : topic.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getAuthorUnit() {
        return authorUnit;
    }

    public void setAuthorUnit(String authorUnit) {
        this.authorUnit = authorUnit == null ? null : authorUnit.trim();
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime == null ? null : publishtime.trim();
    }

    public String getPeriodicalName() {
        return periodicalName;
    }

    public void setPeriodicalName(String periodicalName) {
        this.periodicalName = periodicalName == null ? null : periodicalName.trim();
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber == null ? null : pageNumber.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getEnglishSummary() {
        return englishSummary;
    }

    public void setEnglishSummary(String englishSummary) {
        this.englishSummary = englishSummary == null ? null : englishSummary.trim();
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType == null ? null : contentType.trim();
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType == null ? null : recordType.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Byte getIsPass() {
        return isPass;
    }

    public void setIsPass(Byte isPass) {
        this.isPass = isPass;
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