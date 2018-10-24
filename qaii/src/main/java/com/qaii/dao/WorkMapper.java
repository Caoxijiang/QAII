package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Work;

public interface WorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    int selectCountNum();
    
    List<Work> getAllWorkMsg();
    
    int deleteByPrimaryKeys(Integer[] eid);
    
    int countEachMonthwork(String firstDay, String endDay);
}