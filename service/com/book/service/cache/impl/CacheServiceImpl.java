package com.book.service.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.book.model.admin.Admin;
import com.book.service.cache.ICacheService;

@Service
public class CacheServiceImpl implements ICacheService{

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Override
	public void add(Admin admin) {
		ValueOperations<String, Admin> valueops = redisTemplate.opsForValue();
		valueops.set(admin.getId().toString(), admin);
	}

	@Override
	public Admin getAdmin(String key) {
		ValueOperations<String, Admin> valueops = redisTemplate.opsForValue();
		Admin admin = valueops.get(key);
        return admin;
	}

	@Override
	public void test(String key, String value) {
		ValueOperations<String, String> valueops = redisTemplate.opsForValue();
		valueops.set(key, value);
	}
	
	public String get(String key){
		ValueOperations<String, String> valueops = redisTemplate.opsForValue();
		return valueops.get(key);
	}

	

}
