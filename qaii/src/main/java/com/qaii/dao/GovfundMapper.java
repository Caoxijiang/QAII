package com.qaii.dao;

import com.qaii.domain.Govfund;

public interface GovfundMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Govfund record);

    int insertSelective(Govfund record);

    Govfund selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Govfund record);

    int updateByPrimaryKey(Govfund record);
}