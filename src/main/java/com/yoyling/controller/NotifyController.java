package com.yoyling.controller;

import com.yoyling.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notify")
public class NotifyController {

	@Autowired
	private NotifyService notifyService;


}
