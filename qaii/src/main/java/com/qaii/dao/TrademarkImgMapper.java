package com.qaii.dao;

import com.qaii.domain.TrademarkImg;

public interface TrademarkImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TrademarkImg record);

    int insertSelective(TrademarkImg record);

    TrademarkImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TrademarkImg record);

    int updateByPrimaryKey(TrademarkImg record);
}