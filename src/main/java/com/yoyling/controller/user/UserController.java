package com.yoyling.controller.user;

import com.yoyling.controller.BaseController;
import com.yoyling.domain.User;
import com.yoyling.utils.Constants;
import com.yoyling.utils.SetCookie;
import com.yoyling.utils.jwglxt.ZFsoft;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
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

		//如果数据库查不到就用学号密码登录教务系统
		if (user == null) {

			ZFsoft zFsoft = new ZFsoft();

			try {
				zFsoft.login(u.getUserNumber(), u.getUserPassword());

			} catch (IOException e) {
				map.put("data", "fzConnectFail");
				return map;
			}

			JSONObject jsonObject = zFsoft.getStudentInformation();

			if (jsonObject == null) {
				System.out.println("密码错误");
				map.put("data", "fzConnectAccountError");
				return map;
			} else {
				System.out.println(jsonObject);
				System.out.println(jsonObject.getString("bh_id"));
				map.put("data", "fzConnectAccountSuccess");
				return map;
			}

//			List<Score> scoreList = zFsoft.checkScore("2018","");
//
//			for(Score score:scoreList){
//				System.out.println(score);
//			}
//
//			System.out.println("共有条目：" + scoreList.size());
//
//			zFsoft.getStudentInformation();
//
//			zFsoft.checkTimetable("2018","1");

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
