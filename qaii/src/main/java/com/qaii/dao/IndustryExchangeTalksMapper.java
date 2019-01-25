package com.qaii.dao;

import com.qaii.domain.IndustryExchangeTalks;

import java.util.List;

public interface IndustryExchangeTalksMapper {
    int deleteByPrimaryKey(Integer[] id);

    int insert(IndustryExchangeTalks record);

    int insertSelective(IndustryExchangeTalks record);

    IndustryExchangeTalks selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndustryExchangeTalks record);

    int updateByPrimaryKey(IndustryExchangeTalks record);

    List<IndustryExchangeTalks> listRecords();

    IndustryExchangeTalks getRecords(Integer id);

}