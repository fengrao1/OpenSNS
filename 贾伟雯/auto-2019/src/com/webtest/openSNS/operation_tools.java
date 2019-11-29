package com.webtest.openSNS;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.jiaweiwen.ApiListener;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

@Listeners(ApiListener.class)
public class operation_tools extends BaseTest{
	
	public void login_before() throws InterruptedException{
		//打开页面
		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
		//文本框输入
		//登录成功
		webtest.click("link=登录");
		webtest.type("name=username", "18330919107@163.com");
		webtest.type("name=password", "jww18330919107");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(2000);
		//签到
		webtest.click("link=微博");
	}
	
	@Test(description="签到")
	public void operation_toolsSuccess() throws InterruptedException {
		login_before();
		webtest.click("xpath=//i[@class='c-icon c-icon-checking']");
		webtest.click("签到");
		webtest.click("link=X");
		assertTrue(webtest.isTextPresent("累签"));
	}
//	
//	@Test
//	public void operation_toolsSuccess2() throws InterruptedException {
//		//排行榜
//		login_before();
//		webtest.click("xpath=//i[@class='c-icon c-icon-rank']");
//		webtest.click("xpath=/html/body/div[5]/div/div[2]/div[1]/div[4]/div[2]/p[1]/span[2]/a[2]");
//		assertTrue(webtest.isTextPresent("资料"));
//	}
//	
//	@Test
//	public void operation_toolsSuccess3() throws InterruptedException {
//		//用户名片点关注
//		login_before();
//		webtest.click("xpath=//button[@class='btn btn-primary']");
//		//取消关注
//		webtest.click("xpath=//button[@class='btn btn-primary']");
//		assertTrue(webtest.isTextPresent("关注"));
//	}
//	
//	@Test
//	public void operation_toolsSuccess4() throws InterruptedException {
//		//用户名片点聊天
//		login_before();
//		webtest.click("xpath=/html/body/div[4]/div/div/div/div/div[1]/div/div/div[2]/button[2]");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
//	
//	@Test
//	public void operation_toolsSuccess5() throws InterruptedException {
//		//微博页面进入名片
//		login_before();
//		webtest.click("link=微博");
//		webtest.click("link=root");
//		assertTrue(webtest.isTextPresent("资料"));
//	}
//	
//	@Test
//	public void operation_toolsSuccess6() throws InterruptedException {
//		//微博页面查看24小时热门
//		login_before();
//		webtest.click("link=微博");
//		webtest.click("link=查看更多");
//		webtest.click("link=24小时热门");
//		assertTrue(webtest.isTextPresent("24小时热门"));
//	}
//	
//	@Test
//	public void operation_toolsSuccess7() throws InterruptedException {
//		//微博页面查看7天热门
//		login_before();
//		webtest.click("link=微博");
//		webtest.click("link=查看更多");
//		webtest.click("link=7天热门");
//		assertTrue(webtest.isTextPresent("7天热门"));
//	}
//	
//	@Test
//	public void operation_toolsSuccess8() throws InterruptedException {
//		//微博页面全站搜索
//		login_before();
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[1]/a/i");
//		webtest.click("xpath=//input[@placeholder='全站搜索']");
//		webtest.type("class=input", "hello");
//		webtest.click("xpayh=/html/body/div[2]/div[4]/div/div[1]/form/a/i");
//		assertTrue(webtest.isTextPresent("发现"));
//	}
//	
//	@Test
//	public void operation_toolsSuccess9() throws InterruptedException {
//		//微博页面一键返回顶部
//		login_before();
//	    webtest.toBottom();
//		webtest.click("xpath=//*[@id='go-top']");
//		assertTrue(webtest.isTextPresent("微博"));
//	}
//	
//	@Test
//	public void operation_toolsSuccess10() throws InterruptedException {
//		//聊天
//		login_before();
//		webtest.click("xpath=/html/body/div[4]/div/div/div/div/div[1]/div/div/div[2]/button[2]");
//		webtest.click("xpath=//*[@id='chat_content']");
//		webtest.type("id=chat_content", "hello");
//		webtest.click("xpath=/html/body/div[1]/div[2]/div[2]/div[4]/div[2]/button");
//		webtest.click("xpath=/html/body/div[1]/div[2]/div[2]/div[4]/div[1]/button/i");
//		webtest.click("xpath=/html/body/div[1]/div[2]/div[2]/div[1]/div[2]/a/i");
//	}
//	
//	@Test
//	public void operation_toolsSuccess11() throws InterruptedException {
//		//查看公告
//		login_before();
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[2]/a/i");
//		assertTrue(webtest.isTextPresent("通知"));
//	}
}









