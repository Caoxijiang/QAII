package com.qaii.dao;

import com.qaii.domain.AttendMeetingFiles;

public interface AttendMeetingFilesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AttendMeetingFiles record);

    int insertSelective(AttendMeetingFiles record);

    AttendMeetingFiles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AttendMeetingFiles record);

    int updateByPrimaryKey(AttendMeetingFiles record);
}