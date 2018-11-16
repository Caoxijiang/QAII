package com.qaii.service.impl;

import com.qaii.dao.AwardPersonalMapper;
import com.qaii.domain.AwardPersonal;
import com.qaii.service.AwardPersonalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AwardPersonalServiceImpl implements AwardPersonalService {

    @Resource
    private AwardPersonalMapper mapper;

    @Override
    public int insertRecordReturnID(AwardPersonal record) {
        return mapper.insertRecordReturnID(record);
    }

    @Override
    public int insertRecord(AwardPersonal record) {
        return mapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return mapper.deleteByPrimaryKeys(id);
    }

    @Override
    public int updateByPrimaryKey(AwardPersonal record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<AwardPersonal> listRecords() {
        return mapper.listRecords();
    }

    @Override
    public AwardPersonal getRecord(Integer id) {
        return mapper.getRecord(id);
    }
}
