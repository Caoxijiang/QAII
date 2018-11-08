package com.qaii.dao;

import com.qaii.domain.AwardIncubate;

public interface AwardIncubateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AwardIncubate record);

    int insertSelective(AwardIncubate record);

    AwardIncubate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AwardIncubate record);

    int updateByPrimaryKey(AwardIncubate record);
}