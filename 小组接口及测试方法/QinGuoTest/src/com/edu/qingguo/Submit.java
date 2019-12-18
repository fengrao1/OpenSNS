package com.edu.qingguo;


import java.io.IOException;
import java.io.ObjectOutput;

import org.apache.http.client.CookieStore;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.dataprovider.ExcelDataProvider;
import com.edu.dataprovider.NSDataProvider;
import com.edu.utils.Checker;
import com.edu.utils.Common;

import net.sf.json.JSONObject;

public class Submit {
	String submit_url = "/fgadmin/orders/submit";
	Checker checker=null;
	public void submit(Object skuIds,Object skuNumbers,Object stockIds,
			Object receiverName,Object cellPhone,Object addressDetail,
			Object province,Object city,Object area) throws Exception{
		
		CookieStore cookie=Common.getCookie("20000000000","netease123"); 
		JSONObject user1=new JSONObject();
		user1.element("skuIds", skuIds);
		user1.element("skuNumbers", skuNumbers);
		user1.element("stockIds", stockIds);
		user1.element("receiverName", receiverName);
		user1.element("cellPhone", cellPhone);
		user1.element("addressDetail", addressDetail);
		user1.element("province", province);
		user1.element("city", city);
		user1.element("area", area);
		String result = HttpDriver.doPost(submit_url, user1,cookie);
		System.out.println(result);
		checker=new Checker(result);
	}
	@Test
	public void testSubmit() throws Exception{
		submit("2,3", "1,1","74966312,74966313", "123", "12615813537", "13", "zhejiang", "hangzhou", "binjiang");
		checker.verifyXpath("message","success");

	}
//	@Test 
//	public void testSubmit1() throws Exception {
//		CookieStore cookiestore=Common.getCookie("20000000000","netease123");
//		JSONObject user=new JSONObject();
//		user.element("skuIds", "2,3");
//		user.element("skuNumbers", "1,1");
//		user.element("stockIds", "74966312,74966313");
//		user.element("receiverName", "123");
//		user.element("cellPhone", "12615813537");
//		user.element("addressDetail", "13");
//		user.element("province", "zhejiang");
//		user.element("city", "hangzhou");
//		user.element("area", "binjiang");
//		String result = HttpDriver.doPost(submit_url,user,cookiestore);
//		System.out.println(result);
//		checker=new Checker(result);
//		checker.verifyXpath("message","success");	
//
//	}
//	String submit_url = "/fgadmin/orders/submit";
//	Checker checker=null;
//	public void submit(Object skuIds,Object skuNumbers,Object stockIds,
//			Object addressDetail,Object receiverName,Object cellPhone,Object province,
//			Object city,Object area) throws Exception{
//		CookieStore cookie=Common.getCookie("20000000003","netease123");
//		 
//		JSONObject user1=new JSONObject();
//		user1.element("skuIds", skuIds);
//		user1.element("skuNumbers",skuNumbers);
//		user1.element("stockIds",stockIds);
//		user1.element("addressDetail",addressDetail);
//		user1.element("receiverName",receiverName);
//		user1.element("cellPhone",cellPhone);
//		user1.element("province", province);
//		user1.element("city", city);
//		user1.element("area", area);
//
//		String result = HttpDriver.doPost(submit_url, user1,cookie);
//		System.out.println(result);
//		checker=new Checker(result);
//	}
//	
//	
////	@DataProvider(name="excel")
////	public Object[][] getExcelDada() throws IOException{
////		return new ExcelDataProvider().getTestDataByExcel("data/user.xlsx","Sheet1");
////	}
//	@Test(description="验证正确的")
//	public void testSubmit() throws Exception{
//		submit("2,3", "1,1","74966312,74966313", "1", "123", "12345678901", "河北省", "保定市", "曲阳县");
////		String.valueOf(b);
////		Integer.getInteger(nm);
//		checker.verifyXpath("message","success");
//
//	}
	
	
}
