package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Govsubjectprocess;

public interface GovsubjectprocessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Govsubjectprocess record);

    int insertSelective(Govsubjectprocess record);

    Govsubjectprocess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Govsubjectprocess record);

    int updateByPrimaryKey(Govsubjectprocess record);
    
    List<Govsubjectprocess> getAllMsgBypid(Integer pid);

    int deleteByPrimaryKeys(Integer[] id);
}