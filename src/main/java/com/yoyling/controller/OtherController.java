package com.yoyling.controller;

import com.yoyling.domain.Notify;
import com.yoyling.domain.Score;
import com.yoyling.domain.User;
import com.yoyling.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@ResponseBody //直接返回 json 数据
	public Map<String, Object> loginTest(User user,
			@RequestParam(value = "remember", required = false) String remember) {
		Map<String, Object> map = new HashMap();
		User userSessionInfo = null;
		if (userSessionInfo == null) {
			map.put("data", "resultFail");
		} else {
			map.put("data", "resultSuccess");
			//登录成功设置session
			session.setAttribute(Constants.USERINFO_SESSION, userSessionInfo);
			//记住密码存cookie
//			SetSession.setUserLoginCookie(user.getUserName(), user.getUserPassword(), remember, request, response);
		}
		return map;
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
