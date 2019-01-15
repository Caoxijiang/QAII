package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Govrewardprocess;

public interface GovrewardprocessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Govrewardprocess record);

    int insertSelective(Govrewardprocess record);

    Govrewardprocess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Govrewardprocess record);

    int updateByPrimaryKey(Govrewardprocess record);
    
    List<Govrewardprocess> getAllMsgBypid(Integer pid);

    int deleteByPrimaryKeys(Integer[] id);

    int deleteByPid(Integer[] pid);
}