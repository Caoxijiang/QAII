package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Govrewardprocessfile;

public interface GovrewardprocessfileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Govrewardprocessfile record);

    int insertSelective(Govrewardprocessfile record);

    Govrewardprocessfile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Govrewardprocessfile record);

    int updateByPrimaryKey(Govrewardprocessfile record);
    
    List<Govrewardprocessfile> getAllMsgBysid(Integer sid);
    
    int deleteMsg(Integer[] id);

    int deleteBySid(Integer sid);

    int deleteByOid(Integer[] oid);
}