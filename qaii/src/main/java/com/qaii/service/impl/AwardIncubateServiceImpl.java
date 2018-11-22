package com.qaii.service.impl;

import com.qaii.dao.AwardIncubateMapper;
import com.qaii.domain.AwardIncubate;
import com.qaii.service.AwardIncubateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kunpeng on 2018/11/16 11:27
 */
@Service("AwardIncubateService")
public class AwardIncubateServiceImpl implements AwardIncubateService {
    @Resource
    private AwardIncubateMapper awardIncubateMapper;
    @Override
    public int insertRecordReturnID(AwardIncubate record) {
        return awardIncubateMapper.insertRecordReturnID(record);
    }

    @Override
    public int insertRecord(AwardIncubate record) {
        return awardIncubateMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return awardIncubateMapper.deleteByPrimaryKeys(id);
    }

    @Override
    public int updateByPrimaryKey(AwardIncubate record) {
        return awardIncubateMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<AwardIncubate> listRecords() {
        return awardIncubateMapper.listRecords();
    }

    @Override
    public AwardIncubate getRecord(Integer id) {
        return awardIncubateMapper.getRecord(id);
    }
}
