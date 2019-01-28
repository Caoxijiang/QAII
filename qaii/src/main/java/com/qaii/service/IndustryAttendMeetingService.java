package com.qaii.service;

import com.qaii.domain.IndustryAttendMeeting;

import java.util.List;

public interface IndustryAttendMeetingService {
    int deleteByPrimaryKey(Integer[] id);

    int insert(IndustryAttendMeeting record);

    int insertSelective(IndustryAttendMeeting record);

    IndustryAttendMeeting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndustryAttendMeeting record);

    int updateByPrimaryKey(IndustryAttendMeeting record);

    List<IndustryAttendMeeting> listRecords();

    IndustryAttendMeeting getRecords(Integer id);


}
