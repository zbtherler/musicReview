package com.music.review.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.review.admin.service.AdminTestService;
import com.music.review.domain.AdminUser;
import com.music.review.isender.IFanoutSender;
import com.music.review.service.RedisService;

@RestController
public class AdminController {

	@Reference
	private AdminTestService AdminTestService;
	
	@Reference
	private RedisService redisService;
	
	@Reference
    private IFanoutSender fanoutSender;
	
	@RequestMapping(value = "api/admin/getAdminTest", produces = "text/html;charset=UTF-8")
	public String getAdminTest(int flag) {
		AdminUser adminUser = AdminTestService.getTest(flag);
		redisService.add("adminTest", adminUser);
		return "result";
	}
	
	
	@RequestMapping(value = "api/admin/getRedisResult", produces = "text/html;charset=UTF-8")
	public String getRedisResult() {
		AdminUser adminUser = (AdminUser) redisService.get("adminTest");
		return adminUser.getName();
	}
	
	@RequestMapping(value = "api/admin/getMqResult", produces = "text/html;charset=UTF-8")
	public String getMqResult() {
		fanoutSender.send("2222");
		return "成功";
	}
	
}
