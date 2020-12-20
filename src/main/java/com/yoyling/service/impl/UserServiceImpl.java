package com.yoyling.service.impl;

import com.yoyling.domain.User;
import com.yoyling.mapper.UserMapper;
import com.yoyling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User selectByUserNumber(String userNumber) {
		return userMapper.selectByUserNumber(userNumber);
	}

	@Override
	public User selectByUserNumberAndPassword(String userNumber, String userPassword) {
		return userMapper.selectByUserNumberAndPassword(userNumber,userPassword);
	}
}
