package com.edu.qingguo;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import com.edu.core.HttpDriver;
import com.edu.utils.Checker;

//����1�������Ʒ�б��鿴��Ʒ����
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
	@Test(description="1����ȡ������Ʒ��sku�б�ɹ�",priority=1)
	public void test1() throws Exception {
		getSkulist();
		checker.verifyXpath("code","200");	
	}
	@Test(description="2����ȡgoodsId=1����Ʒsku��Ϣ�ɹ�",priority=2)
	public void test2() throws Exception {
		Map<String, Object> skuid = new HashMap<String, Object>();
		skuid.put("goodsId", "1");
		getSku(skuid);
		checker.verifyXpath("code","200");	
		
	}
	@Test(description="3����ȡgoodsId=2����Ʒsku��Ϣ�ɹ�",priority=3)
	public void test3() throws Exception {
		Map<String, Object> skuid = new HashMap<String, Object>();
		skuid.put("goodsId", "2");
		getSku(skuid);
		checker.verifyXpath("code","200");	
		
	}
	@Test(description="3����ȡgoodsId=3����Ʒsku��Ϣ�ɹ�",priority=4)
	public void test4() throws Exception {
		Map<String, Object> skuid = new HashMap<String, Object>();
		skuid.put("goodsId", "3");
		getSku(skuid);
		checker.verifyXpath("message","��ƷID������");	
		
	}
}
