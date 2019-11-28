package xiangmu;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;


@Listeners(com.webtest.core.ApiListener.class)
public class Demo1 extends BaseTest{
	
	
	
//  测试用例1
	@Test(description="搜帖子")
	public void FindInvitationByName1() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.type("xpath=//input[@placeholder='搜帖子']","李子冉1");	
		webtest.tapClickEnter();//回车键
		assertTrue(webtest.isTextPresent("李子冉1"));
		//assertTrue(webtest.isTextPresent("积分"));	
	}
	
//	测试用例2（此用例还不能只想完成）
//	@Test(description="发帖子")
//	public void ReportInvitation() throws Exception  {	
//		
//		webtest.click("link=论坛");
//		webtest.click("link=发新帖");
//		webtest.type("name=title","李子冉5");	
//		//webtest.click("xpath=//*[@id=\"edui1_iframeholder\"]");
//		getDriver().switchTo().frame("edui1_iframeholder");//进文本框
//		webtest.type("xpath=//*[@id=\"edui1_iframeholder\"]", "真开心");
//		getDriver().switchTo().defaultContent();//出文本框
//		webtest.click("id=submit-content");
//		
//		//assertTrue(webtest.isTextPresent("李子冉1"));
//			
//	}

//	测试用例3	
	@Test(description="找到全部版块下面的默认版块")
	public void FindAllsections1() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("link=全部版块");
		webtest.click("xpath=//*[@id=\"main-container\"]/div/div[2]/div/a/div[2]");	
		
		assertTrue(webtest.isTextPresent("帖子列表"));
	
	}
	
//	测试用例4
	@Test(description="找到全部版块下面的官方公告")
	public void FindAllsections2() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("link=全部版块");
		webtest.click("xpath=//*[@id=\"main-container\"]/div/div[3]/div/a/div[2]/p[1]");	
		
		assertTrue(webtest.isTextPresent("帖子列表"));
	
	}

	
//	测试用例5
	@Test(description="点击随便看看并浏览列表第一个帖子")
	public void LookAroundInvitation1() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("link=随便看看");
		webtest.click("link=李子冉4");	
		
		assertTrue(webtest.isTextPresent("李子冉4"));
	
	}
	
//	测试用例6	
	@Test(description="点击随便看并点击换一换")
	public void LookAroundInvitation2() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("link=随便看看");
		webtest.click("class=icon-refresh");	
		
		//assertTrue(webtest.isTextPresent("李子冉4"));
	
	}

//	测试用例7	
//	@Test(description="点击随便看并点击换一换")
//	public void LookAroundInvitation3() throws Exception  {	
//		
//		webtest.click("link=论坛");
//		webtest.click("link=随便看看");
//		webtest.click("class=icon-refresh");	
//		
//		//assertTrue(webtest.isTextPresent("李子冉4"));
//	
//	}
	
	
//	测试用例8		
	@Test(description="点击发布查看自己发过的所有帖子")
	public void FindPublishInvitation() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id=\"body-container\"]/div[2]/div[2]/div[2]/a[1]");	
		assertTrue(webtest.isTextPresent("root的帖子"));
	
	}
	
//	测试用例9		
	@Test(description="点击发布查看自己所有的回复")
	public void FindAllReply() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id=\"body-container\"]/div[2]/div[2]/div[2]/a[2]");	
		assertTrue(webtest.isTextPresent("root的回复"));
	
	}
	
//	测试用例10		
	@Test(description="点击查看新会员并进行关注")
	public void FindMember() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id=\"body-container\"]/div[1]/div[2]/span[5]/a");
		webtest.click("xpath=//*[@id=\"main-container\"]/div/div/div/div[1]/div/div/div[2]/button[1]");
		
		assertTrue(webtest.isTextPresent("已关注"));
	
	}
	
}
