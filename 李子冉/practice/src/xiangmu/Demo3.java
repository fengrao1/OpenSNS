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
public class Demo3 extends BaseTest{
	@BeforeMethod
	public void Inti() throws Exception  {	
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id=\"contents\"]/li[1]/a/div[2]/object/a/span[4]");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id=\"weibo_5\"]/div[1]/div/div[2]/div/div[2]/div[4]/span/a/i");
	}
	@AfterMethod
	public void loginOut() throws Exception  {	
		driver.close();
		webtest.getWindow(0);
		webtest.open(ReadProperties.getPropValue("Front_url"));
	}
	
	
	@DataProvider(name="con3")
	public static Object[][] words1() throws Exception{
		ExcelDataProvider d = new ExcelDataProvider();
		return d.getTestDataByExcel("C:\\Users\\dell\\Desktop\\three\\task\\TestData3.xlsx","Sheet1");
	}

//��5��	
	
//	��������		
//	��������3-1��4����
	@Test(description="�����������",dataProvider="con3")
	public void test31(String param1,String param2) throws Exception  {
		
		webtest.click("link="+param1+"");	
		Thread.sleep(2000);
		webtest.getWindow(1);
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent(param2));
	}
	
//	��������3-2	
	@Test(description="�������΢��")
	public void test32() throws Exception  {	
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id=\"contents\"]/li[1]/a/div[2]/object/a/span[4]");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id=\"weibo_5\"]/div[1]/div/div[2]/div/div[2]/div[4]/span/a/i");
		webtest.click("link=΢��");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("����΢������Ȧ"));		
	}
	
	
}
