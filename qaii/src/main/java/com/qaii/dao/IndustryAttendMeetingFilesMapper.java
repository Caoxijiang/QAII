package com.qaii.dao;

import com.qaii.domain.IndustryAttendMeetingFiles;

import java.util.List;

public interface IndustryAttendMeetingFilesMapper {
    int deleteByPrimaryKey(Integer[] id);

    int insert(IndustryAttendMeetingFiles record);

    int insertSelective(IndustryAttendMeetingFiles record);

    IndustryAttendMeetingFiles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndustryAttendMeetingFiles record);

    int updateByPrimaryKey(IndustryAttendMeetingFiles record);

    List<IndustryAttendMeetingFiles> selectFilePathByattendmeetingId(Integer[] id);
}