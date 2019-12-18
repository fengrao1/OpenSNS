package com.opensns.frontstage;

import java.io.IOException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.utils.ReadProperties;
/**
 * @author 贾伟雯
 * 用户中心
 */
@Listeners(WebTestListener.class)
public class Usercenter extends BaseTest{
	@Test(description="查看未读消息")
	public void testusercenterSuccess() throws InterruptedException, IOException {
		String opensns_url =ReadProperties.getPropertyValue("base_url");
		//打开页面
		webtest.open(opensns_url);
		//文本框输入
		//登录成功
		webtest.click("link=登录");
		webtest.type("name=username", "139748643@qq.com");
		webtest.type("name=password", "123456");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(4000);
		webtest.click("xpath=//i[@class='iconfont icon-caidan']");
		webtest.click("link=消息中心");
		webtest.click("link=未读消息");
//		assertTrue(webtest.isTextPresent("退出"));
	}
	
	@Test(description="查看全部消息")
	public void testusercenterSuccess2() throws InterruptedException {
		webtest.click("link=全部消息");
//		assertTrue(webtest.isTextPresent("退出"));
	}

	@Test(description="查看系统消息")
	public void testusercenterSuccess3() throws InterruptedException {
		webtest.click("link=系统消息");
//		assertTrue(webtest.isTextPresent("退出"));
	}
	
	@Test(description="查看用户消息")
	public void testusercenterSuccess4() throws InterruptedException {
		webtest.click("link=用户消息");
//		assertTrue(webtest.isTextPresent("退出"));
	}
	
	@Test(description="查看应用消息")
	public void testusercenterSuccess5() throws InterruptedException {
		webtest.click("link=应用消息");
//		assertTrue(webtest.isTextPresent("退出"));
	}
	
	@Test(description="查看论坛帖子收藏")
	public void testusercenterSuccess6() throws InterruptedException {
		webtest.click("link=我的收藏");
		webtest.click("link=论坛帖子收藏");
//		assertTrue(webtest.isTextPresent("退出"));
	}
	
	@Test(description="群组帖子收藏")
	public void testusercenterSuccess7() throws InterruptedException {
		webtest.click("link=我的收藏");
		webtest.click("link=群组帖子收藏");
//		assertTrue(webtest.isTextPresent("退出"));
	}
	
	@Test(description="生成邀请码")
	public void testusercenterSuccess8() throws InterruptedException {
		webtest.click("link=邀请好友");
		webtest.click("link=生成邀请码");
		webtest.click("data-role=create_invite");
//		assertTrue(webtest.isTextPresent("退出"));
	}
	
	@Test(description="邀请码列表")
	public void testusercenterSuccess9() throws InterruptedException {
		webtest.click("link=邀请码列表");
		webtest.click("id=zclip-ZeroClipboardMovie_1");
//		assertTrue(webtest.isTextPresent("退出"));
	}

}
