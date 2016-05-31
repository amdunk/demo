package com.book.test.auth;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.book.model.admin.Admin;
import com.book.service.auth.IAuthService;
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestAuth {

	@Autowired
	private IAuthService authService;
	
	@Test
	public void test() {
		String username = "admin";
		String password = "admin";
		
		Admin admin = authService.findAdmin(username, password);
	}

}
