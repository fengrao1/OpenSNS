package com.opensns.frontstage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
/**
 * @author 贾伟雯
 * 注册
 */
//注册模块
@Listeners(WebTestListener.class)
public class Register extends BaseTest{
	@DataProvider(name="register_name1")
	public Object[][] data()throws IOException {
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("data/jiaweiwen/data1.xlsx","Sheet1");
	}
	@DataProvider(name="register_name2")
	public Object[][] data1()throws IOException {
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("data/jiaweiwen/data2.xlsx","Sheet1");
	}
	
	//数据驱动 共9条测试用例  邮箱注册
	@Test(dataProvider="register_name1",description="邮箱注册")
	public void testRegister(String u_name,String n_name,String p_word,String string) throws InterruptedException, IOException {
		String opensns_url =ReadProperties.getPropertyValue("base_url");
		//打开页面
		webtest.open(opensns_url);
		//文本框输入
		webtest.click("link=注册");
		//邮箱注册 
		webtest.click("link=邮箱注册");
		webtest.type("name=username", u_name);
		webtest.type("name=nickname", n_name);
		webtest.type("name=password", p_word);
		Thread.sleep(3000);
		webtest.click("xpath=//button[@type='submit']");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent(string));
	}
	
	//数据驱动 共10条测试用例 手机号注册
	@Test(dataProvider="register_name2",description="手机注册")
	public void testRegisterByPhoneSuccess(String u_name,String n_name,String p_word,String aString) throws InterruptedException, IOException {
		String opensns_url =ReadProperties.getPropertyValue("base_url");
		//打开页面
		webtest.open(opensns_url);
		//文本框输入
		webtest.click("link=注册");
		//手机号注册 
		webtest.click("link=手机注册");
		webtest.type("id=mobile", u_name);
		webtest.type("id=nickname", n_name);
		webtest.type("id=inputPassword", p_word);
		Thread.sleep(3000);
		webtest.click("xpath=//button[@type='submit']");
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent(aString));
	}
}



