package com.qaii.service;

import com.qaii.domain.IncubatorPerson;

import java.util.List;

public interface IncubatorPersonService {

    int insertRecord(IncubatorPerson Record);

    int deleteRecords(Integer[] id);

    int updateRecord(IncubatorPerson Record);

    List<IncubatorPerson> listRecords(Integer id);
}
