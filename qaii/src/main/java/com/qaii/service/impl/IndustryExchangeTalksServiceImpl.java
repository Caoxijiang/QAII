package com.qaii.service.impl;

import com.qaii.dao.IndustryExchangeTalksMapper;
import com.qaii.domain.IndustryExchangeTalks;
import com.qaii.service.IndustryExchangeTalksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("industryExchangeTalksService")
public class IndustryExchangeTalksServiceImpl implements IndustryExchangeTalksService {
@Resource
private IndustryExchangeTalksMapper industryExchangeTalksMapper;
    @Override
    public int deleteByPrimaryKey(Integer[] id) {
        return industryExchangeTalksMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(IndustryExchangeTalks record) {
        return industryExchangeTalksMapper.insert(record);
    }

    @Override
    public int insertSelective(IndustryExchangeTalks record) {
        return industryExchangeTalksMapper.insertSelective(record);
    }

    @Override
    public IndustryExchangeTalks selectByPrimaryKey(Integer id) {
        return industryExchangeTalksMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(IndustryExchangeTalks record) {
        return industryExchangeTalksMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(IndustryExchangeTalks record) {
        return industryExchangeTalksMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<IndustryExchangeTalks> listRecords() {
        return industryExchangeTalksMapper.listRecords();
    }

    @Override
    public IndustryExchangeTalks getRecords(Integer id) {
        return industryExchangeTalksMapper.getRecords(id);
    }
}
