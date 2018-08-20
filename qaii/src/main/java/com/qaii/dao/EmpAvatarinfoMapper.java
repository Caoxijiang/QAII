package com.qaii.dao;

import com.qaii.domain.EmpAvatarinfo;

public interface EmpAvatarinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmpAvatarinfo record);

    int insertSelective(EmpAvatarinfo record);

    EmpAvatarinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmpAvatarinfo record);

    int updateByPrimaryKey(EmpAvatarinfo record);
}