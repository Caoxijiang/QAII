package com.qaii.dao;

import com.qaii.domain.AwardCollege;

public interface AwardCollegeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AwardCollege record);

    int insertSelective(AwardCollege record);

    AwardCollege selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AwardCollege record);

    int updateByPrimaryKey(AwardCollege record);
}