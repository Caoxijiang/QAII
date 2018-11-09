package com.qaii.domain;

import java.util.Date;

public class MinistryFile {
    private Integer id;

    private String fileName;

    private String fileStyle;

    private Integer incubatorId;

    private String filePath;

    private String fileDescription;

    private Date gmtCreate;

    private Date gmtModified;

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

    public String getFileStyle() {
        return fileStyle;
    }

    public void setFileStyle(String fileStyle) {
        this.fileStyle = fileStyle == null ? null : fileStyle.trim();
    }

    public Integer getIncubatorId() {
        return incubatorId;
    }

    public void setIncubatorId(Integer incubatorId) {
        this.incubatorId = incubatorId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription == null ? null : fileDescription.trim();
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