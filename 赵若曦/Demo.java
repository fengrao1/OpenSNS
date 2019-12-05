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
	

	


	//����ĳһ��΢��   10��
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
	
	
//	@Test(description="ǩ��")
//	public void Register() throws Exception{
//		webtest.click("link=΢��");
//		Thread.sleep(2000);
//		webtest.click("class=c-icon c-icon-checking");
//		webtest.click("link=ǩ��");
//		Thread.sleep(2000);
//		webtest.click("class=btn-sign show-check");
//		assertTrue(webtest.isTextPresent("��ǩ��"));
//	}
	

	//���ĳһ���ⷢ������   10��
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

	
	//�޸ĸ���ǩ��   10��
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
	
	//΢������             8��
	@Test(dataProvider="search",description="΢������")
	public void Search(String para) throws Exception{
		webtest.click("link=΢��");
		webtest.click("xpath=//*[@class=\"animate-wrap\"]/i");
		webtest.typeAndClear("xpath=//input[@id='search-text']",para);
		Thread.sleep(1000);
		webtest.enterClick();
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("û���������") || webtest.isTextPresent("�ҵĶ�̬"));
	}
	
}




















