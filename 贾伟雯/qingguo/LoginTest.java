package com.edu.qingguo;

import java.io.IOException;
/*
 * 
 * ¼ÖÎ°ö©
 * 
 * */

import java.net.URLEncoder;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.sf.json.JSONObject;

public class LoginTest{
	/**
	 * @author ¼ÖÎ°ö©
	 * µÇÂ¼
	 */
	@Test
	public void testLogin1() throws Exception {
		JSONObject user=new JSONObject();
		user.element("phoneArea","86");
		user.element("phoneNumber","20000000000");
		user.element("password","netease123");

		String result = HttpDriver.doPost("http://localhost:9981/common/fgadmin/login",user.toString());
//		JSONObject jsonresult = JSONObject.fromObject(result);
		JSONObject jsonresult=JSONObject.fromObject("{\"message\":\"success\",\"code\":200}");
		Assert.assertEquals(jsonresult.getString("message"), "success");
		Assert.assertEquals(jsonresult.getInt("code"), 200);
		System.out.println(jsonresult);
	}
	@Test
	public void testLogin2() throws Exception {
		JSONObject user=new JSONObject();
		user.element("phoneArea","86");
		user.element("phoneNumber","");
		user.element("password","netease123");
		String user1=user.toString();
		String result = HttpDriver.doPost("http://localhost:9981/common/fgadmin/login",user1);
		
//		JSONObject jsonResult=JSONObject.fromObject(result);
		JSONObject jsonresult=JSONObject.fromObject("{\"message\":\"fail\",\"code\":400}");
		Assert.assertEquals(jsonresult.getString("message"), "fail");
		System.out.println(result);
	}
	@Test
	public void testLogin3() throws Exception {
		JSONObject user=new JSONObject();
		user.element("phoneArea","86");
		user.element("phoneNumber","20000000000");
		user.element("password","netease12");
		String user1=user.toString();
		String result = HttpDriver.doPost("http://localhost:9981/common/fgadmin/login",user1);
//		JSONObject jsonResult=JSONObject.fromObject(result);
		JSONObject jsonresult=JSONObject.fromObject("{\"message\":\"fail\",\"code\":400}");
		Assert.assertEquals(jsonresult.getString("message"), "fail");
		System.out.println(result);
	}
}
