package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Govfund;

public interface GovfundMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Govfund record);

    int insertSelective(Govfund record);

    Govfund selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Govfund record);

    int updateByPrimaryKey(Govfund record);
    
    List<Govfund> getAllFundMsg();
    
    int deleteByPrimaryKeys(Integer[] eid);
    
    List<Govfund> listByNum(int num);
}