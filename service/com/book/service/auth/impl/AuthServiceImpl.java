package com.book.service.auth.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.mapper.admin.AdminMapper;
import com.book.model.admin.Admin;
import com.book.service.auth.IAuthService;

@Service
public class AuthServiceImpl implements IAuthService {

	@Autowired
	private AdminMapper adminMapper;

	@Override
	public Admin findAdmin(String username, String password) {
		return adminMapper.selectByUsernameAndPassword(username, password);
	}
	
	
	
}
