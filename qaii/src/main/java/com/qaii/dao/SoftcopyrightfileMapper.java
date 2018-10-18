package com.qaii.dao;

import java.util.List;

import com.qaii.domain.Softcopyrightfile;

public interface SoftcopyrightfileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Softcopyrightfile record);

    int insertSelective(Softcopyrightfile record);

    Softcopyrightfile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Softcopyrightfile record);

    int updateByPrimaryKey(Softcopyrightfile record);
    
    List<Softcopyrightfile> listBysid(int sid);
}