package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Govplatformprocess;

public interface GovplatformprocessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Govplatformprocess record);

    int insertSelective(Govplatformprocess record);

    Govplatformprocess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Govplatformprocess record);

    int updateByPrimaryKey(Govplatformprocess record);
    
    List<Govplatformprocess> getAllMsgBypid(Integer pid);

    int deleteByPrimaryKeys(Integer[] id);
}