package com.edu.qingguo;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;

public class SkulistTest {
	String sku_url = "/skulist";
	@Test(description="获取skulist带正确的参数id")
	public void testByid1() throws Exception {
		String result=HttpDriver.doGet(sku_url,"goodsId=1");
		System.out.println(result);
		Checker check=new Checker(result);		
		check.assertXpath("message", "success");	
		check.verifyXpath("code", "200");
	}

}
