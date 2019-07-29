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
	public AdminUser getTest(int flag){
		String id = "111";
		AdminUser user = adminUserMapper.getUserById(id);
		if(null != user) {
			return user;
		}else {
			return null;
		}
	}

}
