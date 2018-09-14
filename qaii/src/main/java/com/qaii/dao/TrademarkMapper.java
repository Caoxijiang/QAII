package com.qaii.dao;

import com.qaii.domain.Trademark;

public interface TrademarkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Trademark record);

    int insertSelective(Trademark record);

    Trademark selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Trademark record);

    int updateByPrimaryKey(Trademark record);
}