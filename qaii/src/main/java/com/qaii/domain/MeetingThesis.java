package com.qaii.domain;

import java.util.Date;
import java.util.List;

public class MeetingThesis {
    private Long id;

    private String topic;

    private String author;

    private String authorUnit;

    private String publishtime;

    private String meetingName;

    private String meetingLocation;

    private String keyword;

    private String communicateAuthor;

    private String englishSummary;

    private String meetingRecord;

    private String contentType;

    private String unit;

    private Byte isPass;

    private Date gmtCreate;

    private Date gmtModified;
    
    private List<MeetingThesisFile> listFile;

    public List<MeetingThesisFile> getListFile() {
		return listFile;
	}

	public void setListFile(List<MeetingThesisFile> listFile) {
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

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName == null ? null : meetingName.trim();
    }

    public String getMeetingLocation() {
        return meetingLocation;
    }

    public void setMeetingLocation(String meetingLocation) {
        this.meetingLocation = meetingLocation == null ? null : meetingLocation.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getCommunicateAuthor() {
        return communicateAuthor;
    }

    public void setCommunicateAuthor(String communicateAuthor) {
        this.communicateAuthor = communicateAuthor == null ? null : communicateAuthor.trim();
    }

    public String getEnglishSummary() {
        return englishSummary;
    }

    public void setEnglishSummary(String englishSummary) {
        this.englishSummary = englishSummary == null ? null : englishSummary.trim();
    }

    public String getMeetingRecord() {
        return meetingRecord;
    }

    public void setMeetingRecord(String meetingRecord) {
        this.meetingRecord = meetingRecord == null ? null : meetingRecord.trim();
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType == null ? null : contentType.trim();
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