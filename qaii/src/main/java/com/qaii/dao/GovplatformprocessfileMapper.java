package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Govplatformprocessfile;

public interface GovplatformprocessfileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Govplatformprocessfile record);

    int insertSelective(Govplatformprocessfile record);

    Govplatformprocessfile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Govplatformprocessfile record);

    int updateByPrimaryKey(Govplatformprocessfile record);
    
    List<Govplatformprocessfile> getAllMsgBysid(Integer sid);
    
    int deleteMsg(Integer[] id);

    int deleteBySid(Integer sid);
}