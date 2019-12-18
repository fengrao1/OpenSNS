package com.edu.qingguo;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.Common;

import net.sf.json.JSONObject;

public class NewAddress {
	String add_url = "/fgadmin/address/new";
	Checker checker=null;
	public void add(Object receiverName,Object cellPhone,Object addressDetail,
			Object province,Object city,Object area) throws Exception{
		CookieStore cookie=Common.getCookie("20000000000","netease123");
		JSONObject user1=new JSONObject();
		user1.element("receiverName",receiverName);
		user1.element("cellPhone",cellPhone);
		user1.element("addressDetail",addressDetail);
		user1.element("province",province);
		user1.element("city",city);
		user1.element("area",area);
		String result = HttpDriver.doPost(add_url,user1,cookie);
		
		System.out.println(result);
		checker=new Checker(result);
	}
	@Test 
	public void testAdd1() throws Exception {
		add("zhangsan", "12615813537", "13", "zhejiang", "hangzhou", "binjiang");
		checker.verifyXpath("message","success");	

	}
//	@Test 
//	public void testAdd2() throws Exception {
//		CookieStore cookiestore=Common.getCookie("20000000000","netease123");
//		JSONObject user=new JSONObject();
//		user.element("receiverName","zhangsan");
//		user.element("cellPhone","12615813537");
//		user.element("addressDetail","13");
//		user.element("province","zhejiang");
//		user.element("city","hangzhou");
//		user.element("area","binjiang");
//		String result = HttpDriver.doPost(add_url,user,cookiestore);
//		System.out.println(result);
//		checker=new Checker(result);
//		checker.verifyXpath("message","success");	
//
//	}
}
