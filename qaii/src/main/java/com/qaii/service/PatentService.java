package com.qaii.service;



import java.util.List;

import com.qaii.domain.Patent;

public interface PatentService {

    int insert(Patent record);
    
    List<Patent> findAllPatentInfo();
    
    Patent selectByPrimaryKey(Integer id);
    
    int deleteByPrimaryKey(Integer[] id);
    
    int updateByPrimaryKey(Patent record);
    
    int getPatentCount();
    
    int countAgencyPatent(String firstDay, String endDay);
    
}

