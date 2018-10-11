package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Thesis;

public interface ThesisMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Thesis record);

    int insertSelective(Thesis record);

    Thesis selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Thesis record);

    int updateByPrimaryKey(Thesis record);
    
    int selectCountNum();
    
    List<Thesis> getAllThesisMsg();
    
    int deleteByPrimaryKeys(Integer[] eid);
    
    int countEachMonththesis(String firstDay, String endDay);
}