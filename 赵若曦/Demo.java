package opensns;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

import static org.testng.Assert.assertTrue;
public class Demo extends BaseTest {
	SoftAssert soft =new SoftAssert();
	
	@DataProvider(name="comment")
	public static Object[][] words1() throws Exception{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("E:\\sanshang\\train2\\comment.xlsx", "Sheet1");
	}
	
	@DataProvider(name="topic")
	public static Object[][] words2() throws Exception{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("E:\\sanshang\\train2\\topic.xlsx", "Sheet1");
	}
	
	@DataProvider(name="sign")
	public static Object[][] words3() throws Exception{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("E:\\sanshang\\train2\\sign.xlsx", "Sheet1");
	}
	
	@DataProvider(name="search")
	public static Object[][] words4() throws Exception{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("E:\\sanshang\\train2\\search.xlsx", "Sheet1");
	}
	

	


	//评论某一条微博   10条
	@Test(dataProvider="comment",description="评论")
	public void Comment(String view) throws Exception{
		webtest.click("link=微博");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/div[4]/div/div/div[1]/div[7]/div[1]/div[1]/div/div[1]/div[2]/div[2]/a");

//		webtest.click("xpath=//*[@id=\"weibo_36\"]/div[1]/div/div[1]/div[2]/div[2]/a");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@placeholder='评论（Ctrl+Enter）']",view);
		Thread.sleep(3000);
		webtest.click("class=os-icon-paper-plane");		
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("评论成功") || webtest.isTextPresent("长度必须在1到500之间"));
	//	assertTrue(webtest.isTextPresent("长度必须在1到500之间"));
	}
	
	
//	@Test(description="签到")
//	public void Register() throws Exception{
//		webtest.click("link=微博");
//		Thread.sleep(2000);
//		webtest.click("class=c-icon c-icon-checking");
//		webtest.click("link=签到");
//		Thread.sleep(2000);
//		webtest.click("class=btn-sign show-check");
//		assertTrue(webtest.isTextPresent("已签到"));
//	}
	

	//针对某一话题发表内容   10条
	@Test(dataProvider="topic",description="发布话题")
	public void PublishTopic(String topic) throws Exception{
		webtest.click("link=微博");
		webtest.click("class=topic-head");
		Thread.sleep(2000);
		webtest.click("link=测试");
		webtest.click("xpath=//*[@class=\"topic-content\"]/ul/li[1]/a/div[2]");
		Thread.sleep(2000);
		webtest.click("link=发动态");
		webtest.type("xpath=//textarea[@placeholder='写点什么吧～～']",topic);
		webtest.click("xpath=//input[@value='发布 Ctrl+Enter']");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("发布成功"));
	}	

	
	//修改个性签名   10条
	@Test(dataProvider="sign",description="修改个性签名")
	public void ChangeSignature(String sign) throws Exception{
		webtest.click("link=微博");
		webtest.click("xpath=//*[@class=\"dropdown li-hover self-info\"]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class=\"link-wrap\"]/div[2]/a/div");
		Thread.sleep(3000);
		webtest.typeAndClear("xpath=//textarea[@id='signature']",sign);	
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("设置成功") || webtest.isTextPresent("签名不能超过") )  ;
	}
	
	//微博搜索             8条
	@Test(dataProvider="search",description="微博搜索")
	public void Search(String para) throws Exception{
		webtest.click("link=微博");
		webtest.click("xpath=//*[@class=\"animate-wrap\"]/i");
		webtest.typeAndClear("xpath=//input[@id='search-text']",para);
		Thread.sleep(1000);
		webtest.enterClick();
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("没有相关内容") || webtest.isTextPresent("我的动态"));
	}
	
}




















