package com.edu.qingguo;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;
import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.Common;

import net.sf.json.JSONObject;
//场景2：完整下单流程(未登录、有收货地址)
public class Changjing2 {
	String address_list_url = "/fgadmin/address/list";
	String fee_url = "/common/getTransportFee";
	String submit_url="/fgadmin/orders/submit";
	Checker checker=null;
	@Test
	public void testChangjing1() throws Exception {
//		1、登录
		CookieStore cookie = Common.getCookie("20000000000","netease123");

//		2、获取地址/fgadmin/address/list
		String address_result = HttpDriver.doGet(address_list_url, cookie);
		System.out.println(address_result);
		JSONObject json_address = JSONObject.fromObject(address_result);
		JSONObject address1 = json_address.getJSONObject("result").getJSONArray("list").getJSONObject(0);

		String province = address1.getString("province");
		String city = address1.getString("city");
		String area = address1.getString("area");
		String receiverName = address1.getString("receiverName");
		String cellPhone = address1.getString("cellPhone");
		String addressDetail = address1.getString("addressDetail");

		// 3、获取运费?id=1&=浙江省_杭州市_滨江区
		Map<String, Object> fee_para=new HashMap<String, Object>();
		fee_para.put("id", "1");
		fee_para.put("addressDetail",province+"_"+city+"_"+area);
		String fee_result=HttpDriver.doGet(fee_url, fee_para,cookie);
		System.out.println(fee_result);
//		4、Submit
		JSONObject user1=new JSONObject();
		user1.element("skuIds", "2,3");
		user1.element("skuNumbers","1,1");
		user1.element("stockIds","74966312,74966313");
		user1.element("addressDetail",addressDetail);
		user1.element("receiverName",receiverName);
		user1.element("cellPhone",cellPhone);
		user1.element("province", province);
		user1.element("city", city);
		user1.element("area", area);
		
		String submit_result=HttpDriver.doPost(submit_url,user1,cookie);
		System.out.println(submit_result);
	}
}
