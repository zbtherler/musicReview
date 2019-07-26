package com.music.review.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.music.review.domain.User;

@Mapper
@Repository
public interface UserMapper {
	
	@Select("select * from music_review_admin_user where id=#{id}")
	public User getUserById(String id);

}
