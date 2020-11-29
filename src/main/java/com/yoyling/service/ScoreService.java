package com.yoyling.service;

import com.yoyling.domain.Score;

public interface ScoreService {
	Score selectByPrimaryKey(Integer scoreId);
}
