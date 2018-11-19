package com.qaii.service;

import com.qaii.domain.Ministry;

import java.util.Date;
import java.util.List;

public interface MinistryService {

    int insertRecordReturnID(Ministry record);

    int insertRecord(Ministry record);

    int deleteByPrimaryKeys(Integer[] id);

    int updateByPrimaryKey(Ministry record);
    List<String> listministrytime();
    List<Ministry> listRecords();

    Ministry getRecord(Integer id);
    int selectCountNums(String ministrytime);
}
