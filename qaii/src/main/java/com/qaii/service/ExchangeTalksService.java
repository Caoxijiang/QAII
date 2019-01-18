package com.qaii.service;

import com.qaii.domain.ExchangeTalks;

/**
 * Created by kunpeng on 2019/1/18 14:46
 */
public interface ExchangeTalksService {
    int deleteByPrimaryKey(Integer id);

    int insert(ExchangeTalks record);

    int insertSelective(ExchangeTalks record);

    ExchangeTalks selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExchangeTalks record);

    int updateByPrimaryKey(ExchangeTalks record);
}
