package com.qaii.dao;

import java.util.List;

import com.qaii.domain.DeptInfo;
import com.qaii.domain.Patent;

public interface PatentMapper {
    int deleteByPrimaryKey(Integer[] id);

    int insert(Patent record);

    int insertSelective(Patent record);

    Patent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Patent record);

    int updateByPrimaryKey(Patent record); 

    int selectCountbyNum();

    List<Patent> findAllPatentInfo();
    
    int countAgencyPatent(String firstDay, String endDay);
    
    int countAuthorizationPatent(String firstDay, String endDay);
    
    int countAuthorizationPatentNum();

}