package com.yoyling.controller.user;

import com.yoyling.controller.BaseController;
import com.yoyling.domain.User;
import com.yoyling.utils.Constants;
import com.yoyling.utils.SetCookie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {


	@RequestMapping("/userLogin")
	@ResponseBody
	public Map<String,Object> selectByUserNumber(User u,
												 @RequestParam(value = "remember", required = false) String remember) {
		Map<String, Object> map = new HashMap<>();
		User user = userService.selectByUserNumberAndPassword(u);
		if (user == null) {
			map.put("data", "fail");
		} else {
			map.put("data","success");

			//登录成功设置session
			session.setAttribute(Constants.USERINFO_SESSION, user);
			//记住密码存cookie
			SetCookie.setUserLoginCookie(user.getUserName(), user.getUserPassword(), remember, request, response);
		}
		return map;
	}

	@RequestMapping("/logout")
	public String logout() {
		userService.deleteUserSession(session);
		return "user/login";
	}

}
