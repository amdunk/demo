package com.book.controller.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.book.model.admin.Admin;
import com.book.service.auth.IAuthService;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private IAuthService authService;
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, HttpServletResponse response){
		
		logger.info("login");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Admin admin = authService.findAdmin(username, password);
		if(admin == null){
			request.setAttribute("error", "登录失败，请检查用户名和密码是否正确");
			return "login/login";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", admin);
			return "index/index";
		}
		
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		
		logger.info("logout");
		
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		
		return "login/login";
	}
	
}
