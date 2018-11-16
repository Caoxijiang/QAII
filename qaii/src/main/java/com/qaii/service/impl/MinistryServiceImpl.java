package com.qaii.service.impl;

import com.qaii.dao.MinistryMapper;
import com.qaii.domain.Ministry;
import com.qaii.service.MinistryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by kunpeng on 2018/11/15 15:52
 */
@Service
public class MinistryServiceImpl implements MinistryService {
    @Resource
    private MinistryMapper ministryMapper;

    @Override
    public int insertRecordReturnID(Ministry record) {
        return ministryMapper.insertSelective(record);
    }

    @Override
    public int insertRecord(Ministry record) {
        return ministryMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Ministry record) {
        return 0;
    }

    @Override
    public List<Ministry> listRecords() {
        return null;
    }

    @Override
    public Ministry getRecord(Integer id) {
        return null;
    }

    @Override
    public int selectCountNums(String ministrytime) {
        return ministryMapper.selectCountNums(ministrytime);
    }

    @Override
    public List<String> listministrytime() {
        return ministryMapper.listministrytime();
    }
}
