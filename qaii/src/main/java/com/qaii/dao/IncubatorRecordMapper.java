package com.qaii.dao;

import com.qaii.domain.IncubatorRecord;

import java.util.List;

public interface IncubatorRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(List<IncubatorRecord> record);

    int insertSelective(IncubatorRecord record);

    List<IncubatorRecord> selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IncubatorRecord record);

    int updateByPrimaryKey(List<IncubatorRecord> record);

    int updataTime(IncubatorRecord incubatorRecord);
}