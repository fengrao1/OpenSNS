package liziran;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

import okhttp3.FormBody;


@Listeners(WebTestListener.class)
public class Demo1 extends BaseTest{
	@BeforeClass
	public void login() throws Exception  {	
		webtest.open(ReadProperties.getPropertyValue("Front_url"));
		Thread.sleep(1000);
		webtest.click("link=登录");
		webtest.type("name=username","feng");  
		webtest.type("name=password","123456");
		webtest.click("class=login-btn");
		Thread.sleep(3000);
	}
	@DataProvider(name="con1")
	public Object[][] words1() throws Exception{
		ExcelDataProvider d = new ExcelDataProvider();
		return d.getTestDataByExcel("data/liziran/TestData1.xlsx","Sheet1");
	}

//共28个	
	
	
//	数据驱动
//	测试用例1-1（12个）
	
	@Test(description="搜索框",dataProvider="con1")
	public void test5(String param1,String param2) throws Exception  {	
		webtest.click("link=论坛");
		webtest.type("xpath=//input[@placeholder='搜帖子']",param1);	
		webtest.tapClickEnter();
		Thread.sleep(1000);		
		assertTrue(webtest.isTextPresent(param2));			
	}
	
//  测试用例1-21	
	@Test(description="点击收藏帖子")
	public void FindInvitationByName2() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id=\"contents\"]/li[1]/a/div[2]/h3");
		webtest.click("class=iconfont icon-shoucang");
		
		//assertTrue(webtest.isTextPresent("李子冉1"));	
	}
	
	

//  测试用例1-1
	@Test(description="搜帖子")
	public void FindInvitationByName1() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.type("xpath=//input[@placeholder='搜帖子']","李子冉1");	
		webtest.tapClickEnter();//回车键
		assertTrue(webtest.isTextPresent("李子冉1"));	
	}

//	测试用例1-3	
	@Test(description="找到全部版块下面的默认版块")
	public void FindAllsections1() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("link=全部版块");
		webtest.click("xpath=//*[@id=\"main-container\"]/div/div[2]/div/a/div[2]");	
		
		assertTrue(webtest.isTextPresent("帖子列表"));
	
	}
	
//	测试用例1-4
	@Test(description="找到全部版块下面的官方公告")
	public void FindAllsections2() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("link=全部版块");
		webtest.click("xpath=//*[@id=\"main-container\"]/div/div[3]/div/a/div[2]/p[1]");	
		
		assertTrue(webtest.isTextPresent("帖子列表"));
	
	}

	
//	测试用例1-5
	@Test(description="点击随便看看并浏览列表第一个帖子")
	public void LookAroundInvitation1() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("link=随便看看");
		webtest.click("link=李子冉4");	
		
		assertTrue(webtest.isTextPresent("李子冉4"));
	
	}
	
//	测试用例1-6	
	@Test(description="点击随便看并点击换一换")
	public void LookAroundInvitation2() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("link=随便看看");
		webtest.click("class=icon-refresh");	
		
		//assertTrue(webtest.isTextPresent("李子冉4"));
	
	}

//	测试用例1-7	
	@Test(description="点击随便看并点击换一换")
	public void LookAroundInvitation3() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("link=随便看看");
		webtest.click("class=icon-refresh");	
		
		//assertTrue(webtest.isTextPresent("李子冉4"));
	
	}
	
	
//	测试用例1-8		
	@Test(description="点击发布查看自己发过的所有帖子")
	public void FindPublishInvitation() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id=\"body-container\"]/div[2]/div[2]/div[2]/a[1]");	
		assertTrue(webtest.isTextPresent("root的帖子"));
	
	}
	
//	测试用例1-9		
	@Test(description="点击发布查看自己所有的回复")
	public void FindAllReply() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id=\"body-container\"]/div[2]/div[2]/div[2]/a[2]");	
		assertTrue(webtest.isTextPresent("的回复"));
	
	}
	
//	测试用例1-10		
	@Test(description="点击查看新会员并进行关注")
	public void FindMember() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id=\"body-container\"]/div[1]/div[2]/span[5]/a");
		webtest.click("xpath=//*[@id=\"main-container\"]/div/div/div/div[1]/div/div/div[2]/button[1]");
		
		assertTrue(webtest.isTextPresent("已关注"));
	
	}
	
	
//  测试用例1-11
	@Test(description="回复")
	public void Reversion() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id=\"contents\"]/li[1]/a/div[2]/object/a/span[4]");
		webtest.click("link=说一句");
		webtest.type("xpath=//*[@id=\"text_5\"]","写的真好，哈哈");
		webtest.click("xpath=//*[@id=\"btn_5\"]/i");
		assertTrue(webtest.isTextPresent("写的真好，哈哈"));	
	}	
	
	
//  测试用例1-12和1-13
	@Test(description="对自己喜欢的帖子进行点赞,通过点心形")
	public void GivePoints() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id=\"contents\"]/li[1]/a/div[2]/object/a/span[4]");
		webtest.click("xpath=//*[@id=\"weibo_5\"]/div[1]/div/div[2]/div/div[2]/div[1]/a/i");
		assertTrue(webtest.isTextPresent("感谢您的支持。"));	
	}
	@Test(description="取消点赞")
	public void CancelPoints() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id=\"contents\"]/li[1]/a/div[2]/object/a/span[4]");
		webtest.click("xpath=//*[@id=\"weibo_5\"]/div[1]/div/div[2]/div/div[2]/div[1]/a/i");
		assertTrue(webtest.isTextPresent("您取消了赞。"));	
	}
	
