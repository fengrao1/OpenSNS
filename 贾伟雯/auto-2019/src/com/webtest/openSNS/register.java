package com.webtest.openSNS;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.jiaweiwen.ApiListener;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
//注册模块
@Listeners(ApiListener.class)
public class register extends BaseTest{
	@DataProvider(name="register_name")
	public Object[][] data()throws IOException {
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("F://项目实训//data2.xlsx","Sheet1");
	}
	
	//数据驱动 共18条测试用例  邮箱注册
	@Test(dataProvider="register_name",description="邮箱注册")
	public void testRegister(String u_name,String n_name,String p_word) throws InterruptedException {
		//打开页面
		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
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
		assertTrue(webtest.isTextPresent("微博"));
	}
	
	//数据驱动 共18条测试用例 手机号注册
	@Test(dataProvider="register_name",description="手机注册")
	public void testRegisterByPhoneSuccess(String u_name,String n_name,String p_word) throws InterruptedException {
		//打开页面
		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
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
		assertTrue(webtest.isTextPresent("微博"));
	}
	
//	@Test
//	public void testRegisterByEmailFail() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		webtest.click("link=注册");
//		//邮箱注册 失败 使用已注册邮箱注册
//		webtest.click("link=邮箱注册");
//		webtest.type("name=username", "18330919107@163.com");
//		webtest.type("name=nickname", "user2");
//		webtest.type("name=password", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
//	
//	@Test
//	public void testRegisterByEmailFail2() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		webtest.click("link=注册");
//		//邮箱注册 失败 使用长度不符合要求的密码
//		webtest.click("link=邮箱注册");
//		webtest.type("name=username", "18330919107@163.com");
//		webtest.type("name=nickname", "user3");
//		webtest.type("name=password", "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
//	
//	@Test
//	public void testRegisterByEmailFail3() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		webtest.click("link=注册");
//		//邮箱注册 失败 使用不正确的邮箱
//		webtest.click("link=邮箱注册");
//		webtest.type("name=username", "18330919107");
//		webtest.type("name=nickname", "user4");
//		webtest.type("name=password", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
//	
//	@Test
//	public void testRegisterByEmailFail4() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		webtest.click("link=注册");
//		//邮箱注册 失败 使用已注册的用户名
//		webtest.click("link=邮箱注册");
//		webtest.type("name=username", "272904051@qq.com");
//		webtest.type("name=nickname", "jiaweiwen");
//		webtest.type("name=password", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
//	
//	@Test
//	public void testRegisterByEmailFail5() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		webtest.click("link=注册");
//		//邮箱注册 失败 使用不符合要求的用户名
//		webtest.click("link=邮箱注册");
//		webtest.type("name=username", "272904051@qq.com");
//		webtest.type("name=nickname", "&&&&&&&&");
//		webtest.type("name=password", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
//	
//	@Test
//	public void testRegisterByEmailFail6() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		webtest.click("link=注册");
//		//邮箱注册 失败 使用长度不符合规范的用户名
//		webtest.click("link=邮箱注册");
//		webtest.type("name=username", "272904051@qq.com");
//		webtest.type("name=nickname", "h");
//		webtest.type("name=password", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
//	
//	@Test
//	public void testRegisterByEmailFail7() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		webtest.click("link=注册");
//		//邮箱注册 失败 密码为纯数字
//		webtest.click("link=邮箱注册");
//		webtest.type("name=username", "272904051@qq.com");
//		webtest.type("name=nickname", "hello1");
//		webtest.type("name=password", "123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
//	
//	@Test
//	public void testRegisterByEmailFail8() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		webtest.click("link=注册");
//		//邮箱注册 失败 使用空的用户名
//		webtest.click("link=邮箱注册");
//		webtest.type("name=username", "272904051@qq.com");
//		webtest.type("name=password", "123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
//	
//	@Test
//	public void testRegisterByPhoneSuccess() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		webtest.click("link=注册");
//		//手机号注册 成功
//		webtest.click("link=手机注册");
//		webtest.type("id=mobile", "18731179963");
//		webtest.type("id=nickname", "user5");
//		webtest.type("id=inputPassword", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
//	
//	@Test
//	public void testRegisterByPhoneFail1() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		webtest.click("link=注册");
//		//手机号注册 失败 手机号长度错误
//		webtest.click("link=手机注册");
//		webtest.type("id=mobile", "187311799631");
//		webtest.type("id=nickname", "user6");
//		webtest.type("id=inputPassword", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
//	
//	@Test
//	public void testRegisterByPhoneFail2() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		webtest.click("link=注册");
//		//手机号注册 失败 使用已注册过的手机号
//		webtest.click("link=手机注册");
//		webtest.type("id=mobile", "18330919107");
//		webtest.type("id=nickname", "user7");
//		webtest.type("id=inputPassword", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
//
//	@Test
//	public void testRegisterByPhoneFail3() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		webtest.click("link=注册");
//		//手机号注册 失败 输入空的手机号
//		webtest.click("link=手机注册");
//		webtest.type("id=nickname", "user8");
//		webtest.type("id=inputPassword", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
//	
//	@Test
//	public void testRegisterByPhoneFail4() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		webtest.click("link=注册");
//		//手机号注册 失败 手机号格式错误
//		webtest.click("link=手机注册");
//		webtest.type("id=mobile", "18330919107@163.com");
//		webtest.type("id=nickname", "user9");
//		webtest.type("id=inputPassword", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
//	
//	@Test
//	public void testRegisterByPhoneFail5() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		webtest.click("link=注册");
//		//手机号注册 失败 使用已注册用户名注册
//		webtest.click("link=手机注册");
//		webtest.type("id=mobile", "13785984807");
//		webtest.type("id=nickname", "jiaweiwen");
//		webtest.type("id=inputPassword", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
//	
//	@Test
//	public void testRegisterByPhoneFail6() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		webtest.click("link=注册");
//		//手机号注册 失败 用户名不符合规范
//		webtest.click("link=手机注册");
//		webtest.type("id=mobile", "13785984807");
//		webtest.type("id=nickname", "￥￥￥￥￥￥￥");
//		webtest.type("id=inputPassword", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
//	
//	@Test
//	public void testRegisterByPhoneFail7() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		webtest.click("link=注册");
//		//手机号注册 失败 用户名长度不符合规范
//		webtest.click("link=手机注册");
//		webtest.type("id=mobile", "13785984807");
//		webtest.type("id=nickname", "h");
//		webtest.type("id=inputPassword", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
//	
//	@Test
//	public void testRegisterByPhoneFail8() throws InterruptedException {
//		//打开页面
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//文本框输入
//		webtest.click("link=注册");
//		//手机号注册 失败 密码为纯数字
//		webtest.click("link=手机注册");
//		webtest.type("id=mobile", "13785984807");
//		webtest.type("id=nickname", "user10");
//		webtest.type("id=inputPassword", "123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
}



