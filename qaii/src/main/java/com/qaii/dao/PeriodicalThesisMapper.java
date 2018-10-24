package com.qaii.dao;

import java.util.List;

import com.qaii.domain.PeriodicalThesis;

public interface PeriodicalThesisMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PeriodicalThesis record);

    int insertSelective(PeriodicalThesis record);

    PeriodicalThesis selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PeriodicalThesis record);

    int updateByPrimaryKey(PeriodicalThesis record);
    
    List<PeriodicalThesis> listAllMessage();
    
    int deleteMessages(Integer[] id);
    
    int insertMessage(PeriodicalThesis record);
}