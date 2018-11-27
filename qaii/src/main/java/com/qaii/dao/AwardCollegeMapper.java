package com.qaii.dao;

import com.qaii.domain.AwardCollege;

import java.util.List;

public interface AwardCollegeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AwardCollege record);

    int insertSelective(AwardCollege record);

    AwardCollege selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AwardCollege record);

    int updateByPrimaryKey(AwardCollege record);

    int insertRecordReturnID(AwardCollege record);

    int deleteByPrimaryKeys(Integer[] id);

    List<AwardCollege> listRecords();

    List<AwardCollege> listcollege();

    AwardCollege getRecord(Integer id);
}