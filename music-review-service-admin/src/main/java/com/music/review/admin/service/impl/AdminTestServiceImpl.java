package com.music.review.admin.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.music.review.admin.service.AdminTestService;
import com.music.review.dao.AdminUserMapper;
import com.music.review.domain.AdminUser;

@Service
public class AdminTestServiceImpl implements AdminTestService{
	
	@Autowired
    private AdminUserMapper adminUserMapper;

	@Override
	public String getTest(int flag) {
		String id = "111";
		AdminUser user = adminUserMapper.getUserById(id);
		if(flag == 1) {
//			return "来了";
			return user.getName();
		}else {
			return "爱情走了";
		}
	}

}
