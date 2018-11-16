package com.qaii.service.impl;

import com.qaii.dao.AwardPersonalMapper;
import com.qaii.domain.AwardPersonal;
import com.qaii.service.AwardPersonalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kunpeng on 2018/11/16 11:36
 */
@Service
public class AwardPersonalServiceImpl implements AwardPersonalService {
    @Resource
    private AwardPersonalMapper awardPersonalMapper;
    @Override
    public int insertRecordReturnID(AwardPersonal record) {
        return 0;
    }

    @Override
    public int insertRecord(AwardPersonal record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(AwardPersonal record) {
        return 0;
    }

    @Override
    public List<AwardPersonal> listRecords() {
        return awardPersonalMapper.listRecords();
    }

    @Override
    public AwardPersonal getRecord(Integer id) {
        return awardPersonalMapper.getRecord(id);
    }
}
