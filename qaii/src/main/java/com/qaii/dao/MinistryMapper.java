package com.qaii.dao;

import com.qaii.domain.Ministry;

import java.util.List;

public interface MinistryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ministry record);

    int insertSelective(Ministry record);

    Ministry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ministry record);

    int updateByPrimaryKey(Ministry record);

    int insertRecordReturnID(Ministry record);

    int deleteByPrimaryKeys(Integer[] id);

    List<Ministry> listRecords();

    Ministry getRecord(Integer id);
}