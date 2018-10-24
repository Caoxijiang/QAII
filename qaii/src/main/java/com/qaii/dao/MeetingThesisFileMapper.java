package com.qaii.dao;

import com.qaii.domain.MeetingThesisFile;

public interface MeetingThesisFileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MeetingThesisFile record);

    int insertSelective(MeetingThesisFile record);

    MeetingThesisFile selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MeetingThesisFile record);

    int updateByPrimaryKey(MeetingThesisFile record);
}