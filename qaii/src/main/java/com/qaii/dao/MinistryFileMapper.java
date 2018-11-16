package com.qaii.dao;

import com.qaii.domain.MinistryFile;

public interface MinistryFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MinistryFile record);

    int insertSelective(MinistryFile record);

    MinistryFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MinistryFile record);

    int updateByPrimaryKey(MinistryFile record);

    int deleteByParimaryKeys(Integer[] id);
}