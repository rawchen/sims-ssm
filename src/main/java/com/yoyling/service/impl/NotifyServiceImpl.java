package com.yoyling.service.impl;

import com.yoyling.domain.Notify;
import com.yoyling.mapper.NotifyMapper;
import com.yoyling.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("notifyService")
public class NotifyServiceImpl implements NotifyService {

	@Autowired
	private NotifyMapper notifyMapper;

	@Override
	public List<Notify> selectFiveNotify() {
		return notifyMapper.selectFiveNotify();
	}
}
