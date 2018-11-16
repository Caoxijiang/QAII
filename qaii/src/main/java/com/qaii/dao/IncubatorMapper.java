package com.qaii.dao;

import com.qaii.domain.Incubator;

public interface IncubatorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Incubator record);

    int insertSelective(Incubator record);

    Incubator selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Incubator record);

    int updateByPrimaryKey(Incubator record);
}