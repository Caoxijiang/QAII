package com.qaii.dao;

import com.qaii.domain.ScienceUnit;

import java.util.List;

public interface ScienceUnitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScienceUnit record);

    int insertSelective(ScienceUnit record);

    ScienceUnit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScienceUnit record);

    int updateByPrimaryKey(ScienceUnit record);

    List<ScienceUnit> listRecords();

    int deleteRecords(Integer[] id);
}