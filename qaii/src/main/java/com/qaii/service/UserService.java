package com.qaii.service;

import java.util.List;

import com.qaii.domain.User;

public interface UserService {
	 User checkLogin(User user);
	 int insert(User user);
	 int delete(Integer[] userId);
}

