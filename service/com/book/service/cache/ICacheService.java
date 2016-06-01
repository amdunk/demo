package com.book.service.cache;

import com.book.model.admin.Admin;

public interface ICacheService {

	public void add(Admin admin);
	
	Admin getAdmin(String key);
	
	public void test(String key, String value);
	
	public String get(String key);
}
