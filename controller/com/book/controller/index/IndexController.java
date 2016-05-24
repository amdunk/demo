package com.book.controller.index;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class IndexController {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@RequestMapping(value = "/")
	public String index(HttpServletRequest request, HttpServletResponse response){
		
		logger.info("index");
		
		return "index/index";
	}
	
	@RequestMapping(value = "/indexJson")
	@ResponseBody
	public Map<String, Object> indexJson(HttpServletRequest request, HttpServletResponse response){
		
		logger.info("indexJson");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("test", "test");
		map.put("test1", "test2");
		map.put("test2", "test3");
		
		return map;
	}
}
