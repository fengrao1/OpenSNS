package com.edu.qingguo;

import static org.testng.Assert.assertEquals;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.Common;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;

public class NewAddressTest {
//	String add = "/fgadmin/address/new";
	String add = "address/new";
	Checker  check = null;

	@Test(description="Ìí¼Ó³É¹¦")
	public void testadd()throws Exception {
		CookieStore cookie = Common.getCookie("20000000000","netease123");
		JSONObject user=new JSONObject();
		user.element("id", "");
		user.element("receiverName", "zrx");
		user.element("cellPhone", "15100044911");
		user.element("province", "hebei");
		user.element("city", "sjz");
		user.element("area", "yuhua");
		user.element("addressDetail", "bbb");
		String result=HttpDriver.doPost(add, user,cookie);	
		System.out.println(result);
		check=new Checker(result);
		check.verifyXpath("message","success");
		check.verifyXpath("code", "200");
		
	}
}
