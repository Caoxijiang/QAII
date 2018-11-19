package com.qaii.dao;

import com.qaii.domain.IncubatorRecord;

public interface IncubatorRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IncubatorRecord record);

    int insertSelective(IncubatorRecord record);

    IncubatorRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IncubatorRecord record);

    int updateByPrimaryKey(IncubatorRecord record);
}