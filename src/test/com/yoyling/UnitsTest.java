package com.yoyling;

import com.yoyling.utils.MyTimeUtil;
import com.yoyling.utils.SendEmailUtil;
import org.junit.Test;

import java.util.Date;

public class UnitsTest {

	@Test
	public void run1() {
		//比较当前时间毫秒值-timeComparedTo的差值是否超过了5s
		System.out.println(MyTimeUtil.getTime());
		//超过了5s，所以值为false
		System.out.println(MyTimeUtil.cmpTime(1606750404225L, 5000));
	}

	@Test
	public void run2() {
		SendEmailUtil.sendMail("yoyling_com@qq.com","123");
	}

	@Test
	public void run3() {
		System.out.println(MyTimeUtil.strToDate("2010-1-1").toString());
	}

	@Test
	public void run4() {
		System.out.println(MyTimeUtil.dateToStr(new Date()));
	}

	@Test
	public void run5() {
		System.out.println(MyTimeUtil.getAgeByBirth(MyTimeUtil.strToDate("1999-07-09")));
	}

}
