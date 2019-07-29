package com.music.review.service;

public interface RedisService {
	
	/**
	 * 指定缓存失效时间
	 * @param key
	 * @param minutes
	 */
	public boolean expire(String key, long time);
	
	/**
	 * 根据key获取过去时间
	 * @param key
	 * @return
	 */
	public long getExpire(String key);
	
	/**
	 * 判断Key是否存在
	 * @param key
	 * @return
	 */
	public boolean hasKey(String key);
	
	/**
	 * 增加缓存值
	 * @param key
	 * @param value
	 */
	public void add(String key, Object value);
	
	/**
	 * 获取缓存值
	 * @param key
	 * @return
	 */
	public Object get(String key);
	
	
}
