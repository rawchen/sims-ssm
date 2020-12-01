package com.yoyling;

import com.yoyling.domain.Notify;
import com.yoyling.mapper.NotifyMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MapperTest {

	@Autowired
	NotifyMapper notifyMapper;

	@Test
	public void run1() {
		ApplicationContext ac = new
				ClassPathXmlApplicationContext("classpath:spring-context.xml");
		NotifyMapper notifyMapper = (NotifyMapper) ac.getBean("notifyMapper");
		List<Notify> notifys = notifyMapper.selectFiveNotify();
		for (Notify n : notifys) {
			System.out.println(n);
		}
	}
}
