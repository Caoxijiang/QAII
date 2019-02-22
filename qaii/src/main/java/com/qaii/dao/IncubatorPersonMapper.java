package com.qaii.dao;

import com.qaii.domain.IncubatorPerson;

import java.util.List;

public interface IncubatorPersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IncubatorPerson record);

    int insertSelective(IncubatorPerson record);

    IncubatorPerson selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IncubatorPerson record);

    int updateByPrimaryKey(IncubatorPerson record);

    List<IncubatorPerson> listRecords();

    int deleteRecord(Integer[] Id);
}