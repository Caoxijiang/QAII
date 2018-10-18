package com.qaii.dao;

import com.qaii.domain.Copyrightimg;

public interface CopyrightimgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Copyrightimg record);

    int insertSelective(Copyrightimg record);

    Copyrightimg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Copyrightimg record);

    int updateByPrimaryKey(Copyrightimg record);
}