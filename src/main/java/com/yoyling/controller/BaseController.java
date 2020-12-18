package com.yoyling.controller;


import com.yoyling.service.NotifyService;
import com.yoyling.service.ScoreService;
import com.yoyling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 基础控制器，用来继承。
 * 1、自动注入所有所需服务层接口
 * 2、设置request、response、session对象
 */
@Controller
public class BaseController {

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected HttpSession session;

	@Autowired
	protected UserService userService;

	@Autowired
	protected NotifyService notifyService;

	@Autowired
	protected ScoreService scoreService;
}
