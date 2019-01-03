package com.qaii.dao;

import com.qaii.domain.MeetingThesisAuthor;

import java.util.List;

public interface MeetingThesisAuthorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MeetingThesisAuthor record);

    int insertSelective(MeetingThesisAuthor record);

    MeetingThesisAuthor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MeetingThesisAuthor record);

    int updateByPrimaryKey(MeetingThesisAuthor record);

    List<MeetingThesisAuthor> listRecord(String id);

    int deleteByPrimaryKeys(Integer[] id);

    MeetingThesisAuthor getRecord(Integer id);
}