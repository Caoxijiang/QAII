package com.qaii.dao;

import com.qaii.domain.AttendMeeting;

public interface AttendMeetingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AttendMeeting record);

    int insertSelective(AttendMeeting record);

    AttendMeeting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AttendMeeting record);

    int updateByPrimaryKey(AttendMeeting record);
}