package com.qaii.service.impl;

import com.qaii.dao.AwardIncubateFileMapper;
import com.qaii.domain.AwardIncubateFile;
import com.qaii.service.AwardIncubateFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AwardIncubateFileServiceImpl implements AwardIncubateFileService {

    @Resource
    private AwardIncubateFileMapper mapper;

    @Override
    public int insertRecord(AwardIncubateFile record) {
        return mapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return mapper.deleteByParimaryKeys(id);
    }

    @Override
    public int updateByPrimaryKey(AwardIncubateFile record) {
        return mapper.updateByPrimaryKeySelective(record);
    }
}
