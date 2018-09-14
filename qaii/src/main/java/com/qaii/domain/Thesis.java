package com.qaii.domain;

public class Thesis {
    private Integer id;

    private String sisSubject;

    private String sisAuthor;

    private String sisUnits;

    private String sisPublishlocation;

    private String sisPublishtime;

    private String sisStatus;

    private String sisDept;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSisSubject() {
        return sisSubject;
    }

    public void setSisSubject(String sisSubject) {
        this.sisSubject = sisSubject == null ? null : sisSubject.trim();
    }

    public String getSisAuthor() {
        return sisAuthor;
    }

    public void setSisAuthor(String sisAuthor) {
        this.sisAuthor = sisAuthor == null ? null : sisAuthor.trim();
    }

    public String getSisUnits() {
        return sisUnits;
    }

    public void setSisUnits(String sisUnits) {
        this.sisUnits = sisUnits == null ? null : sisUnits.trim();
    }

    public String getSisPublishlocation() {
        return sisPublishlocation;
    }

    public void setSisPublishlocation(String sisPublishlocation) {
        this.sisPublishlocation = sisPublishlocation == null ? null : sisPublishlocation.trim();
    }

    public String getSisPublishtime() {
        return sisPublishtime;
    }

    public void setSisPublishtime(String sisPublishtime) {
        this.sisPublishtime = sisPublishtime == null ? null : sisPublishtime.trim();
    }

    public String getSisStatus() {
        return sisStatus;
    }

    public void setSisStatus(String sisStatus) {
        this.sisStatus = sisStatus == null ? null : sisStatus.trim();
    }

    public String getSisDept() {
        return sisDept;
    }

    public void setSisDept(String sisDept) {
        this.sisDept = sisDept == null ? null : sisDept.trim();
    }
}