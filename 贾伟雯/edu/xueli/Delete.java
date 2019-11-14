package com.edu.xueli;

import java.io.IOException;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Common;

import net.sf.json.JSONObject;

public class Delete {
	String address_list_url="/common/skuList";
	String de_url="/fgadmin/address/delete";
	@Test
	public void deleteTest() throws IOException, Exception {
		CookieStore cookie = Common.getCookie( "20000000003", "netease123");
		JSONObject user = new JSONObject();
		user.element("id", "83084540");
		String body = user.toString();
		HttpDriver.cookiePost(de_url, body, cookie);
		System.out.println("É¾³ý³É¹¦");
}

}
