package com.yoyling.utils.jwglxt;

import com.yoyling.domain.Score;

import java.io.IOException;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		ZFsoft zFsoft=new ZFsoft();

		try {
			zFsoft.login("1812123205","cst201608221");
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Score> scoreList=zFsoft.checkScore("2018","");

		for(Score score:scoreList){
			System.out.println(score);
		}

		System.out.println("共有条目：" + scoreList.size());

		zFsoft.getStudentInformation();

		zFsoft.checkTimetable("2018","1");

	}
}