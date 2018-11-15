package com.qaii.dao;

import com.qaii.domain.AwardPersonal;

import java.util.List;

public interface AwardPersonalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AwardPersonal record);

    int insertSelective(AwardPersonal record);

    AwardPersonal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AwardPersonal record);

    int updateByPrimaryKey(AwardPersonal record);

    int insertRecordReturnID(AwardPersonal record);

    int deleteByPrimaryKeys(Integer[] id);

    List<AwardPersonal> listRecords();

    AwardPersonal getRecord(Integer id);
}