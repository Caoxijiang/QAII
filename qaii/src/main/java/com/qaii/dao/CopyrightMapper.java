package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Copyright;

public interface CopyrightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Copyright record);

    int insertSelective(Copyright record);

    Copyright selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Copyright record);

    int updateByPrimaryKey(Copyright record);
    
    List<Copyright> listCopyright();
    
    int insertReturnid(Copyright record);
    
    Copyright selectWithUrl(Integer id);
    
    int deleteByPrimaryKeys(Integer[] id);
}