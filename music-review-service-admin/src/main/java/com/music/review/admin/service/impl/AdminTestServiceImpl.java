package com.music.review.admin.service.impl;

import org.apache.dubbo.config.annotation.Service;

import com.music.review.admin.service.AdminTestService;

@Service
public class AdminTestServiceImpl implements AdminTestService{

	@Override
	public String getTest(int flag) {
		if(flag == 1) {
			return "爱情来了";
		}else {
			return "爱情走了";
		}
	}

}
