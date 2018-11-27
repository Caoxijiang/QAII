package com.qaii.service;

import com.qaii.domain.AwardPersonal;

import java.util.List;

public interface AwardPersonalService {

    int insertRecordReturnID(AwardPersonal record);

    int insertRecord(AwardPersonal record);

    int deleteByPrimaryKeys(Integer[] id);

    int updateByPrimaryKey(AwardPersonal record);

    List<AwardPersonal> listRecords();

    List<AwardPersonal> listPersonal();

    AwardPersonal getRecord(Integer id);
}
