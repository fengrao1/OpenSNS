package com.edu.qingguo;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;
import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.Common;


public class AddressList {
	String list_url = "/fgadmin/address/list";
	Checker checker=null;
	public void list(String a,String b) throws Exception{
		CookieStore cookie=Common.getCookie(a, b);
		String result=HttpDriver.doGet(list_url,cookie);
		System.out.println(result);
		checker=new Checker(result);
	}

	@Test
	public void testList1() throws Exception{
		list("20000000000","netease123");		
		checker.verifyXpath("message","success");
	}
	@Test
	public void testList2() throws Exception{
		list("20000000001","netease123");		
		checker.verifyXpath("code","400");
	}
	
}
