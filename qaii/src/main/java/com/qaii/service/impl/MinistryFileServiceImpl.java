package com.qaii.service.impl;

import com.qaii.dao.MinistryFileMapper;
import com.qaii.domain.MinistryFile;
import com.qaii.service.MinistryFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("ministryFileService")
public class MinistryFileServiceImpl implements MinistryFileService {

    @Resource
    private MinistryFileMapper mapper;

    @Override
    public int insertRecord(MinistryFile record) {
        return mapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return mapper.deleteByParimaryKeys(id);
    }

    @Override
    public int updateByPrimaryKey(MinistryFile record) {
        return mapper.updateByPrimaryKeySelective(record);
    }
}
