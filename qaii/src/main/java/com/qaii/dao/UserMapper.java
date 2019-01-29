package com.qaii.dao;

import org.apache.ibatis.annotations.Param;

import com.qaii.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer[] userId);

    void  insert(User user);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
//    User findWithLoginAndPassword(@Param("adminAccount")String loginname,@Param("adminPwd")String password);
    User findWithLoginAndPassword(User user);
    int findWithLogin(User user);
    int updatePassword(User user);

    User findPasswordByUserName(String UserName);
}