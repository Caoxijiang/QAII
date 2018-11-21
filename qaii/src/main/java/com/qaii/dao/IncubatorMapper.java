package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Incubator;

import java.util.Date;
import java.util.List;

public interface IncubatorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Incubator record);

    int insertSelective(Incubator record);

    Incubator selectByPrimaryKey(Integer id);
    List<String> selectestablishtime();
    int selectCountNums(String establishtime);
    int selectCountNumsByQianFan();
    int selectCountNumsByGaoxin();
    int selectCountNumsByBaiQIan();
    int selectCountNumsByMiddleLittle();
    int updateByPrimaryKeySelective(Incubator record);

    int updateByPrimaryKey(Incubator record);
    
    List<Incubator> selectAlllist();
}