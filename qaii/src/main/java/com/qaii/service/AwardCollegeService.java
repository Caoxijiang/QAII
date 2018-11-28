package com.qaii.service;

import com.qaii.domain.AwardCollege;

import java.util.List;

public interface AwardCollegeService {

    int insertRecordReturnID(AwardCollege record);

    int insertRecord(AwardCollege record);

    int deleteByPrimaryKeys(Integer[] id);

    int updateByPrimaryKey(AwardCollege record);

    List<AwardCollege> listRecords();
    List<AwardCollege> listcollege();

    AwardCollege getRecord(Integer id);

}
