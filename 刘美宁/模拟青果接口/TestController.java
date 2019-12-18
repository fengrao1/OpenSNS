package com.example.demo.QGtest;
//这里很重要

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
	public class TestController { 	
		// 配置请求地址	
		@RequestMapping(value = "/test")	//在地址栏上输入跳转http://localhost:8001/test
		@ResponseBody	
		public String test() {		
			System.out.println("hello world");	//控制台输出的字段	
			// 返回字符串ok给前端		
			return "ok";	//页面上上打印出来的字段
			}
	}
	

