package com.music.review.admin.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.music.review.admin.service.AdminTestService;
import com.music.review.dao.UserMapper;
import com.music.review.domain.User;

@Service
public class AdminTestServiceImpl implements AdminTestService{
	
	@Autowired
    private UserMapper userMapper;

	@Override
	public String getTest(int flag) {
		String id = "111";
		User user = userMapper.getUserById(id);
		if(flag == 1) {
//			return "来了";
			return user.getName();
		}else {
			return "爱情走了";
		}
	}

}
