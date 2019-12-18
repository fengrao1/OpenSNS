package com.edu.qingguo;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.sf.json.JSONObject;
/**
 * @author 贾伟雯
 * 获取运费
 */
public class TransportFeeTest {
	@Test(description = "获取运费成功")
	public void TransportFeeTest1() throws ClientProtocolException, IOException {
//		public static void main(String[] args) throws ClientProtocolException, IOException{
		String result = HttpDriver.doGet("http://localhost:9981/common/getTransportFee","id=1&addressDetail=浙江省_杭州市_滨江区");
		System.out.print(result);
		JSONObject jsonresult = JSONObject.fromObject(result);
		Assert.assertEquals(jsonresult.getString("message"), "success");
		Assert.assertEquals(jsonresult.getInt("code"), 200);
	}
	
	@Test(description = "获取运费失败")
	public void TransportFeeTest2() throws ClientProtocolException, IOException {
//		public static void main(String[] args) throws ClientProtocolException, IOException{
		String result = HttpDriver.doGet("http://localhost:9981/common/getTransportFee","id=2&addressDetail=浙江省_杭州市_滨江区");
		System.out.print(result);
		JSONObject jsonresult = JSONObject.fromObject(result);
		Assert.assertEquals(jsonresult.getString("message"), "请求失败");
		Assert.assertEquals(jsonresult.getInt("code"), 400);
	}
}
