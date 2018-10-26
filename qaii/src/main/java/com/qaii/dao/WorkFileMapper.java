package com.qaii.dao;

import com.qaii.domain.WorkFile;

public interface WorkFileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WorkFile record);

    int insertSelective(WorkFile record);

    WorkFile selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WorkFile record);

    int updateByPrimaryKey(WorkFile record);
}