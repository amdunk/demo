package com.book.test.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.book.model.admin.Admin;
import com.book.service.cache.ICacheService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestCache {

	@Autowired
	private ICacheService cacheService;
	
	@Test
	public void TestCache(){
//		Admin admin = new Admin();
//		admin.setId(10);
//		admin.setUsername("10 for 10");
//		admin.setPassword("test");
//		admin.setCreatedBy("123");
//		cacheService.add(admin);
		
		cacheService.test("hello", "world");
	}
	
	@Test
	public void TestGetCache(){
		String s = cacheService.get("hello");
		System.out.println(s);
		
	}
	
}
