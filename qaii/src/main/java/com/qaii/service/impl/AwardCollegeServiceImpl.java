package com.qaii.service.impl;

import com.qaii.dao.AwardCollegeMapper;
import com.qaii.domain.AwardCollege;
import com.qaii.service.AwardCollegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AwardCollegeServiceImpl implements AwardCollegeService {

    @Resource
    private AwardCollegeMapper mapper;

    @Override
    public int insertRecordReturnID(AwardCollege record) {
        return mapper.insertRecordReturnID(record);
    }

    @Override
    public int insertRecord(AwardCollege record) {
        return mapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return mapper.deleteByPrimaryKeys(id);
    }

    @Override
    public int updateByPrimaryKey(AwardCollege record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<AwardCollege> listRecords() {
        return mapper.listRecords();
    }

    @Override
    public AwardCollege getRecord(Integer id) {
        return mapper.getRecord(id);
    }
}
