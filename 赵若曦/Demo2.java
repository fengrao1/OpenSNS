package opensns;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Demo2 extends BaseTest{
	SoftAssert soft =new SoftAssert();
	
	/**  查看个人主页  **/
	@Test(description="个人主页-微博")
	public void Homepage1() throws Exception{
		webtest.click("link=微博");
		webtest.click("xpath=//*[@class=\"dropdown li-hover self-info\"]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class=\"link-wrap\"]/div[1]/a[1]/div");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a");	
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("网站端"));
		
//		soft.assertTrue(webtest.isTextPresent("网站端"));
//		soft.assertAll();

	}
	
	@Test(description="个人主页-关注")
	public void Homepage2() throws Exception{
		webtest.click("link=微博");
		webtest.click("xpath=//*[@class=\"dropdown li-hover self-info\"]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class=\"link-wrap\"]/div[1]/a[1]/div");
		Thread.sleep(3000);
		webtest.click("link=TA的关注/粉丝");	
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("admin"));
	}
	
	@Test(description="个人主页-粉丝")
	public void Homepage3() throws Exception{
		webtest.click("link=微博");
		webtest.click("xpath=//*[@class=\"dropdown li-hover self-info\"]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class=\"link-wrap\"]/div[1]/a[1]/div");
		Thread.sleep(3000);
		webtest.click("link=TA的关注/粉丝");	
		webtest.click("xpath=//*[@class=\"col-xs-12 uc_fans\"]/ul/li[2]/a");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("admin"));
	}
	
	@Test(description="个人主页-资料")
	public void Homepage4() throws Exception{
		webtest.click("link=微博");
		webtest.click("xpath=//*[@class=\"dropdown li-hover self-info\"]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class=\"link-wrap\"]/div[1]/a[1]/div");
		Thread.sleep(3000);
		webtest.click("link=资料");	
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("基本资料"));
	}
	
	@Test(description="个人主页-头衔")
	public void Homepage5() throws Exception{
		webtest.click("link=微博");
		webtest.click("xpath=//*[@class=\"dropdown li-hover self-info\"]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class=\"link-wrap\"]/div[1]/a[1]/div");
		Thread.sleep(3000);
		webtest.click("link=头衔");	
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("暂无该类型头衔哦～ "));
	}
	
	@Test(description="个人主页-关注的话题")
	public void Homepage6() throws Exception{
		webtest.click("link=微博");
		webtest.click("xpath=//*[@class=\"dropdown li-hover self-info\"]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class=\"link-wrap\"]/div[1]/a[1]/div");
		Thread.sleep(3000);
		webtest.click("link=关注的话题");	
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("话题列表"));
	} 
	
	//通过点击表情评论话题
	@Test(description="发布话题表情")
	public void TopicEmoji() throws Exception{
		webtest.click("link=微博");
		webtest.click("class=topic-head");
		Thread.sleep(2000);	
		webtest.click("link=测试");
		webtest.click("xpath=//*[@class=\"topic-content\"]/ul/li[1]/a/div[2]");
		Thread.sleep(2000);
		webtest.click("link=发动态");
		webtest.click("xpath=//*[@class=\"col-xs-12\"]/a[1]/img");
		webtest.click("xpath=//*[@id=\"face\"]/a[1]");
		webtest.click("xpath=//input[@value='发布 Ctrl+Enter']");
		assertTrue(webtest.isTextPresent("测试"));
	}
	
	/**  发布微博动态  **/
	@Test(description="发布微博-文字")
	public void publish1() throws InterruptedException {
		webtest.click("link=微博");
		webtest.click("title=微博");
		Thread.sleep(1000);
		webtest.click("class=add-weibo");
		Thread.sleep(3000);
		webtest.click("class=icon-zs");
		Thread.sleep(2000);
		webtest.type("id=weibo_content","下雪啦");
		webtest.click("class=send-right");
		assertTrue(webtest.isTextPresent("发布成功"));
	}
	
	
	@Test(description="发布微博-空白内容")
	public void publish2() throws InterruptedException {
		webtest.click("link=微博");
		webtest.click("title=微博");
		Thread.sleep(2000);
		webtest.click("class=add-weibo");
		Thread.sleep(2000);
		webtest.click("class=icon-zs");
		Thread.sleep(1000);
		webtest.type("id=weibo_content","");
		webtest.click("class=send-right");
		assertTrue(webtest.isTextPresent("发布失败"));
	}
	
	@Test(description="发布微博-表情")
	public void publish3() throws InterruptedException {
		webtest.click("link=微博");
		webtest.click("title=微博");
		Thread.sleep(1000);
		webtest.click("class=add-weibo");
		Thread.sleep(3000);
		webtest.click("class=icon-zs");
		Thread.sleep(2000);
		webtest.type("id=weibo_content","[love] [qiang]");
		webtest.click("class=send-right");
		assertTrue(webtest.isTextPresent("发布成功"));
	}

	@Test(description="发布微博-话题")
	public void publish4() throws Exception {
		webtest.click("link=微博");
		webtest.click("title=微博");
		Thread.sleep(2000);
		webtest.click("class=add-weibo");
		Thread.sleep(2000);
		webtest.click("class=icon-zs");
		Thread.sleep(1000);
		webtest.type("id=weibo_content","#大学#");
		webtest.click("class=send-right");
		assertTrue(webtest.isTextPresent("发布成功"));
	}
	
	
	@Test(description="取消发送微博")
	public void publish5() throws InterruptedException {
		webtest.click("link=微博");
		webtest.click("title=微博");
		Thread.sleep(2000);
		webtest.click("class=add-weibo");
		Thread.sleep(2000);
		webtest.click("class=icon-zs");
		Thread.sleep(1000);
		webtest.type("id=weibo_content","abcd");
		webtest.click("class=send-wrong");
		assertTrue(webtest.isTextPresent("发动态"));
	}

	
	
	/**  微博首页主要模块  **/
	@Test(description="查看我的关注")
	public void Follow() throws Exception{
		webtest.click("link=微博");
		Thread.sleep(2000);
		webtest.click("id=concerned");
		assertTrue(webtest.isTextPresent("我的关注"));
	}
	
	@Test(description="查看全站动态")
	public void AllTrends() throws Exception{
		webtest.click("link=微博");
		Thread.sleep(2000);
		webtest.click("id=all");
		assertTrue(webtest.isTextPresent("全站动态"));
	}
	
	@Test(description="查看热门动态")
	public void HotTrends() throws Exception{
		webtest.click("link=微博");
		Thread.sleep(2000);
		webtest.click("id=hot");
		assertTrue(webtest.isTextPresent("热门动态"));
	}
	
	@Test(description="查看我的喜欢")
	public void MyLike() throws Exception{
		webtest.click("link=微博");
		Thread.sleep(2000);
		webtest.click("id=fav");
		assertTrue(webtest.isTextPresent("我的喜欢"));
	}
	
	@Test(description="点赞")
	public void DianZan() throws Exception{
		webtest.click("link=微博");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@id=\"weibo_55\"]/div[1]/div/div[2]/div/div[2]/div[1]/a");
		assertTrue(webtest.isTextPresent("1"));
	}
	

   /** 消息提醒 **/
	@Test(description="查看系统消息提醒")
	public void Remind1() throws Exception{
		webtest.click("link=微博");	
		webtest.click("xpath=//*[@class=\"col-xs-3 box c-b-right\"]/li[2]/a/i");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("用户消息"));
		assertTrue(webtest.isTextPresent("快去看看吧"));
		
	}
	
	@Test(description="查看动态消息提醒")
	public void Remind2() throws Exception{
		webtest.click("link=微博");	
		webtest.click("xpath=//*[@class=\"col-xs-3 box c-b-right\"]/li[2]/a/i");
		webtest.click("xpath=//*[@class=\"session-list\"]/li[2]/a/div/div/div[1]/img");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("admin"));
		
	}
	
	@Test(description="查看用户消息提醒")
	public void Remind3() throws Exception{
		webtest.click("link=微博");	
		webtest.click("xpath=//*[@class=\"col-xs-3 box c-b-right\"]/li[2]/a/i");
		webtest.click("xpath=//*[@class=\"session-list\"]/li[3]/a/div/div/div[1]/img");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("加载更多"));
	}
	
   /** 查看排行榜 **/  
	@Test(description="查看排行榜")
	public void Rank() throws Exception{
		webtest.click("link=微博");
		Thread.sleep(2000);
		webtest.click("link=排行");
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("排行榜"));
	}
	
	@Test(description="查看话题排行榜-24小时")
	public void Topic_24() throws Exception{
		webtest.click("link=微博");
		webtest.click("class=topic-head");
		webtest.click("link=查看更多");
		Thread.sleep(2000);
		webtest.click("link= 24小时热门");
	}
	
	@Test(description="查看话题排行榜-7天")
	public void Topic_7() throws Exception{
		webtest.click("link=微博");
		webtest.click("class=topic-head");
		webtest.click("link=查看更多");
		Thread.sleep(2000);
		webtest.click("link= 7天热门");
	}
	
	
	/** 邀请 **/
	@Test(description="邀请好友-邀请码列表")
	public void Invite1() throws Exception{
		webtest.click("link=微博");
		Thread.sleep(2000);
		webtest.click("link=立即邀请");
		webtest.click("link=邀请码列表");
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("系统默认邀请码"));
	}
	
	@Test(description="邀请好友-生成邀请码")
	public void Invite2() throws Exception{
		webtest.click("link=微博");
		Thread.sleep(2000);
		webtest.click("link=立即邀请");
		webtest.click("link=生成邀请码");
		Thread.sleep(1000);
		webtest.click("link=兑换名额");
		Thread.sleep(2000);
		webtest.click("link=兑换");
		Thread.sleep(2000);
		webtest.alertAccept();
	//	webtest.click("xpath=//*[@class=\"invite_content\"]/table/tbody/tr/td[8]/a[2]");
		webtest.click("xpath=/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div[2]/table/tbody/tr/td[8]/a[2]");	
	//	webtest.click("class=btn btn-primary");
		Thread.sleep(2000);
		webtest.click("link=生成");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("复制邀请链接"));
	}
	
	@Test(description="邀请-消息中心")
	public void Invite() throws Exception{
		webtest.click("link=微博");
		Thread.sleep(2000);
		webtest.click("link=立即邀请");
		webtest.click("link=消息中心");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("未读消息"));
	}
	
	@Test(description="邀请-我的收藏")
	public void Collection() throws Exception{
		webtest.click("link=微博");
		Thread.sleep(2000);
		webtest.click("link=立即邀请");
		webtest.click("link=我的收藏");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("论坛帖子收藏"));
	}
}
