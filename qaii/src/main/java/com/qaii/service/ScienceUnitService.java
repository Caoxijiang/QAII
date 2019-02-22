package com.qaii.service;

import com.qaii.domain.ScienceUnit;

import java.util.List;

public interface ScienceUnitService {

    int insertRecord(ScienceUnit Record);

    int updateRecord(ScienceUnit Record);

    int deleteRecords(Integer[] Id);

    List<ScienceUnit> listRecords();
}
