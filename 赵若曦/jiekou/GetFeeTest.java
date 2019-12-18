package com.edu.qingguo;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.Common;

import net.sf.json.JSONObject;

public class GetFeeTest {
	String fee_url = "/common/getTransportFee";
	Checker checker=null;
	public void fee(String name,String psd,String id,String province,String city,String area) throws Exception {
		CookieStore cookie=Common.getCookie(name, psd);
		Map<String, Object> fee_para=new HashMap<String, Object>();
		fee_para.put("id", id);
		fee_para.put("addressDetail",province+"_"+city+"_"+area);
		String fee_result=HttpDriver.doGet(fee_url, fee_para,cookie);
		System.out.println(fee_result);
		checker=new Checker(fee_result);
	}
	@Test(description="成功获取id=1的运费")
	public void testGetFee1() throws Exception{
		fee("20000000000", "netease123", "1", "浙江省", "杭州市", "滨江区");
		checker.verifyXpath("message","success");
	}
	@Test(description="获取id=2的运费失败")
	public void testGetFee2() throws Exception{
		fee("20000000000", "netease123", "2", "浙江省", "杭州市", "滨江区");
		checker.verifyXpath("message","请求失败");
	}
}
