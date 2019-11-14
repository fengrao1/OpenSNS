package com.edu.xueli;

import java.io.IOException;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Common;

import net.sf.json.JSONObject;

public class New {
	String new_url="/fgadmin/address/new";
	String base_url="http://127.0.0.1:9999";
	@Test
	public void newTest() throws IOException, Exception {
		CookieStore cookie = Common.getCookie("20000000003", "netease123");
		JSONObject user = new JSONObject();
		user.element("receiverName", "lisi");
		user.element("cellPhone", "12615013537");
		user.element("addressDetail", "1dong34danyuan");
		user.element("province", "zhejiangsheng");
		user.element("city", "hangzhoushi");
		user.element("area", "binjiangqv");
		HttpDriver.doPost(base_url+new_url, user, cookie);
		System.out.println("新建成功");
}
}
