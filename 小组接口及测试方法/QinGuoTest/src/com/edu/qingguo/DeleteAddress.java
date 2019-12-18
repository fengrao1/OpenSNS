package com.edu.qingguo;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.Common;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DeleteAddress {
	String delete_url="/fgadmin/address/delete";
	Checker checker=null;
	
	public void testDelete1(String id) throws Exception {
		CookieStore cookie = Common.getCookie("20000000000","netease123");
		JSONObject jsonObject =new JSONObject();
		jsonObject.element("id",id);
		String delete_result=HttpDriver.doPost(delete_url+"?id="+id,jsonObject,cookie);
		System.out.println(delete_result);
		checker=new Checker(delete_result);

	}
	@Test
	public void test1() throws Exception{
		testDelete1("77243286");
		checker.verifyXpath("message","success");
		checker.verifyXpath("code","200");
	}
	@Test
	public void test2() throws Exception{
		testDelete1("7724328");
		checker.verifyXpath("message","«Î«Û ß∞‹");
		checker.verifyXpath("code","400");
	}
//	String address_list_url = "/fgadmin/address/list";
//	String delete_url="/fgadmin/address/delete";
//	Checker checker=null;
//	public void delete(String name,String psd) throws Exception{
//		CookieStore cookie = Common.getCookie(name,psd);
//		String address_result = HttpDriver.doGet(address_list_url, cookie);
//		JSONObject json_address = JSONObject.fromObject(address_result);
//		if(json_address.getJSONObject("result").containsKey("list")){
//			JSONArray array = json_address.getJSONObject("result").getJSONArray("list");
//			int size=array.size();
//			System.out.println(size);
//			for(int i=0;i<size;i++){
//				int id=json_address.getJSONObject("result").getJSONArray("list").getJSONObject(i).getInt("id");
//				System.out.println(id);
//				JSONObject jsonObject =new JSONObject();
//				jsonObject.element("id",id);
//				String delete_result=HttpDriver.doPost(delete_url,jsonObject,cookie);
//				System.out.println(delete_result);
//				checker=new Checker(delete_result);
//			}
//		}
//	}
//	@Test
//	public void testDelete1() throws Exception {
//		CookieStore cookie = Common.getCookie("20000000003","netease123");
//		JSONObject jsonObject =new JSONObject();
//		jsonObject.element("id","77243286");
//		String delete_result=HttpDriver.doPost(delete_url,jsonObject,cookie);
//		System.out.println(delete_result);
//		checker=new Checker(delete_result);
//		checker.verifyXpath("message","success");
//	}
//	@Test
//	public void testDelete() throws Exception {
//		delete("20000000000","netease123");
//		checker.verifyXpath("message","success");	
////		int id1=json_address.getJSONObject("result").getJSONArray("list").getJSONObject(0).getInt("id");
////		JSONObject jsonObject =new JSONObject();
////		jsonObject.element("id",id1);
////
////		String delete_result=HttpDriver.doPost(delete_url,jsonObject,cookie);
////		System.out.println(delete_result);
//
//		
//
//	}
}
