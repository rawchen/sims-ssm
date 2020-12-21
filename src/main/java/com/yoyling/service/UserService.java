package com.yoyling.service;

import com.yoyling.domain.User;

import javax.servlet.http.HttpSession;

public interface UserService {
	User selectByUserNumber(String userNumber);

	User selectByUserNumberAndPassword(User user);

	void deleteUserSession(HttpSession session);
}
