package com.yoyling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OtherController {

	@RequestMapping("/console")
	public String console() {
		return "console";
	}
}
