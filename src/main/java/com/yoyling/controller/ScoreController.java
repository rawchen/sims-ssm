package com.yoyling.controller;

import com.yoyling.domain.Score;
import com.yoyling.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/score")
public class ScoreController {

	@Autowired
	private ScoreService scoreService;


	@RequestMapping("/selectByPrimaryKey")
	public String selectByPrimaryKey(Model model) {
		Score score= scoreService.selectByPrimaryKey(1);
		model.addAttribute("score",score);
		return "demo";
	}

}
