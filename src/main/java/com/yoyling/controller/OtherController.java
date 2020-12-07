package com.yoyling.controller;

import com.yoyling.domain.Notify;
import com.yoyling.domain.User;
import com.yoyling.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@ResponseBody //直接返回 json 数据
	public Map<String, Object> loginTest(User user, @RequestParam(value = "remember", required = false) String remember) {
		Map<String, Object> map = new HashMap();
		User userSessionInfo = null;
		if (userSessionInfo == null) {
			map.put("data", "resultFail");
		} else {
			map.put("data", "resultSuccess");
			//登录成功设置session
//			session.setAttribute(Constants.USERINFO_SESSION, userSessionInfo);
			//记住密码存cookie
//			SetCookie.setUserLoginCookie(user.getUserName(), user.getUserPassword(), remember, request, response);
		}
		return map;
	}

	@RequestMapping("/userLogin")
	public String userLogin(HttpServletRequest request) {
		String a = request.getParameter("username");
		String b = request.getParameter("password");
		String c = request.getParameter("");
		System.out.println(a);
		System.out.println(b);
		return "index";
	}
}
