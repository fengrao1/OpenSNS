package xiangmu;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;

@Listeners(com.webtest.core.ApiListener.class)
public class Demo4 extends BaseTest{
	
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
		webtest.click("link=首页");
		webtest.click("link=线上体验");
		Thread.sleep(3000);
		webtest.getWindow(1);		
		assertTrue(webtest.isTextPresent("我的社群"));
		driver.close();
	}	
	
//	测试用例4-3	
	@Test(description="点击了解详情")
	public void test43() throws Exception  {
		webtest.click("link=首页");
		webtest.click("class=ghost-button");
		Thread.sleep(3000);	
	}

//	测试用例4-4	
//	@Test(description="点击了解详情")
//	public void test44() throws Exception  {
//		webtest.click("link=首页");
//		webtest.mouseoverElement("/html/body/div[5]/div/div/div[1]");
//		webtest.click("xpath=/html/body/div[5]/div/div/div[1]/div/div");
//		Thread.sleep(3000);	
//		webtest.getWindow(1);		
//		assertTrue(webtest.isTextPresent("洞察数据"));
//		driver.close();
//	}
	

	
	

}
