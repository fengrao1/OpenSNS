package com.opensns.center;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.utils.ReadProperties;
/**
 * @author ����Ƚ
 * ��վ��ҳ
 */

@Listeners(WebTestListener.class)
public class HomePageTest extends BaseTest{
	@BeforeClass
	public void login() throws Exception  {	
		webtest.open(ReadProperties.getPropertyValue("Front_url"));
		Thread.sleep(1000);
		webtest.click("link=��¼");
		Thread.sleep(2000);
		webtest.type("name=username","feng");  
		webtest.type("name=password","123456");
		webtest.click("class=login-btn");
		Thread.sleep(5000);
	}
//��վ��ҳ�Ĳ�������
	
	
//	��������4-1	
	@Test(description="�����Ʒ��ҳ")
	public void test41() throws Exception  {
		webtest.click("link=��ҳ");
		webtest.click("link=��Ʒ��ҳ");
		webtest.getWindow(1);		
		assertTrue(webtest.isTextPresent("��Ʒ"));
		driver.close();
	}

//	��������4-2	
	@Test(description="�����Ʒ��ҳ")
	public void test42() throws Exception  {
		webtest.getWindow(0);
		webtest.click("link=��ҳ");
		webtest.click("link=��������"); 
		Thread.sleep(5000);
		webtest.getWindow(1);	
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("�ҵ���Ⱥ"));
		driver.close();
	}	
	
//	��������4-3	
	@Test(description="����˽�����")
	public void test43() throws Exception  {
		webtest.getWindow(0);
		webtest.click("link=��ҳ");
		webtest.click("class=ghost-button");
		Thread.sleep(3000);	
		assertTrue(webtest.isTextPresent("�������"));
	}
}
