package com.edu.qingguo;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.sf.json.JSONObject;
/**
 * @author ��ΰ��
 * ��ȡ�˷�
 */
public class TransportFeeTest {
	@Test(description = "��ȡ�˷ѳɹ�")
	public void TransportFeeTest1() throws ClientProtocolException, IOException {
//		public static void main(String[] args) throws ClientProtocolException, IOException{
		String result = HttpDriver.doGet("http://localhost:9981/common/getTransportFee","id=1&addressDetail=�㽭ʡ_������_������");
		System.out.print(result);
		JSONObject jsonresult = JSONObject.fromObject(result);
		Assert.assertEquals(jsonresult.getString("message"), "success");
		Assert.assertEquals(jsonresult.getInt("code"), 200);
	}
	
	@Test(description = "��ȡ�˷�ʧ��")
	public void TransportFeeTest2() throws ClientProtocolException, IOException {
//		public static void main(String[] args) throws ClientProtocolException, IOException{
		String result = HttpDriver.doGet("http://localhost:9981/common/getTransportFee","id=2&addressDetail=�㽭ʡ_������_������");
		System.out.print(result);
		JSONObject jsonresult = JSONObject.fromObject(result);
		Assert.assertEquals(jsonresult.getString("message"), "����ʧ��");
		Assert.assertEquals(jsonresult.getInt("code"), 400);
	}
}
