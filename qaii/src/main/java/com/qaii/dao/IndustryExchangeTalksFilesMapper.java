package com.qaii.dao;

import com.qaii.domain.IndustryExchangeTalksFiles;

import java.util.List;

public interface IndustryExchangeTalksFilesMapper {
    int deleteByPrimaryKey(Integer[] id);

    int insert(IndustryExchangeTalksFiles record);

    int insertSelective(IndustryExchangeTalksFiles record);

    IndustryExchangeTalksFiles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndustryExchangeTalksFiles record);

    int updateByPrimaryKey(IndustryExchangeTalksFiles record);

    List<IndustryExchangeTalksFiles> selectFilePathByexchangetalksId(Integer[] id);
}