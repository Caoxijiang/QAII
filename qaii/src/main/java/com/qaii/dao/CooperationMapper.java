package com.qaii.dao;

import com.qaii.domain.Cooperation;

import java.util.List;

public interface CooperationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cooperation record);

    int insertSelective(Cooperation record);

    Cooperation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cooperation record);

    int updateByPrimaryKey(Cooperation record);

    int insertRecordReturnID(Cooperation record);

    int deleteByPrimaryKeys(Integer[] id);

    List<Cooperation> listRecords();

    Cooperation getRecord(Integer id);
}