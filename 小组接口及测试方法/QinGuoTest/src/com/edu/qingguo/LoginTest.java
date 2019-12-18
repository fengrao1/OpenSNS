package com.edu.qingguo;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.core.ApiListener;
import com.edu.core.HttpDriver;
import com.edu.utils.Checker;

import net.sf.json.JSONObject;
//@Listeners(ApiListener.class)
public class LoginTest {
	String login_url = "/common/fgadmin/login";
	Checker checker=null;
	public void login(Object phoneArea,Object phoneNumber,Object psd){
		JSONObject user=new JSONObject();
		user.element("phoneArea",phoneArea);
		user.element("phoneNumber",phoneNumber);
		user.element("password",psd);
		String result=HttpDriver.doPost(login_url, user);
		System.out.println(result);
		checker=new Checker(result);
	}
	@Test
	public void testLoginSuccess() throws Exception{
		login("86", "20000000000", "netease123");
		checker.verifyXpath("message","success");		
	}
	@Test
	public void testLogin2() throws Exception {
		login("86", "", "netease123");
		checker.verifyXpath("message","用户名为空");	
	}
	@Test
	public void testLogin3() throws Exception {
		login("86", "20000000000", "netease12");
		checker.verifyXpath("message","用户名或者密码错误");	
	}
}
