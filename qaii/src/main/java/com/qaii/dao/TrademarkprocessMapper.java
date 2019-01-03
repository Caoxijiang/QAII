package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Trademarkprocess;

public interface TrademarkprocessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Trademarkprocess record);

    int insertSelective(Trademarkprocess record);

    Trademarkprocess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Trademarkprocess record);

    int updateByPrimaryKey(Trademarkprocess record);
    
    List<Trademarkprocess> getAllMsgBypid(Integer pid);

    int deleteByPrimaryKeys(Integer[] id);
}