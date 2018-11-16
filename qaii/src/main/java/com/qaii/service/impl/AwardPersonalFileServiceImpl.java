package com.qaii.service.impl;

import com.qaii.dao.AwardPersonalFileMapper;
import com.qaii.domain.AwardPersonalFile;
import com.qaii.service.AwardPersonalFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AwardPersonalFileServiceImpl implements AwardPersonalFileService {

    @Resource
    private AwardPersonalFileMapper mapper;

    @Override
    public int insertRecord(AwardPersonalFile record) {
        return mapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return mapper.deleteByParimaryKeys(id);
    }

    @Override
    public int updateByPrimaryKey(AwardPersonalFile record) {
        return mapper.updateByPrimaryKeySelective(record);
    }
}
