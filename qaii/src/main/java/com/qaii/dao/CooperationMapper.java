package com.qaii.dao;

import com.qaii.domain.Cooperation;

public interface CooperationMapper {
    int insert(Cooperation record);

    int insertSelective(Cooperation record);
}