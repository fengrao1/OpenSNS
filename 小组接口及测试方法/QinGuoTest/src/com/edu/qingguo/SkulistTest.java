package com.edu.qingguo;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import com.edu.core.HttpDriver;
import com.edu.utils.Checker;

public class SkulistTest {
	String skulist_url1 = "/common/skuList2";
	String skulist_url2 = "/common/skuList1";
	Checker checker=null;
	public void getSkulist() throws Exception{
		String result=HttpDriver.doGet(skulist_url2);
		checker=new Checker(result);
		System.out.println(result);
	}
	public void getSku(Map<String, Object> para) throws Exception {
		String result=HttpDriver.doGet(skulist_url1,para);
		checker=new Checker(result);
		System.out.println(result);
	}
	@Test(description="ָ����Ʒ")
	public void test1() throws Exception {
		Map<String, Object> skuid = new HashMap<String, Object>();
		skuid.put("goodsId", 1);
		getSku(skuid);
		checker.verifyXpath("code","200");	
		
	}
	@Test(description="ָ����Ʒ")
	public void test2() throws Exception {
		Map<String, Object> skuid = new HashMap<String, Object>();
		skuid.put("goodsId", 3);
		getSku(skuid);
		checker.verifyXpath("message","��ƷID������");	
		
	}
	@Test(description="������Ʒ")
	public void test3() throws Exception {
		getSkulist();
		checker.verifyXpath("code","200");	
		
	}
}
