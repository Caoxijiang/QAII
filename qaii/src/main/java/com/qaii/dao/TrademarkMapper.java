package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Trademark;

public interface TrademarkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Trademark record);

    int insertSelective(Trademark record);

    Trademark selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Trademark record);

    int updateByPrimaryKey(Trademark record);
    
    int selectCountNum();
    
    List<Trademark> getAllTradeMarkMsg();
    
    int deleteByPrimaryKeys(Integer[] eid);
    
    int countAgencyTradeMark(String firstDay, String endDay);
    
    int countAuthorizationTradeMark(String firstDay, String endDay);
    
    int countAuthorizationTradeMarkNum();
}