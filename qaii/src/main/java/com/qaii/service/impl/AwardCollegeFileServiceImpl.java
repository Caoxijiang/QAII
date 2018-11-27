package com.qaii.service.impl;

import com.qaii.dao.AwardCollegeFileMapper;
import com.qaii.domain.AwardCollegeFile;
import com.qaii.service.AwardCollegeFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service("AwardCollegeFileService")
public class AwardCollegeFileServiceImpl implements AwardCollegeFileService {

    @Resource
    private AwardCollegeFileMapper mapper;

    @Override
    public int insertRecord(AwardCollegeFile record) {
        return mapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return mapper.deleteByParimaryKeys(id);
    }

    @Override
    public int updateByPrimaryKey(AwardCollegeFile record) {
        return mapper.updateByPrimaryKeySelective(record);
    }
}
