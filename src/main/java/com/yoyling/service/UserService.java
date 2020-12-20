package com.yoyling.service;

import com.yoyling.domain.User;

public interface UserService {
	User selectByUserNumber(String userNumber);

	User selectByUserNumberAndPassword(String userNumber, String userPassword);
}
