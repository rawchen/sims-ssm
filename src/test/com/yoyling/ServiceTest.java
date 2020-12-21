package com.yoyling;

import com.yoyling.domain.Score;
import com.yoyling.domain.Student;
import com.yoyling.domain.User;
import com.yoyling.service.ScoreService;
import com.yoyling.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTest {
	@Test
	public void run1() {
		ApplicationContext ac = new
				ClassPathXmlApplicationContext("classpath:spring-context.xml");
		ScoreService scoreService = (ScoreService) ac.getBean("scoreService");
		Score score = scoreService.selectByPrimaryKey(1);
		System.out.println(score);
	}

	@Test
	public void run2() {
		Student student = new Student();
		student.setClassesId(1);
		student.setStudentEmail("123123@qq.com");
		System.out.println(student);
	}

	@Test
	public void run3() {
		ApplicationContext ac = new
				ClassPathXmlApplicationContext("classpath:spring-context.xml");
		UserService userService = (UserService) ac.getBean("userService");
		User user = userService.selectByUserNumber("1812123206");
		System.out.println(user);
	}

	@Test
	public void run4() {
		ApplicationContext ac = new
				ClassPathXmlApplicationContext("classpath:spring-context.xml");
		UserService userService = (UserService) ac.getBean("userService");

		User user = new User();
		user.setUserNumber("1812123206");
		user.setUserPassword("123456");
		User user2 = userService.selectByUserNumberAndPassword(user);
		System.out.println(user2);
	}


}
