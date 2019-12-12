package jiaweiwen;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;

import com.webtest.utils.ReadProperties;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

@Listeners(WebTestListener.class)
public class operation_tools extends BaseTest{
	
	public void login_before() throws InterruptedException, IOException{
		String opensns_url =ReadProperties.getPropertyValue("base_url");
		//打开页面
		webtest.open(opensns_url);
		//登录成功
		webtest.click("link=登录");
		webtest.type("name=username", "z1");
		webtest.type("name=password", "123456");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(2000);
		//签到
		webtest.click("link=微博");
	}
	
	@Test(description="签到")
	public void operation_toolsSuccess() throws InterruptedException, IOException {
		login_before();
		webtest.click("xpath=//i[@class='c-icon c-icon-checking']");
		webtest.click("签到");
		webtest.click("link=X");
		assertTrue(webtest.isTextPresent("累签"));
	}
	
	@Test
	public void operation_toolsSuccess2() throws InterruptedException, IOException {
		//排行榜
		login_before();
		webtest.click("xpath=//i[@class='c-icon c-icon-rank']");
		webtest.click("xpath=/html/body/div[5]/div/div[2]/div[1]/div[4]/div[2]/p[1]/span[2]/a[2]");
		assertTrue(webtest.isTextPresent("资料"));
	}
	
	@Test
	public void operation_toolsSuccess3() throws InterruptedException, IOException {
		//用户名片点关注
		login_before();
		webtest.click("xpath=//button[@class='btn btn-primary']");
		//取消关注
		webtest.click("xpath=//button[@class='btn btn-primary']");
		assertTrue(webtest.isTextPresent("关注"));
	}
	
	
	@Test
	public void operation_toolsSuccess5() throws InterruptedException, IOException {
		//微博页面进入名片
		login_before();
		webtest.click("link=微博");
		webtest.click("link=root");
		assertTrue(webtest.isTextPresent("资料"));
	}
	
	@Test
	public void operation_toolsSuccess6() throws InterruptedException, IOException {
		//微博页面查看24小时热门
		login_before();
		webtest.click("link=微博");
		webtest.click("link=查看更多");
		webtest.click("link=24小时热门");
		assertTrue(webtest.isTextPresent("24小时热门"));
	}
	
	@Test
	public void operation_toolsSuccess7() throws InterruptedException, IOException {
		//微博页面查看7天热门
		login_before();
		webtest.click("link=微博");
		webtest.click("link=查看更多");
		webtest.click("link=7天热门");
		assertTrue(webtest.isTextPresent("7天热门"));
	}
	
	@Test
	public void operation_toolsSuccess8() throws InterruptedException, IOException {
		//微博页面全站搜索
		login_before();
		webtest.click("xpath=//i[@class='iconfont icon-zxc']");
		webtest.click("xpath=//input[@placeholder='全站搜索']");
		webtest.type("class=input", "hello");
		Thread.sleep(1000);
		webtest.click("xpath=//i[@class='icon icon-search pull-right']");
		assertTrue(webtest.isTextPresent("发现"));
	}
	
	@Test
	public void operation_toolsSuccess9() throws InterruptedException, IOException {
		//微博页面一键返回顶部
		login_before();
	    webtest.toBottom();
		webtest.click("xpath=//*[@id='go-top']");
		assertTrue(webtest.isTextPresent("微博"));
	}
	
	@Test
	public void operation_toolsSuccess11() throws InterruptedException, IOException {
		//查看公告
		login_before();
		webtest.click("xpath=//i[@class='iconfont icon-duihua']");
		assertTrue(webtest.isTextPresent("通知"));
	}

	
}









