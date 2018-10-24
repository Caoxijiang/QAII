package com.qaii.dao;

import java.util.List;

import com.qaii.domain.MeetingThesis;

public interface MeetingThesisMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MeetingThesis record);

    int insertSelective(MeetingThesis record);

    MeetingThesis selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MeetingThesis record);

    int updateByPrimaryKey(MeetingThesis record);
    
    List<MeetingThesis> listAllMessage();
    
    int deleteMessages(Integer[] id);
    
    int insertMessage(MeetingThesis record);
}