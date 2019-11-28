package opensns;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import static org.testng.Assert.assertTrue;
public class Demo extends BaseTest {
	
	@Test(description="发布微博-文字")
	public void publish1() throws InterruptedException {
		webtest.click("link=微博");
		webtest.click("title=微博");
		Thread.sleep(2000);
		webtest.click("class=add-weibo");
		Thread.sleep(2000);
		webtest.click("class=icon-zs");
		Thread.sleep(1000);
		webtest.type("id=weibo_content","发布一条文字动态");
		webtest.click("class=send-right");
		assertTrue(webtest.isTextPresent("发布成功！"));
	}
	
	@Test(description="发布微博-表情")
	public void publish3() throws InterruptedException {
		webtest.click("link=微博");
		webtest.click("title=微博");
		Thread.sleep(2000);
		webtest.click("class=add-weibo");
		Thread.sleep(2000);
		webtest.click("class=icon-zs");
		Thread.sleep(1000);
		webtest.type("id=weibo_content","[deyi]");
		webtest.click("class=send-right");
		assertTrue(webtest.isTextPresent("发布成功！"));
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
	

	@Test(description="发布微博-话题")
	public void publish4() throws Exception {
		webtest.click("link=微博");
		webtest.click("title=微博");
		Thread.sleep(2000);
		webtest.click("class=add-weibo");
		Thread.sleep(2000);
		webtest.click("class=icon-zs");
		webtest.click("class=iconfont icon-tianjiahuati i-ht");
		Thread.sleep(1000);
//		webtest.type("id=weibo_content","测试话题");
		webtest.click("class=send-right");
		assertTrue(webtest.isTextPresent("发布成功！"));
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
		webtest.click("class=iconfont icon-cuo");
		assertTrue(webtest.isTextPresent("取消发送"));
	}
	
	@Test(description="点赞")
	public void DianZan() throws Exception{
		webtest.click("link=微博");
		Thread.sleep(2000);
		webtest.click("id=support_Weibo_weibo_13");
	}
	
	
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
	
	@Test(description="评论")
	public void Comment() throws Exception{
		webtest.click("link=微博");
		Thread.sleep(3000);
		webtest.click("data-weibo-id=14");
		webtest.type("xpath=//input[@placeholder='评论（Ctrl+Enter）']","哈哈哈");
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("评论成功"));
	}
	
	@Test(description="邀请")
	public void Invite() throws Exception{
		webtest.click("link=微博");
		Thread.sleep(2000);
		webtest.click("link=立即邀请");
		webtest.click("link=邀请码列表");
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("获得邀请码"));
	}
	
	@Test(description="生成邀请码")
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
		webtest.click("link=生成邀请码");
		assertTrue(webtest.isTextPresent("获得邀请码"));
	}
	
	@Test(description="查看排行榜")
	public void Rank() throws Exception{
		webtest.click("link=微博");
		Thread.sleep(2000);
		webtest.click("link=排行");
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("排行榜"));
	}
	
	@Test(description="签到")
	public void Register() throws Exception{
		webtest.click("link=微博");
		Thread.sleep(2000);
		webtest.click("class=c-icon c-icon-checking");
		webtest.click("link=签到");
		Thread.sleep(2000);
		webtest.click("class=btn-sign show-check");
//		assertTrue(webtest.isTextPresent("签到成功"));
	}
	
	
	
	
	
	
	
	
	
}




















