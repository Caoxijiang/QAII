package com.qaii.service;

import java.util.List;

import com.qaii.domain.Patent;

public interface PatentService {

    int insert(Patent record);
    
    List<Patent> findAllPatentInfo();
}
