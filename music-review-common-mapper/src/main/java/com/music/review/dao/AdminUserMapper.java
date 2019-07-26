package com.music.review.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.music.review.domain.AdminUser;

@Mapper
@Repository
public interface AdminUserMapper {
	
	public AdminUser getUserById(String id);

}
