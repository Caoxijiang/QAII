package com.qaii.domain;

import java.util.Date;

public class ExchangeTalks {
    private Integer id;

    private String participant;

    private String targetAudience;

    private String themeTalks;

    private String talksAddress;

    private Date talksTime;

    private Date createTime;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant == null ? null : participant.trim();
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience == null ? null : targetAudience.trim();
    }

    public String getThemeTalks() {
        return themeTalks;
    }

    public void setThemeTalks(String themeTalks) {
        this.themeTalks = themeTalks == null ? null : themeTalks.trim();
    }

    public String getTalksAddress() {
        return talksAddress;
    }

    public void setTalksAddress(String talksAddress) {
        this.talksAddress = talksAddress == null ? null : talksAddress.trim();
    }

    public Date getTalksTime() {
        return talksTime;
    }

    public void setTalksTime(Date talksTime) {
        this.talksTime = talksTime;
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