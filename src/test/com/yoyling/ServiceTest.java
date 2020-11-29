package com.yoyling;

import com.yoyling.domain.Score;
import com.yoyling.service.ScoreService;
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
}
