package com.book.service.auth;

import com.book.model.admin.Admin;

public interface IAuthService {

	public Admin findAdmin(String username, String password);
	
}
