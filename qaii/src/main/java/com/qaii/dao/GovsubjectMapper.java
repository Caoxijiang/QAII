package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Govsubject;

public interface GovsubjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Govsubject record);

    int insertSelective(Govsubject record);

    Govsubject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Govsubject record);

    int updateByPrimaryKey(Govsubject record);
    
    List<Govsubject> getAllSubjectMsg();
    
    int deleteByPrimaryKeys(Integer[] eid);
    
    List<Govsubject> listByNum(int num);
}