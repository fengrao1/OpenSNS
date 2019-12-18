package com.edu.qingguo;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import com.edu.core.HttpDriver;
import com.edu.utils.Checker;

//场景1：浏览商品列表并查看商品详情
public class Changjing1 {
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
	@Test(description="1、获取所有商品的sku列表成功",priority=1)
	public void test1() throws Exception {
		getSkulist();
		checker.verifyXpath("code","200");	
	}
	@Test(description="2、获取goodsId=1的商品sku信息成功",priority=2)
	public void test2() throws Exception {
		Map<String, Object> skuid = new HashMap<String, Object>();
		skuid.put("goodsId", "1");
		getSku(skuid);
		checker.verifyXpath("code","200");	
		
	}
	@Test(description="3、获取goodsId=2的商品sku信息成功",priority=3)
	public void test3() throws Exception {
		Map<String, Object> skuid = new HashMap<String, Object>();
		skuid.put("goodsId", "2");
		getSku(skuid);
		checker.verifyXpath("code","200");	
		
	}
	@Test(description="3、获取goodsId=3的商品sku信息成功",priority=4)
	public void test4() throws Exception {
		Map<String, Object> skuid = new HashMap<String, Object>();
		skuid.put("goodsId", "3");
		getSku(skuid);
		checker.verifyXpath("message","商品ID不存在");	
		
	}
}
