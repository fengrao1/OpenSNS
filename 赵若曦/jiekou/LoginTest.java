package com.edu.qingguo;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;

import net.sf.json.JSONObject;

public class LoginTest {
//	String login_url="/common/fgadmin/login";
	String login_url="/login";
	Checker  check = null;
	
	public void login(Object phoneArea,Object phoneNumber,Object password) {
		JSONObject user = new  JSONObject();
		user.element("phoneArea", phoneArea);
		user.element("phoneNumber", phoneNumber);
		user.element("password", password);
		String result = HttpDriver.doPost(login_url, user);
		System.out.println(result);	
		check=new Checker(result);
	}
	
	@Test
	public void  testLoginSuccess()throws Exception{
		login("86", "20000000000", "netease123");
		check.verifyTextPresent("message");
	//	check.verifyXpath("code", "200");
	}
}