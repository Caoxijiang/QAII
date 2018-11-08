package com.qaii.dao;

import com.qaii.domain.AwardPersonal;

public interface AwardPersonalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AwardPersonal record);

    int insertSelective(AwardPersonal record);

    AwardPersonal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AwardPersonal record);

    int updateByPrimaryKey(AwardPersonal record);
}