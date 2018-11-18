package com.qaii.service.impl;

import com.qaii.dao.AwardCollegeMapper;
import com.qaii.dao.IncubatorFileMapper;
import com.qaii.domain.AwardCollege;
import com.qaii.service.AwardCollegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kunpeng on 2018/11/16 10:37
 */
@Service
public class AwardCollegeServiceImpl implements AwardCollegeService {
    @Resource
    private AwardCollegeMapper awardCollegeMapper;
    @Override
    public int insertRecordReturnID(AwardCollege record) {
        return awardCollegeMapper.insertRecordReturnID(record);
    }

    @Override
    public int insertRecord(AwardCollege record) {
        return awardCollegeMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return awardCollegeMapper.deleteByPrimaryKeys(id);
    }

    @Override
    public int updateByPrimaryKey(AwardCollege record) {
        return awardCollegeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<AwardCollege> listRecords() {
        return awardCollegeMapper.listRecords();
    }

    @Override
    public AwardCollege getRecord(Integer id) {
        return awardCollegeMapper.getRecord(id);
    }
}
