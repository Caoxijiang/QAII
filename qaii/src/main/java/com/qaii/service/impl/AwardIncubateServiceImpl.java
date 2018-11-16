package com.qaii.service.impl;

import com.qaii.dao.AwardIncubateMapper;
import com.qaii.domain.AwardIncubate;
import com.qaii.service.AwardIncubateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AwardIncubateServiceImpl implements AwardIncubateService {

    @Resource
    private AwardIncubateMapper mapper;


    @Override
    public int insertRecordReturnID(AwardIncubate record) {
        return mapper.insertRecordReturnID(record);
    }

    @Override
    public int insertRecord(AwardIncubate record) {
        return mapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return mapper.deleteByPrimaryKeys(id);
    }

    @Override
    public int updateByPrimaryKey(AwardIncubate record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<AwardIncubate> listRecords() {
        return mapper.listRecords();
    }

    @Override
    public AwardIncubate getRecord(Integer id) {
        return mapper.getRecord(id);
    }
}
