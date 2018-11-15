package com.qaii.service;

import com.qaii.domain.AwardIncubate;

import java.util.List;

public interface AwardIncubateService {

    int insertRecordReturnID(AwardIncubate record);

    int insertRecord(AwardIncubate record);

    int deleteByPrimaryKeys(Integer[] id);

    int updateByPrimaryKey(AwardIncubate record);

    List<AwardIncubate> listRecords();

    AwardIncubate getRecord(Integer id);
}