//  测试用例1-14
	@Test(description="查看粉丝数量 ")
	public void FindFans() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("class=actWrap");
		webtest.click("link=TA的关注/粉丝");
		assertTrue(webtest.isTextPresent("TA的关注/粉丝"));	
	}
	
//  测试用例1-15
	@Test(description="查看头衔 ")
	public void FindTitle() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("class=actWrap");
		webtest.click("link=头衔");
		assertTrue(webtest.isTextPresent("已拥有头衔"));	
	}
	
//  测试用例1-16
	@Test(description="查看资料 ")
	public void FindData() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("class=actWrap");
		webtest.click("link=资料");
		assertTrue(webtest.isTextPresent("基本资料"));	
	}
	
//  测试用例1-17
	@Test(description="查看关注的话题")
	public void FindTopics() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("class=actWrap");
		webtest.click("link=关注的话题");
		assertTrue(webtest.isTextPresent("话题列表"));	
	}
	
//  测试用例1-18
	@Test(description="依次点击论坛首页全部板块，随便看看")
	public void FindTopics1() throws Exception  {	
		webtest.click("link=论坛");
		webtest.click("link=全部板块");
		webtest.click("link=随便看看");
		assertTrue(webtest.isTextPresent("首页"));	
	}
	
//  测试用例1-19
	@Test(description="帖子的站内回复")
	public void StationSharing() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id=\"contents\"]/li[2]/a/div[2]/h3");
		Thread.sleep(2000);
		webtest.click("link=站内分享");
		Thread.sleep(2000);
		webtest.type("xpath=//*[@id=\"share_content\"]","hah ");
		Thread.sleep(2000);
		webtest.click("xpath=//input[@value='发表 Ctrl+Enter']");
		assertTrue(webtest.isTextPresent("分享成功"));	
	}
	
//  测试用例1-20
	@Test(description="删除回复")
	public void DeletePosts() throws Exception  {	
		
		webtest.click("link=论坛");
		//webtest.click("link=李子冉3");
		webtest.click("xpath=//*[@id=\"contents\"]/li[1]/a/div[2]/h3");
		Thread.sleep(2000);
		webtest.click("link=删除");
		Thread.sleep(2000);
		webtest.alertAccept();	
	}
	
//  测试用例1-21
	@Test(description="按发表时间排序")
	public void Sort1() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("link=默认版块");
		webtest.click("xpath=//button[contains(text(),'回复时间')]");
		Thread.sleep(2000);
		webtest.click("link=发表时间");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("发表时间"));
	}
	
//  测试用例1-22
	@Test(description="按回复时间排序")
	public void Sort2() throws Exception  {	
		
		webtest.click("link=论坛");
		webtest.click("link=默认版块");
		webtest.click("xpath=//button[contains(text(),'回复时间')]");
		Thread.sleep(2000);
		webtest.click("link=回复时间");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("回复时间"));
	}
	
//  测试用例1-23	
	@Test(description="点击收藏帖子")
	public void Collection() throws Exception  {	
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id=\"contents\"]/li[1]/a/div[2]/h3");
		webtest.click("class=iconfont icon-shoucang");
	}

	@Test(description="个人主页内点击评论框不再显示评论")
	public void zClick1() throws Exception  {	
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id='contents']/li[1]/a/div[2]/object/a/span[1]");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@id='weibo_64']/div[1]/div/div[2]/div/div[2]/div[2]/i");
	}
	@Test(description="个人主页内再次点击评论框显示评论")
	public void zClick2() throws Exception  {	
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id='contents']/li[1]/a/div[2]/object/a/span[1]");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@id='weibo_64']/div[1]/div/div[2]/div/div[2]/div[2]/i");
		webtest.click("xpath=//*[@id='weibo_64']/div[1]/div/div[2]/div/div[2]/div[2]/i");
		assertTrue(webtest.isTextPresent("111"));	
	}
	@Test(description="个人主页内点击转发")
	public void ztest3() throws Exception  {	
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id='contents']/li[1]/a/div[2]/object/a/span[1]");
		webtest.click("xpath=//*[@id='weibo_64']/div[1]/div/div[2]/div/div[2]/div[3]/a/i");
		assertTrue(webtest.isTextPresent("同时作为评论发布"));	
		Thread.sleep(2000);
		webtest.click("xpath//*[@id='frm-post-popup']/div/button");
	}
	@Test(description="点赞回复")
	public void zClick4() throws Exception  {	
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id='contents']/li[1]/a/div[2]/object/a/span[1]");
		Thread.sleep(2000);
		webtest.mouseoverElement("xpath=//*[@id='comment_13']/div/div[2]");
		webtest.click("赞");
		assertTrue(webtest.isTextPresent("感谢您的支持")||webtest.isTextPresent("您取消了点赞"));	
	}
	@Test(description="个人主页内点击分享")
	public void zClick3() throws Exception  {	
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id='contents']/li[1]/a/div[2]/object/a/span[1]");
		webtest.click("class=share-btn");
		assertTrue(webtest.isTextPresent("QQ空间"));	
	}
//	测试用例2-1	
	@Test(description="点击分享到微信")
	public void ztest1() throws Exception  {
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id=\"contents\"]/li[3]/a/div[2]/h3");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='分享到微信']");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("分享到微信朋友圈"));		
	}
	
//	测试用例2-2
	@Test(description="点击分享到复制网址")
	public void ztest2() throws Exception  {	
		webtest.click("link=论坛");
		webtest.click("xpath=//*[@id=\"contents\"]/li[3]/a/div[2]/h3");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='分享到复制网址']");
		Thread.sleep(2000);
		String content = webtest.getAlertTest();
		assertTrue(content.contains("您使用的"));	
		webtest.alertAccept();
	}
	
}
