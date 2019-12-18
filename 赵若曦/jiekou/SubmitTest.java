package com.edu.qingguo;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;
import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.Common;
import net.sf.json.JSONObject;

public class SubmitTest {
//		String submit_url="/fgadmin/orders/submit";
	String submit_url="/submit";
	Checker  check = null;
		
	@Test(description="提交")
	public void testSubmit() throws Exception {
		CookieStore cookie = Common.getCookie("20000000000","netease123");
		JSONObject submit_body = new JSONObject();
		submit_body.element("skuIds","2,3");
		submit_body.element("skuNumbers","1,1" );
		submit_body.element("stockIds","74966312,74966313");
		submit_body.element("receiverName", "zrx");
		submit_body.element("cellPhone", "15100044911");
		submit_body.element("addressDetail",  "aaa");
		submit_body.element("province", "河北省");
		submit_body.element("city", "石家庄市");
		submit_body.element("area", "长安区");
		String submit_result = HttpDriver.doPost(submit_url, submit_body, cookie);
		System.out.println(submit_result);
		check= new Checker(submit_result);			
		check.verifyXpath("message", "success");
		check.verifyXpath("code", "200");
	}
		
		
}


