package com.yoyling.service;

import com.yoyling.domain.Notify;

import java.util.List;

public interface NotifyService {
	List<Notify> selectFiveNotify();
}
