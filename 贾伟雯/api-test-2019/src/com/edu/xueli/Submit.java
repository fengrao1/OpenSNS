package com.edu.xueli;

import java.io.IOException;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Common;

import net.sf.json.JSONObject;

public class Submit {
	String submit_url="/fgadmin/orders/submit";
	String base_url="http://127.0.0.1:9999";
	@Test
	public void submitTest() throws IOException, Exception {
		CookieStore cookieStore =Common.getCookie("20000000000", "netease123");
		JSONObject user=new JSONObject();
		user.element("skuIds", "2,3");
		user.element("skuNumbers", "1,1");
		user.element("stockIds", "74966312,74966313");
		user.element("receiverName", "zhangsan");
		user.element("cellPhone", "12615813537");
		user.element("addressDetail", "1dong3danyuan");
		user.element("province", "zhejaingsheng");
		user.element("city", "hangzhoushi");
		user.element("area", "binjiangqv");
		user.element("voiceStatus", "0");
		user.element("needInvoice", 0);
		user.element("invoiceHead", "");
		user.element("transportFee", 0);
		user.element("logisticsCompanyId", 1);
		user.element("accessSource", "noSource");
		user.element("accessDevice", 0);
		String body = user.toString();
		HttpDriver.cookiePost(base_url+submit_url, body, cookieStore);
		System.out.println("提交成功");
	}
}
