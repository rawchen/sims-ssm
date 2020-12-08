package com.yoyling.utils.jwglxt;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		ZFsoft zFsoft=new ZFsoft();

		zFsoft.login("1812123206","csq990709..");

		List<Score> scoreList=zFsoft.checkScore("2018","");

		for(Score score:scoreList){
			System.out.println(score);
		}

		System.out.println("共有条目：" + scoreList.size());

		zFsoft.getStudentInformation();

		zFsoft.checkTimetable("2018","1");

	}
}