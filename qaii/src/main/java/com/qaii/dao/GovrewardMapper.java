package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Govreward;

public interface GovrewardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Govreward record);

    int insertSelective(Govreward record);

    Govreward selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Govreward record);

    int updateByPrimaryKey(Govreward record);
    
    List<Govreward> getAllrewardMsg();
    
    int deleteByPrimaryKeys(Integer[] eid);
    
    List<Govreward> listByNum(int num);
}