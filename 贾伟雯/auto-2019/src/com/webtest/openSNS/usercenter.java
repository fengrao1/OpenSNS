package com.webtest.openSNS;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.jiaweiwen.ApiListener;
@Listeners(ApiListener.class)
public class usercenter extends BaseTest{
	@Test(description="查看未读消息")
	public void testusercenterSuccess() throws InterruptedException {
		//打开页面
		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
		//文本框输入
		//登录成功
		webtest.click("link=登录");
		webtest.type("name=username", "18330919107@163.com");
		webtest.type("name=password", "jww18330919107");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(4000);
		webtest.click("xpath=/html/body/div[2]/div[3]/li[4]/a");
		webtest.click("xpath=/html/body/div[2]/div[3]/li[4]/ul/li[2]/a");
		webtest.click("link=未读消息");
		//assertTrue(webtest.isTextPresent("退出"));
	}
	
	@Test(description="查看全部消息")
	public void testusercenterSuccess2() throws InterruptedException {
		webtest.click("link=全部消息");
		//assertTrue(webtest.isTextPresent("退出"));
	}
	
	@Test(description="查看系统消息")
	public void testusercenterSuccess3() throws InterruptedException {
		webtest.click("link=系统消息");
		//assertTrue(webtest.isTextPresent("退出"));
	}
	
	@Test(description="查看用户消息")
	public void testusercenterSuccess4() throws InterruptedException {
		webtest.click("link=用户消息");
		//assertTrue(webtest.isTextPresent("退出"));
	}
	
	@Test(description="查看应用消息")
	public void testusercenterSuccess5() throws InterruptedException {
		webtest.click("link=应用消息");
		//assertTrue(webtest.isTextPresent("退出"));
	}
	
	@Test(description="查看论坛帖子收藏")
	public void testusercenterSuccess6() throws InterruptedException {
		webtest.click("link=我的收藏");
		webtest.click("link=论坛帖子收藏");
		//assertTrue(webtest.isTextPresent("退出"));
	}
	
	@Test(description="群组帖子收藏")
	public void testusercenterSuccess7() throws InterruptedException {
		webtest.click("link=我的收藏");
		webtest.click("link=群组帖子收藏");
		//assertTrue(webtest.isTextPresent("退出"));
	}
	
	@Test(description="生成邀请码")
	public void testusercenterSuccess8() throws InterruptedException {
		webtest.click("link=邀请好友");
		webtest.click("link=生成邀请码");
		webtest.click("data-role=create_invite");
		//assertTrue(webtest.isTextPresent("退出"));
	}
	
	@Test(description="邀请码列表")
	public void testusercenterSuccess9() throws InterruptedException {
		webtest.click("link=邀请码列表");
		webtest.click("id=zclip-ZeroClipboardMovie_1");
		//assertTrue(webtest.isTextPresent("退出"));
	}
}
