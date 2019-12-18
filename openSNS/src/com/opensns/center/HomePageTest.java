package com.opensns.center;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.utils.ReadProperties;
/**
 * @author 李子冉
 * 网站首页
 */

@Listeners(WebTestListener.class)
public class HomePageTest extends BaseTest{
	@BeforeClass
	public void login() throws Exception  {	
		webtest.open(ReadProperties.getPropertyValue("Front_url"));
		Thread.sleep(1000);
		webtest.click("link=登录");
		Thread.sleep(2000);
		webtest.type("name=username","feng");  
		webtest.type("name=password","123456");
		webtest.click("class=login-btn");
		Thread.sleep(5000);
	}
//网站首页的测试用例
	
	
//	测试用例4-1	
	@Test(description="点击产品首页")
	public void test41() throws Exception  {
		webtest.click("link=首页");
		webtest.click("link=产品首页");
		webtest.getWindow(1);		
		assertTrue(webtest.isTextPresent("产品"));
		driver.close();
	}

//	测试用例4-2	
	@Test(description="点击产品首页")
	public void test42() throws Exception  {
		webtest.getWindow(0);
		webtest.click("link=首页");
		webtest.click("link=线上体验"); 
		Thread.sleep(5000);
		webtest.getWindow(1);	
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("我的社群"));
		driver.close();
	}	
	
//	测试用例4-3	
	@Test(description="点击了解详情")
	public void test43() throws Exception  {
		webtest.getWindow(0);
		webtest.click("link=首页");
		webtest.click("class=ghost-button");
		Thread.sleep(3000);	
		assertTrue(webtest.isTextPresent("解决方案"));
	}
}
