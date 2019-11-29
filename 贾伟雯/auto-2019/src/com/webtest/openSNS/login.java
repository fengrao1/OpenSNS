package com.webtest.openSNS;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebDriverEngine;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.jiaweiwen.ApiListener;

//登录模块
@Listeners(ApiListener.class)
public class login extends BaseTest{
	
	@DataProvider(name="user_name")
	public Object[][] data()throws IOException {
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("F://项目实训//data3.xlsx","Sheet1");
	}
	
	//数据驱动 共12条测试用例
	@Test(dataProvider="user_name",description="name")
	public void testLogin(String u_name,String p_word) throws InterruptedException {
		//打开页面
		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
		//文本框输入
		//登录成功
		webtest.click("link=登录");
		webtest.type("name=username", u_name);
		webtest.type("name=password", p_word);
		Thread.sleep(2000);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("微博"));
		webtest.click("xpath=//span[@class='user-name text-ellipsis']");
		//webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
	}
//	
//	@Test
//	public void testLoginSuccess2() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		//登录成功
//		webtest.click("link=登录");
//		webtest.type("name=username", "13303093175");
//		webtest.type("name=password", "user123456");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		Thread.sleep(2000);
//		assertTrue(webtest.isTextPresent("grandmother"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
//	@Test
//	public void testLoginFail() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		//登录失败 错误的邮箱号正确的密码
//		webtest.click("link=登录");
//		webtest.type("name=username", "183309191071@163.com");
//		webtest.type("name=password", "jww18330919107");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("jiaweiwen"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
//	@Test
//	public void testLoginFail2() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		//登录失败 错误的密码 正确的邮箱号
//		webtest.click("link=登录");
//		webtest.type("name=username", "18330919107@163.com");
//		webtest.type("name=password", "jww183309");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("jiaweiwen"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
//	@Test
//	public void testLoginFail3() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		//登录失败 空的邮箱号 和 密码
//		webtest.click("link=登录");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("jiaweiwen"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
//	@Test
//	public void testLoginFail4() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		//登录失败 输入未注册的邮箱号
//		webtest.click("link=登录");
//		webtest.type("name=username", "18731179963@163.com");
//		webtest.type("name=password", "jww18330919107");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("jiaweiwen"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
////	
//	@Test
//	public void testLoginFail5() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		//登录失败 输入未注册手机号
//		webtest.click("link=登录");
//		webtest.type("name=username", "13131986099");
//		webtest.type("name=password", "jww18330919107");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("mother"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
//	@Test
//	public void testLoginFail6() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		//登录失败 将密码中小写改为大写
//		webtest.click("link=登录");
//		webtest.type("name=username", "18330919107@163.com");
//		webtest.type("name=password", "JWW18330919107");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("jiaweiwen"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
//	@Test
//	public void testLoginFail7() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		//登录失败 使用用户名登录
//		webtest.click("link=登录");
//		webtest.type("name=username", "jiaweiwen");
//		webtest.type("name=password", "jww18330919107");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("jiaweiwen"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
//	@Test
//	public void testLoginFail8() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		//登录失败 错误的手机号错误的密码
//		webtest.click("link=登录");
//		webtest.type("name=username", "13131986099");
//		webtest.type("name=password", "jww18330919107");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("mother"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
//	@Test
//	public void testLoginFail9() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		//登录失败 正确的手机号错误的密码
//		webtest.click("link=登录");
//		webtest.type("name=username", "13303093175");
//		webtest.type("name=password", "jww18330919107");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("grandmother"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
//	@Test
//	public void testLoginFail10() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		//登录失败 邮箱名不规范
//		webtest.click("link=登录");
//		webtest.type("name=username", "18330919107@163.COM");
//		webtest.type("name=password", "jww18330919107");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("jiawenwen"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
}


