package com.qaii.domain;

import java.util.Date;
import java.util.List;

public class IndustryAttendMeeting {
    private Integer id;

    private String conferenceType;

    private String participant;

    private String conferenceName;

    private String reportTopics;

    private String meetingAddress;

    private String meetingTime;

    private String remark;

    private Date createTime;

    private Date modifyTime;

    private List<IndustryAttendMeetingFiles> listFile;

    public List<IndustryAttendMeetingFiles> getListFile() {
        return listFile;
    }

    public void setListFile(List<IndustryAttendMeetingFiles> listFile) {
        this.listFile = listFile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConferenceType() {
        return conferenceType;
    }

    public void setConferenceType(String conferenceType) {
        this.conferenceType = conferenceType == null ? null : conferenceType.trim();
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant == null ? null : participant.trim();
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName == null ? null : conferenceName.trim();
    }

    public String getReportTopics() {
        return reportTopics;
    }

    public void setReportTopics(String reportTopics) {
        this.reportTopics = reportTopics == null ? null : reportTopics.trim();
    }

    public String getMeetingAddress() {
        return meetingAddress;
    }

    public void setMeetingAddress(String meetingAddress) {
        this.meetingAddress = meetingAddress == null ? null : meetingAddress.trim();
    }

    public String getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime == null ? null : meetingTime.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}