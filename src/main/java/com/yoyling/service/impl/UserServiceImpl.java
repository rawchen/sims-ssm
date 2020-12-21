package com.yoyling.service.impl;

import com.yoyling.domain.User;
import com.yoyling.mapper.UserMapper;
import com.yoyling.service.UserService;
import com.yoyling.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User selectByUserNumber(String userNumber) {
		return userMapper.selectByUserNumber(userNumber);
	}

	@Override
	public User selectByUserNumberAndPassword(User user) {
		return userMapper.selectByUserNumberAndPassword(user);
	}

	@Override
	public void deleteUserSession(HttpSession session) {
		session.removeAttribute(Constants.USERINFO_SESSION);
	}
}
