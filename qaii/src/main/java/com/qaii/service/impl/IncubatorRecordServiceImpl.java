package com.qaii.service.impl;

import com.qaii.dao.IncubatorRecordMapper;
import com.qaii.domain.IncubatorRecord;
import com.qaii.service.IncubatorRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("incubatorRecordService")
public class IncubatorRecordServiceImpl implements IncubatorRecordService {

    @Resource
    private IncubatorRecordMapper incubatorRecordMapper;


    @Override
    public int insert(List<IncubatorRecord> record) {
        return incubatorRecordMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(List<IncubatorRecord> record) {
        return incubatorRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public  List<IncubatorRecord> selectByPrimaryKey(Integer id) {
        return incubatorRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updataTime(IncubatorRecord incubatorRecord) {
        return incubatorRecordMapper.updataTime(incubatorRecord);
    }
}
