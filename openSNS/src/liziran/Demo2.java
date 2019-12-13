package liziran;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;


@Listeners(WebTestListener.class)
public class Demo2 extends BaseTest{
	@BeforeClass
	public void login() throws Exception  {	
		webtest.open(ReadProperties.getPropertyValue("Front_url"));
		Thread.sleep(1000);
		webtest.click("link=登录");
		Thread.sleep(2000);
		webtest.type("name=username","feng");  
		webtest.type("name=password","123456");
		webtest.click("class=login-btn");
		Thread.sleep(3000);
	}
	@BeforeMethod
	public void Inti() throws Exception  {	
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id=\"contents\"]/li[3]/a/div[2]/h3");
		Thread.sleep(1000);
	}
	
	@DataProvider(name="con2")
	public Object[][] words1() throws Exception{
		ExcelDataProvider d = new ExcelDataProvider();
		return d.getTestDataByExcel("data/liziran/TestData2.xlsx","Sheet1");
	}
	
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
	@AfterMethod
	public void loginOut() throws Exception  {	
		driver.close();
		webtest.getWindow(0);
		
		webtest.open(ReadProperties.getPropertyValue("Front_url"));
	}

	
	

}
