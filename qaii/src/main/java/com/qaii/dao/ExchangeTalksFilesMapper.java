package com.qaii.dao;

import com.qaii.domain.ExchangeTalksFiles;

public interface ExchangeTalksFilesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExchangeTalksFiles record);

    int insertSelective(ExchangeTalksFiles record);

    ExchangeTalksFiles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExchangeTalksFiles record);

    int updateByPrimaryKey(ExchangeTalksFiles record);
}