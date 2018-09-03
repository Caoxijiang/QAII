package com.qaii.dao;

import java.util.List;
import java.util.Map;

import com.qaii.domain.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    int selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
    
    UserRole findUserRoleByUserId(Integer userid);
    
    List<Map<String,Object>> findUserRoleList();
    
}