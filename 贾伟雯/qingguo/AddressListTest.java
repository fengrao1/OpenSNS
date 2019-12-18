package com.edu.qingguo;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.sf.json.JSONObject;

public class AddressListTest {
	/**
	 * @author ��ΰ��
	 * ��ѯ�ջ���ַ
	 */
	@Test(description = "��ѯ�ջ��ַ")
	public void AddressListTest1() throws ClientProtocolException, IOException {
//		public static void main(String[] args) throws ClientProtocolException, IOException{
		String result = HttpDriver.doGet1("http://localhost:9981/fgadmin/address/list");
		System.out.print(result);
		JSONObject jsonresult = JSONObject.fromObject(result);
		Assert.assertEquals(jsonresult.getString("message"), "success");
		Assert.assertEquals(jsonresult.getInt("code"), 200);
	}
}
