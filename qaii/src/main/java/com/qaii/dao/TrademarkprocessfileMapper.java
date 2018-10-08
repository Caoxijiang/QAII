package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Trademarkprocessfile;

public interface TrademarkprocessfileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Trademarkprocessfile record);

    int insertSelective(Trademarkprocessfile record);

    Trademarkprocessfile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Trademarkprocessfile record);

    int updateByPrimaryKey(Trademarkprocessfile record);
    
    List<Trademarkprocessfile> getAllMsgBysid(Integer sid);
    
    int deleteMsg(Integer[] id);
}