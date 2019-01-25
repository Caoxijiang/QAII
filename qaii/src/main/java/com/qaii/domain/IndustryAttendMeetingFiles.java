package com.qaii.domain;

import java.util.Date;

public class IndustryAttendMeetingFiles {
    private Integer id;

    private String fileName;

    private String filePath;

    private String fileDescribtion;

    private Date fileCreatetime;

    private Date fileModifytime;

    private Integer attendmeetingId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getFileDescribtion() {
        return fileDescribtion;
    }

    public void setFileDescribtion(String fileDescribtion) {
        this.fileDescribtion = fileDescribtion == null ? null : fileDescribtion.trim();
    }

    public Date getFileCreatetime() {
        return fileCreatetime;
    }

    public void setFileCreatetime(Date fileCreatetime) {
        this.fileCreatetime = fileCreatetime;
    }

    public Date getFileModifytime() {
        return fileModifytime;
    }

    public void setFileModifytime(Date fileModifytime) {
        this.fileModifytime = fileModifytime;
    }

    public Integer getAttendmeetingId() {
        return attendmeetingId;
    }

    public void setAttendmeetingId(Integer attendmeetingId) {
        this.attendmeetingId = attendmeetingId;
    }
}