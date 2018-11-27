package com.qaii.service.impl;

import com.qaii.dao.CooperationFileMapper;
import com.qaii.domain.CooperationFile;
import com.qaii.service.CooperationFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("CooperationFileService")
public class CooperationFileServiceImpl implements CooperationFileService {

    @Resource
    private CooperationFileMapper mapper;

    @Override
    public int insertRecord(CooperationFile record) {
        return mapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return mapper.deleteByParimaryKeys(id);
    }

    @Override
    public int updateByPrimaryKey(CooperationFile record) {
        return mapper.updateByPrimaryKeySelective(record);
    }
}
