package com.qaii.dao;

import java.util.List;

import com.qaii.domain.StockEquity;

public interface StockEquityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockEquity record);

    int insertSelective(StockEquity record);

    List<StockEquity>selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StockEquity record);

    int updateByPrimaryKey(StockEquity record);
}