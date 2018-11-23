package com.qaii.service.impl;

import com.qaii.dao.CooperationMapper;
import com.qaii.domain.Cooperation;
import com.qaii.service.CooperationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("CooperationService")
public class CooperationServiceImpl implements CooperationService {

    @Resource
    private CooperationMapper mapper;

    @Override
    public int insertRecordReturnID(Cooperation record) {
        return mapper.insertRecordReturnID(record);
    }

    @Override
    public int insertRecord(Cooperation record) {
        return mapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return mapper.deleteByPrimaryKeys(id);
    }

    @Override
    public int updateByPrimaryKey(Cooperation record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Cooperation> listRecords() {
        return mapper.listRecords();
    }

    @Override
    public Cooperation getRecord(Integer id) {
        return mapper.getRecord(id);
    }
}
