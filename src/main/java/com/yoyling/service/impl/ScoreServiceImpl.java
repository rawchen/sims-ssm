package com.yoyling.service.impl;

import com.yoyling.domain.Score;
import com.yoyling.mapper.ScoreMapper;
import com.yoyling.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreMapper scoreMapper;

	@Override
	public Score selectByPrimaryKey(Integer scoreId) {
		return scoreMapper.selectByPrimaryKey(1);
	}
}
