package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Govsubjectprocessfile;

public interface GovsubjectprocessfileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Govsubjectprocessfile record);

    int insertSelective(Govsubjectprocessfile record);

    Govsubjectprocessfile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Govsubjectprocessfile record);

    int updateByPrimaryKey(Govsubjectprocessfile record);
    
    List<Govsubjectprocessfile> getAllMsgBysid(Integer sid);
    
    int deleteMsg(Integer[] id);
}