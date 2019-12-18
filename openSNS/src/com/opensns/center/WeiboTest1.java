package com.opensns.center;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

import static org.testng.Assert.assertTrue;
/**
 * @author ������
 * ΢��
 */
@Listeners(WebTestListener.class)
public class WeiboTest1 extends BaseTest {
	@BeforeClass
	public void login() throws Exception  {	
		webtest.open(ReadProperties.getPropertyValue("Front_url"));
		Thread.sleep(1000);
		webtest.click("link=��¼");
		Thread.sleep(2000);
		webtest.type("name=username","139748643@qq.com");  
		webtest.type("name=password","123456");
		webtest.click("class=login-btn");
		Thread.sleep(3000);
	}
	@DataProvider(name="comment")
	public Object[][] words1() throws Exception{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("data/zhaoruoxi/comment.xlsx", "Sheet1");
	}
	
	@DataProvider(name="topic")
	public Object[][] words2() throws Exception{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("data/zhaoruoxi/topic.xlsx", "Sheet1");
	}
	
	@DataProvider(name="sign")
	public Object[][] words3() throws Exception{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("data/zhaoruoxi/sign.xlsx", "Sheet1");
	}
	
	@DataProvider(name="search")
	public Object[][] words4() throws Exception{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("data/zhaoruoxi/search.xlsx", "Sheet1");
	}
	

	/**����ĳһ��΢��   10��     **/
	@Test(dataProvider="comment",description="����")
	public void Comment(String view) throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/div[4]/div/div/div[1]/div[7]/div[1]/div[1]/div/div[1]/div[2]/div[2]/a");
//		webtest.click("xpath=//*[@id=\"weibo_36\"]/div[1]/div/div[1]/div[2]/div[2]/a");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@placeholder='���ۣ�Ctrl+Enter��']",view);
		Thread.sleep(3000);
		webtest.click("class=os-icon-paper-plane");		
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("���۳ɹ�") || webtest.isTextPresent("���ȱ�����1��500֮��"));
	//	assertTrue(webtest.isTextPresent("���ȱ�����1��500֮��"));
	}

	
	/** ���ĳһ���ⷢ������   10��   **/
	@Test(dataProvider="topic",description="��������")
	public void PublishTopic(String topic) throws Exception{
		webtest.click("link=΢��");
		webtest.click("class=topic-head");
		Thread.sleep(2000);
		webtest.click("link=����");
		webtest.click("xpath=//*[@class=\"topic-content\"]/ul/li[1]/a/div[2]");
		Thread.sleep(2000);
		webtest.click("link=����̬");
		webtest.type("xpath=//textarea[@placeholder='д��ʲô�ɡ���']",topic);
		webtest.click("xpath=//input[@value='���� Ctrl+Enter']");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("�����ɹ�"));
	}	

	
	/**    �޸ĸ���ǩ��   10��    **/
	@Test(dataProvider="sign",description="�޸ĸ���ǩ��")
	public void ChangeSignature(String sign) throws Exception{
		webtest.click("link=΢��");
		webtest.click("xpath=//*[@class=\"dropdown li-hover self-info\"]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class=\"link-wrap\"]/div[2]/a/div");
		Thread.sleep(3000);
		webtest.typeAndClear("xpath=//textarea[@id='signature']",sign);	
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("���óɹ�") || webtest.isTextPresent("ǩ�����ܳ���") )  ;
	}
	
	
	/**        ΢������             8��   **/
	@Test(dataProvider="search",description="΢������")
	public void Search(String para) throws Exception{
		webtest.click("link=΢��");
		webtest.click("xpath=//*[@class=\"animate-wrap\"]/i");
		webtest.typeAndClear("xpath=//input[@id='search-text']",para);
		Thread.sleep(1000);
		webtest.tapClickEnter();
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("û���������") || webtest.isTextPresent("�ҵĶ�̬"));
	}
	
}




















