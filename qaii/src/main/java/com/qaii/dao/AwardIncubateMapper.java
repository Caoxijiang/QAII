package com.qaii.dao;

import com.qaii.domain.AwardIncubate;

import java.util.List;

public interface AwardIncubateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AwardIncubate record);

    int insertSelective(AwardIncubate record);

    AwardIncubate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AwardIncubate record);

    int updateByPrimaryKey(AwardIncubate record);

    int insertRecordReturnID(AwardIncubate record);

    int deleteByPrimaryKeys(Integer[] id);

    List<AwardIncubate> listRecords();

    List<AwardIncubate> listIncubate();

    AwardIncubate getRecord(Integer id);
}