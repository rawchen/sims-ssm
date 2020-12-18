package com.yoyling.service.impl;

import com.yoyling.domain.Notify;
import com.yoyling.service.NotifyService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class NotifyServiceImpl extends BaseServiceImpl implements NotifyService {

	@RequestMapping("/selectFiveNotify")
	@Override
	public List<Notify> selectFiveNotify() {
		return notifyMapper.selectFiveNotify();
	}
}
