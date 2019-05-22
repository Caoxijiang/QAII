package com.qaii.dao;

import com.qaii.domain.CommitLog;

public interface CommitLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommitLog record);

    int insertSelective(CommitLog record);

    CommitLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommitLog record);

    int updateByPrimaryKey(CommitLog record);
}