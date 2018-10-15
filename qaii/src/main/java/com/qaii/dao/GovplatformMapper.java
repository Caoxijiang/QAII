package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Govplatform;

public interface GovplatformMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Govplatform record);

    int insertSelective(Govplatform record);

    Govplatform selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Govplatform record);

    int updateByPrimaryKey(Govplatform record);
    
    List<Govplatform> getAllPlatformMsg();
    
    int deleteByPrimaryKeys(Integer[] eid);
    
    List<Govplatform> listByNum(int num);
}