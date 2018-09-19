package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Softwarecopyright;

public interface SoftwarecopyrightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Softwarecopyright record);

    int insertSelective(Softwarecopyright record);

    Softwarecopyright selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Softwarecopyright record);

    int updateByPrimaryKey(Softwarecopyright record);
    
    int selectCountNum();
    
    List<Softwarecopyright> getAllSoftWareMsg();
    
    int deleteByPrimaryKeys(Integer[] eid);
}