package com.qaii.dao;

import com.qaii.domain.Ministry;

public interface MinistryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ministry record);

    int insertSelective(Ministry record);

    Ministry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ministry record);

    int updateByPrimaryKey(Ministry record);
}