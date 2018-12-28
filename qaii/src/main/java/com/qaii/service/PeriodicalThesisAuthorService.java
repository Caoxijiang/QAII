package com.qaii.service;

import com.qaii.domain.PeriodicalThesisAuthor;

import java.util.List;

public interface PeriodicalThesisAuthorService {

    List<PeriodicalThesisAuthor> listRecord();

    int inset(PeriodicalThesisAuthor Record);

    int delete(Integer[] id);

    int update(PeriodicalThesisAuthor Record);

    PeriodicalThesisAuthor getRecord(Integer id);
}
