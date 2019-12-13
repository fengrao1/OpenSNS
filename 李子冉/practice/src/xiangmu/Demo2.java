package xiangmu;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;


@Listeners(com.webtest.core.ApiListener.class)
public class Demo2 extends BaseTest{
	
	@BeforeMethod
	public void Inti() throws Exception  {	
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id=\"contents\"]/li[3]/a/div[2]/h3");
		Thread.sleep(1000);
	}
	@AfterMethod
	public void loginOut() throws Exception  {	
		driver.close();
		webtest.getWindow(0);
		webtest.open(ReadProperties.getPropValue("Front_url"));
	}

	
	@DataProvider(name="con2")
	public static Object[][] words1() throws Exception{
		ExcelDataProvider d = new ExcelDataProvider();
		return d.getTestDataByExcel("C:\\Users\\dell\\Desktop\\three\\task\\TestData2.xlsx","Sheet1");
	}

	
//共7个
	
//	数据驱动
//	测试用例2-1（5个）
	@Test(description="点击分享帖子",dataProvider="con2")
	public void test5(String param1,String param2) throws Exception  {	
		webtest.click("xpath=//a[@title='"+param1+"']");
		Thread.sleep(3000);
		webtest.getWindow(1);
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent(param2));			
	}
	
//	测试用例2-1	
	@Test(description="点击分享到微信")
	public void test1() throws Exception  {
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id=\"contents\"]/li[3]/a/div[2]/h3");
		Thread.sleep(1000);
		
		webtest.click("xpath=//a[@title='分享到微信']");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("分享到微信朋友圈"));		
	}
	
//	测试用例2-2
	@Test(description="点击分享到复制网址")
	public void test2() throws Exception  {	
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id=\"contents\"]/li[3]/a/div[2]/h3");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='分享到复制网址']");
		Thread.sleep(2000);
		String content = webtest.getAlertTest();
		assertTrue(content.contains("您使用的"));		
	}
	
	
	
	

}
