package com.qaii.service.impl;

import com.qaii.dao.IncubatorPersonMapper;
import com.qaii.domain.IncubatorPerson;
import com.qaii.service.IncubatorPersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("IncubatorPersonService")
public class IncubatorPersonServiceImpl implements IncubatorPersonService {

    @Resource
    private IncubatorPersonMapper mapper;

    @Override
    public int insertRecord(IncubatorPerson Record) {
        return mapper.insertSelective(Record);
    }

    @Override
    public int deleteRecords(Integer[] id) {
        return mapper.deleteRecord(id);
    }

    @Override
    public int updateRecord(IncubatorPerson Record) {
        return mapper.updateByPrimaryKeySelective(Record);
    }

    @Override
    public List<IncubatorPerson> listRecords(Integer id) {
        return mapper.listRecords(id);
    }
}
