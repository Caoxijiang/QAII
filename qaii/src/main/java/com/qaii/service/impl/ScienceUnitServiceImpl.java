package com.qaii.service.impl;

import com.qaii.dao.ScienceUnitMapper;
import com.qaii.domain.ScienceUnit;
import com.qaii.service.ScienceUnitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Company: 青岛智能产业技术研究院
 * @author: wangxin
 * @Descrpiton:
 * @Time 2019-02-19 10:07
 */

@Service()
public class ScienceUnitServiceImpl implements ScienceUnitService {

    @Resource
    private ScienceUnitMapper mapper;

    @Override
    public int insertRecord(ScienceUnit Record) {
        return mapper.insertSelective(Record);
    }

    @Override
    public int updateRecord(ScienceUnit Record) {
        return mapper.updateByPrimaryKeySelective(Record);
    }

    @Override
    public int deleteRecords(Integer[] Id) {
        return mapper.deleteRecords(Id);
    }

    @Override
    public List<ScienceUnit> listRecords() {
        return mapper.listRecords();
    }
}
