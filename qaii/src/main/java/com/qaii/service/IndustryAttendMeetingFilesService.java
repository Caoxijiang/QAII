package com.qaii.service;

import com.qaii.domain.IndustryAttendMeetingFiles;

import java.util.List;

public interface IndustryAttendMeetingFilesService {
    int deleteByPrimaryKey(Integer[] id);

    int insert(IndustryAttendMeetingFiles record);

    int insertSelective(IndustryAttendMeetingFiles record);

    IndustryAttendMeetingFiles selectByPrimaryKey(Integer id);

    List<IndustryAttendMeetingFiles> selectFilePathByattendmeetingId(Integer[] id);

    int updateByPrimaryKeySelective(IndustryAttendMeetingFiles record);

    int updateByPrimaryKey(IndustryAttendMeetingFiles record);
}
