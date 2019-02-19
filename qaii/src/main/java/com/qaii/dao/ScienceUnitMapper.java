package com.qaii.dao;

import com.qaii.domain.ScienceUnit;

public interface ScienceUnitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScienceUnit record);

    int insertSelective(ScienceUnit record);

    ScienceUnit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScienceUnit record);

    int updateByPrimaryKey(ScienceUnit record);
}