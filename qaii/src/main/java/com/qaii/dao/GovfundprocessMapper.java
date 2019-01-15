package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Govfundprocess;

public interface GovfundprocessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Govfundprocess record);

    int insertSelective(Govfundprocess record);

    Govfundprocess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Govfundprocess record);

    int updateByPrimaryKey(Govfundprocess record);
    
    List<Govfundprocess> getAllMsgBypid(Integer pid);

    int deleteByPrimaryKeys(Integer[] id);

    int deleteByPid(Integer[] pid);
}