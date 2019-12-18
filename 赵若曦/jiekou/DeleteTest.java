package com.edu.qingguo;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.Common;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;

public class DeleteTest {
	
//	String delete_url="/fgadmin/address/delete";
	String delete_url="/address/delete";
	Checker  check = null;
	
	public void delete(String id) throws Exception{
		CookieStore cookie=Common.getCookie("20000000000","netease123");
		JSONObject delete=new JSONObject();
		delete.element("id",id);
		String result=HttpDriver.doPost(delete_url,delete,cookie);			
		System.out.println(result);	
		check=new Checker(result);	
	}
	
	@Test(description="É¾³ý")
	public void testDelete() throws Exception{
		delete("77479641");
		check.verifyXpath("message","success");
		check.verifyXpath("code","200");
	}
	
	
	
	
	
	
	
	


//	@Test
//	public void testDelete() throws Exception {
//		CookieStore cookie = Common.getCookie("20000000000","netease123");
//		JSONObject submit_body = new JSONObject();
//		submit_body.element("id","77243286");
//		String submit_result = HttpDriver.doPost(ReadPro.getPropValue("base_url")+delete_url, submit_body, cookie);
//		System.out.println(submit_result);
//		check= new Checker(submit_result);			
//		check.verifyXpath("message", "success");
//		check.verifyXpath("code", "200");
//		
//	}
}
