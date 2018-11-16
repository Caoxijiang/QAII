package com.qaii.service.impl;

import com.qaii.dao.MinistryMapper;
import com.qaii.domain.Ministry;
import com.qaii.service.MinistryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MinistryServiceImpl implements MinistryService {

    @Resource
    private MinistryMapper mapper;

    @Override
    public int insertRecordReturnID(Ministry record) {

        return mapper.insertRecordReturnID(record);
    }

    @Override
    public int insertRecord(Ministry record) {

        return mapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {

        return mapper.deleteByPrimaryKeys(id);
    }

    @Override
    public int updateByPrimaryKey(Ministry record) {

        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Ministry> listRecords() {
        return mapper.listRecords();
    }

    @Override
    public Ministry getRecord(Integer id) {

        return mapper.getRecord(id);
    }
}
