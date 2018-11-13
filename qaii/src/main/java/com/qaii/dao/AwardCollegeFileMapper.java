package com.qaii.dao;

import com.qaii.domain.AwardCollegeFile;

public interface AwardCollegeFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AwardCollegeFile record);

    int insertSelective(AwardCollegeFile record);

    AwardCollegeFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AwardCollegeFile record);

    int updateByPrimaryKey(AwardCollegeFile record);
}