package com.edu.qingguo;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

public class SkulistTest {
	/**
	 * @author 贾伟雯
	 * 获取商品列表
	 */
	@Test(description = "获取所有商品的sku列表成功")
	public void SkulistTest1() throws ClientProtocolException, IOException {
//		public static void main(String[] args) throws ClientProtocolException, IOException{
		String result = HttpDriver.doGet1("http://localhost:9981/common/skuList1");
		System.out.print(result);
		JSONObject jsonresult = JSONObject.fromObject(result);
		Assert.assertEquals(jsonresult.getString("message"), "success");
		Assert.assertEquals(jsonresult.getInt("code"), 200);
	}

	@Test(description="获取goodsId=1的商品sku信息成功")
	public void textSkulist1() throws ClientProtocolException, IOException {
		String result=HttpDriver.doGet("http://localhost:9981/common/skuList","goodsId=1");
		System.out.print(result);
		JSONObject jsonresult=JSONObject.fromObject(result);
		Assert.assertEquals(jsonresult.getString("message"), "success");
		//如何逐层获json中的数据assertEquals(jsonresult.getJSONArray(result)[0].get("goodsId"),1);
		Assert.assertEquals(jsonresult.getInt("code"), 200);
	}

	@Test(description="获取goodsId=2147483648的商品sku信息失败")
	public void SkulistTest2() throws ClientProtocolException, IOException {
		String result=HttpDriver.doGet("http://localhost:9981/common/skuList","goodsId=2147483648");
		JSONObject jsonresult=JSONObject.fromObject(result);
		System.out.print(result);
		Assert.assertEquals(jsonresult.getString("message"), "success");
		//如何逐层获json中的数据assertEquals(jsonresult.getJSONArray(result)[0].get("goodsId"),1);
		Assert.assertEquals(jsonresult.getInt("code"), 200);
	}

}
