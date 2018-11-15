package com.qaii.service;

import com.qaii.domain.Cooperation;

import java.util.List;

public interface CooperationService {

    int insertRecordReturnID(Cooperation record);

    int insertRecord(Cooperation record);

    int deleteByPrimaryKeys(Integer[] id);

    int updateByPrimaryKey(Cooperation record);

    List<Cooperation> listRecords();

    Cooperation getRecord(Integer id);
}
