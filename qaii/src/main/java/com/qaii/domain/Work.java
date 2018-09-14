package com.qaii.domain;

public class Work {
    private Integer id;

    private String workType;

    private String workTopic;

    private String workAuthor;

    private String workPublishhouse;

    private String workPublishtime;

    private String workDept;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
    }

    public String getWorkTopic() {
        return workTopic;
    }

    public void setWorkTopic(String workTopic) {
        this.workTopic = workTopic == null ? null : workTopic.trim();
    }

    public String getWorkAuthor() {
        return workAuthor;
    }

    public void setWorkAuthor(String workAuthor) {
        this.workAuthor = workAuthor == null ? null : workAuthor.trim();
    }

    public String getWorkPublishhouse() {
        return workPublishhouse;
    }

    public void setWorkPublishhouse(String workPublishhouse) {
        this.workPublishhouse = workPublishhouse == null ? null : workPublishhouse.trim();
    }

    public String getWorkPublishtime() {
        return workPublishtime;
    }

    public void setWorkPublishtime(String workPublishtime) {
        this.workPublishtime = workPublishtime == null ? null : workPublishtime.trim();
    }

    public String getWorkDept() {
        return workDept;
    }

    public void setWorkDept(String workDept) {
        this.workDept = workDept == null ? null : workDept.trim();
    }
}