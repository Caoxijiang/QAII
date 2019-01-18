package com.qaii.service.impl;

import com.qaii.dao.ExchangeTalksMapper;
import com.qaii.domain.ExchangeTalks;
import com.qaii.service.ExchangeTalksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by kunpeng on 2019/1/18 14:47
 */
@Service
public class ExchangeTalksServiceImpl implements ExchangeTalksService {
    @Resource
    private ExchangeTalksMapper exchangeTalksMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(ExchangeTalks record) {
        return exchangeTalksMapper.insert(record);
    }

    @Override
    public int insertSelective(ExchangeTalks record) {
        return 0;
    }

    @Override
    public ExchangeTalks selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(ExchangeTalks record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(ExchangeTalks record) {
        return 0;
    }
}
