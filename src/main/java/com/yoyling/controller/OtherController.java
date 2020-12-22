package com.yoyling.controller;

import com.yoyling.domain.Notify;
import com.yoyling.domain.Score;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OtherController extends BaseController {

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

	@RequestMapping("/login")
	public String test2() {
		return "login";
	}


	@RequestMapping("/json")
	@ResponseBody
	public Score toJson(){
		Score score = new Score();
		score.setCj("89");
		score.setJd(4.2f);
		return score;
	}

	@RequestMapping("/json2")
	@ResponseBody
	public Map<String, String> toJson2(){
		Map<String, String> map = new HashMap<>();
		map.put("data","111");
		map.put("data2","222");
		return map;
	}
}
