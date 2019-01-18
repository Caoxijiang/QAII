package com.qaii.dao;

import com.qaii.domain.ExchangeTalks;

public interface ExchangeTalksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExchangeTalks record);

    int insertSelective(ExchangeTalks record);

    ExchangeTalks selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExchangeTalks record);

    int updateByPrimaryKey(ExchangeTalks record);
}