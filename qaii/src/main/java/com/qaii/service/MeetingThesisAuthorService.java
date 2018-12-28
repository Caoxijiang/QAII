package com.qaii.service;

import com.qaii.domain.MeetingThesisAuthor;

import java.util.List;

public interface MeetingThesisAuthorService {

    List<MeetingThesisAuthor> listAuthor();

    int inset(MeetingThesisAuthor Record);

    int delete(Integer[] id);

    int update(MeetingThesisAuthor Record);

    MeetingThesisAuthor getRecord(Integer id);
}
