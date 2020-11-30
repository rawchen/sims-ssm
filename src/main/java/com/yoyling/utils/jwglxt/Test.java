package com.yoyling.utils.jwglxt;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		ZFsoft zFsoft=new ZFsoft();
		List<Score> scoreList=zFsoft
				.login("1812123206","csq990709..")
				.checkScore("2018","16");

		for(Score score:scoreList){
			System.out.println(score);
		}

		System.out.println(scoreList.size());
	}
}