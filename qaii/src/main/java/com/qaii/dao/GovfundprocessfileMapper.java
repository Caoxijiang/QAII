package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Govfundprocessfile;

public interface GovfundprocessfileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Govfundprocessfile record);

    int insertSelective(Govfundprocessfile record);

    Govfundprocessfile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Govfundprocessfile record);

    int updateByPrimaryKey(Govfundprocessfile record);
    
    List<Govfundprocessfile> getAllMsgBysid(Integer sid);
    
    int deleteMsg(Integer[] id);
}