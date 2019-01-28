package com.qaii.service.impl;

import com.qaii.dao.IndustryExchangeTalksFilesMapper;
import com.qaii.domain.IndustryExchangeTalksFiles;
import com.qaii.service.IndustryExchangeTalksFilesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service("industryExchangeTalksFilesService")
public class IndustryExchangeTalksFilesServiceImpl implements IndustryExchangeTalksFilesService {
    @Resource
    private IndustryExchangeTalksFilesMapper industryExchangeTalksFilesMapper;

    @Override
    public int deleteByPrimaryKey(Integer[] id) {
        return industryExchangeTalksFilesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(IndustryExchangeTalksFiles record) {
        return industryExchangeTalksFilesMapper.insert(record);
    }

    @Override
    public int insertSelective(IndustryExchangeTalksFiles record) {
        return industryExchangeTalksFilesMapper.insertSelective(record);
    }

    @Override
    public IndustryExchangeTalksFiles selectByPrimaryKey(Integer id) {
        return industryExchangeTalksFilesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(IndustryExchangeTalksFiles record) {
        return industryExchangeTalksFilesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(IndustryExchangeTalksFiles record) {
        return industryExchangeTalksFilesMapper.updateByPrimaryKey(record);
    }

    @Override
    public IndustryExchangeTalksFiles selectFilePathByexchangetalksId(Integer[] id) {
        return industryExchangeTalksFilesMapper.selectFilePathByexchangetalksId(id);
    }
}
