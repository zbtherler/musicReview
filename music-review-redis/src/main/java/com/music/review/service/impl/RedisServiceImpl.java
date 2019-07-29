package com.music.review.service.impl;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.music.review.service.RedisService;

@Service
@Component
public class RedisServiceImpl implements RedisService{
	
	@Resource 
    private RedisTemplate<String, Object> redisTemplate;

	@Override
	public boolean expire(String key, long time) {
		try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public long getExpire(String key) {
		 return redisTemplate.getExpire(key, TimeUnit.SECONDS);
	}

	@Override
	public boolean hasKey(String key) {
		 try {
             return redisTemplate.hasKey(key);
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
	}
	
	@Override
	public void add(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}
	
	@Override
	public Object get(String key) {
		return redisTemplate.opsForValue().get(key);
	}
	

}
