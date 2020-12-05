package com.yoyling.controller;

import com.yoyling.domain.Notify;
import com.yoyling.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OtherController {

	@Autowired
	private NotifyService notifyService;

	@RequestMapping("/console")
	public String console(Model model) {
		List<Notify> notifies = notifyService.selectFiveNotify();
		model.addAttribute("notifies",notifies);
		return "console";
	}

	@RequestMapping("/test")
	public String test() {
		return "index";
	}
}
