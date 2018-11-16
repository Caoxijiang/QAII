package com.qaii.dao;

import com.qaii.domain.Ministry;

import java.util.Date;
import java.util.List;

public interface MinistryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ministry record);

    int insertSelective(Ministry record);

    Ministry selectByPrimaryKey(Integer id);
    int selectCountNums(String ministrytime);
    List<String> listministrytime();
    int updateByPrimaryKeySelective(Ministry record);

    int updateByPrimaryKey(Ministry record);
}