package com.music.review.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.review.admin.service.AdminTestService;

@RestController
public class AdminController {

	@Reference
	private AdminTestService AdminTestService;
	
	@RequestMapping(value = "api/admin/getAdminTest", produces = "text/html;charset=UTF-8")
	public String getAdminTest(int flag) {
		return AdminTestService.getTest(flag);
	}
}
