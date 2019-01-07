package com.qaii.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by kunpeng on 2019/1/4 10:35
 */
public class AwardPersonalest {

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date awardTime;

    private String awardLevel;

    private String personUnit;

    private String awardName;

    public Date getAwardTime() {
        return awardTime;
    }

    public void setAwardTime(Date awardTime) {
        this.awardTime = awardTime;
    }

    public String getAwardLevel() {
        return awardLevel;
    }

    public void setAwardLevel(String awardLevel) {
        this.awardLevel = awardLevel;
    }

    public String getPersonUnit() {
        return personUnit;
    }

    public void setPersonUnit(String personUnit) {
        this.personUnit = personUnit;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
}
