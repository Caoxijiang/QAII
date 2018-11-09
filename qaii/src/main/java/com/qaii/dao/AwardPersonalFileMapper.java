package com.qaii.dao;

import com.qaii.domain.AwardPersonalFile;

public interface AwardPersonalFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AwardPersonalFile record);

    int insertSelective(AwardPersonalFile record);

    AwardPersonalFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AwardPersonalFile record);

    int updateByPrimaryKey(AwardPersonalFile record);
}