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
		webtest.click("link=��¼");
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

//��28��	
	
	
//	��������
//	��������1-1��12����
	
	@Test(description="������",dataProvider="con1")
	public void test5(String param1,String param2) throws Exception  {	
		webtest.click("link=��̳");
		webtest.type("xpath=//input[@placeholder='������']",param1);	
		webtest.tapClickEnter();
		Thread.sleep(1000);		
		assertTrue(webtest.isTextPresent(param2));			
	}
	
//  ��������1-21	
	@Test(description="����ղ�����")
	public void FindInvitationByName2() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id=\"contents\"]/li[1]/a/div[2]/h3");
		webtest.click("class=iconfont icon-shoucang");
		
		//assertTrue(webtest.isTextPresent("����Ƚ1"));	
	}
	
	

//  ��������1-1
	@Test(description="������")
	public void FindInvitationByName1() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.type("xpath=//input[@placeholder='������']","����Ƚ1");	
		webtest.tapClickEnter();//�س���
		assertTrue(webtest.isTextPresent("����Ƚ1"));	
	}

//	��������1-3	
	@Test(description="�ҵ�ȫ����������Ĭ�ϰ��")
	public void FindAllsections1() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("link=ȫ�����");
		webtest.click("xpath=//*[@id=\"main-container\"]/div/div[2]/div/a/div[2]");	
		
		assertTrue(webtest.isTextPresent("�����б�"));
	
	}
	
//	��������1-4
	@Test(description="�ҵ�ȫ���������Ĺٷ�����")
	public void FindAllsections2() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("link=ȫ�����");
		webtest.click("xpath=//*[@id=\"main-container\"]/div/div[3]/div/a/div[2]/p[1]");	
		
		assertTrue(webtest.isTextPresent("�����б�"));
	
	}

	
//	��������1-5
	@Test(description="�����㿴��������б��һ������")
	public void LookAroundInvitation1() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("link=��㿴��");
		webtest.click("link=����Ƚ4");	
		
		assertTrue(webtest.isTextPresent("����Ƚ4"));
	
	}
	
//	��������1-6	
	@Test(description="�����㿴�������һ��")
	public void LookAroundInvitation2() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("link=��㿴��");
		webtest.click("class=icon-refresh");	
		
		//assertTrue(webtest.isTextPresent("����Ƚ4"));
	
	}

//	��������1-7	
	@Test(description="�����㿴�������һ��")
	public void LookAroundInvitation3() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("link=��㿴��");
		webtest.click("class=icon-refresh");	
		
		//assertTrue(webtest.isTextPresent("����Ƚ4"));
	
	}
	
	
//	��������1-8		
	@Test(description="��������鿴�Լ���������������")
	public void FindPublishInvitation() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id=\"body-container\"]/div[2]/div[2]/div[2]/a[1]");	
		assertTrue(webtest.isTextPresent("root������"));
	
	}
	
//	��������1-9		
	@Test(description="��������鿴�Լ����еĻظ�")
	public void FindAllReply() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id=\"body-container\"]/div[2]/div[2]/div[2]/a[2]");	
		assertTrue(webtest.isTextPresent("�Ļظ�"));
	
	}
	
//	��������1-10		
	@Test(description="����鿴�»�Ա�����й�ע")
	public void FindMember() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id=\"body-container\"]/div[1]/div[2]/span[5]/a");
		webtest.click("xpath=//*[@id=\"main-container\"]/div/div/div/div[1]/div/div/div[2]/button[1]");
		
		assertTrue(webtest.isTextPresent("�ѹ�ע"));
	
	}
	
	
//  ��������1-11
	@Test(description="�ظ�")
	public void Reversion() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id=\"contents\"]/li[1]/a/div[2]/object/a/span[4]");
		webtest.click("link=˵һ��");
		webtest.type("xpath=//*[@id=\"text_5\"]","д����ã�����");
		webtest.click("xpath=//*[@id=\"btn_5\"]/i");
		assertTrue(webtest.isTextPresent("д����ã�����"));	
	}	
	
	
//  ��������1-12��1-13
	@Test(description="���Լ�ϲ�������ӽ��е���,ͨ��������")
	public void GivePoints() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id=\"contents\"]/li[1]/a/div[2]/object/a/span[4]");
		webtest.click("xpath=//*[@id=\"weibo_5\"]/div[1]/div/div[2]/div/div[2]/div[1]/a/i");
		assertTrue(webtest.isTextPresent("��л����֧�֡�"));	
	}
	@Test(description="ȡ������")
	public void CancelPoints() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id=\"contents\"]/li[1]/a/div[2]/object/a/span[4]");
		webtest.click("xpath=//*[@id=\"weibo_5\"]/div[1]/div/div[2]/div/div[2]/div[1]/a/i");
		assertTrue(webtest.isTextPresent("��ȡ�����ޡ�"));	
	}
	
//  ��������1-14
	@Test(description="�鿴��˿���� ")
	public void FindFans() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("class=actWrap");
		webtest.click("link=TA�Ĺ�ע/��˿");
		assertTrue(webtest.isTextPresent("TA�Ĺ�ע/��˿"));	
	}
	
//  ��������1-15
	@Test(description="�鿴ͷ�� ")
	public void FindTitle() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("class=actWrap");
		webtest.click("link=ͷ��");
		assertTrue(webtest.isTextPresent("��ӵ��ͷ��"));	
	}
	
//  ��������1-16
	@Test(description="�鿴���� ")
	public void FindData() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("class=actWrap");
		webtest.click("link=����");
		assertTrue(webtest.isTextPresent("��������"));	
	}
	
//  ��������1-17
	@Test(description="�鿴��ע�Ļ���")
	public void FindTopics() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("class=actWrap");
		webtest.click("link=��ע�Ļ���");
		assertTrue(webtest.isTextPresent("�����б�"));	
	}
	
//  ��������1-18
	@Test(description="���ε����̳��ҳȫ����飬��㿴��")
	public void FindTopics1() throws Exception  {	
		webtest.click("link=��̳");
		webtest.click("link=ȫ�����");
		webtest.click("link=��㿴��");
		assertTrue(webtest.isTextPresent("��ҳ"));	
	}
	
//  ��������1-19
	@Test(description="���ӵ�վ�ڻظ�")
	public void StationSharing() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id=\"contents\"]/li[2]/a/div[2]/h3");
		Thread.sleep(2000);
		webtest.click("link=վ�ڷ���");
		Thread.sleep(2000);
		webtest.type("xpath=//*[@id=\"share_content\"]","hah ");
		Thread.sleep(2000);
		webtest.click("xpath=//input[@value='���� Ctrl+Enter']");
		assertTrue(webtest.isTextPresent("����ɹ�"));	
	}
	
//  ��������1-20
	@Test(description="ɾ���ظ�")
	public void DeletePosts() throws Exception  {	
		
		webtest.click("link=��̳");
		//webtest.click("link=����Ƚ3");
		webtest.click("xpath=//*[@id=\"contents\"]/li[1]/a/div[2]/h3");
		Thread.sleep(2000);
		webtest.click("link=ɾ��");
		Thread.sleep(2000);
		webtest.alertAccept();	
	}
	
//  ��������1-21
	@Test(description="������ʱ������")
	public void Sort1() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("link=Ĭ�ϰ��");
		webtest.click("xpath=//button[contains(text(),'�ظ�ʱ��')]");
		Thread.sleep(2000);
		webtest.click("link=����ʱ��");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("����ʱ��"));
	}
	
//  ��������1-22
	@Test(description="���ظ�ʱ������")
	public void Sort2() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("link=Ĭ�ϰ��");
		webtest.click("xpath=//button[contains(text(),'�ظ�ʱ��')]");
		Thread.sleep(2000);
		webtest.click("link=�ظ�ʱ��");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("�ظ�ʱ��"));
	}
	
//  ��������1-23	
	@Test(description="����ղ�����")
	public void Collection() throws Exception  {	
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id=\"contents\"]/li[1]/a/div[2]/h3");
		webtest.click("class=iconfont icon-shoucang");
	}

	@Test(description="������ҳ�ڵ�����ۿ�����ʾ����")
	public void zClick1() throws Exception  {	
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id='contents']/li[1]/a/div[2]/object/a/span[1]");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@id='weibo_64']/div[1]/div/div[2]/div/div[2]/div[2]/i");
	}
	@Test(description="������ҳ���ٴε�����ۿ���ʾ����")
	public void zClick2() throws Exception  {	
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id='contents']/li[1]/a/div[2]/object/a/span[1]");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@id='weibo_64']/div[1]/div/div[2]/div/div[2]/div[2]/i");
		webtest.click("xpath=//*[@id='weibo_64']/div[1]/div/div[2]/div/div[2]/div[2]/i");
		assertTrue(webtest.isTextPresent("111"));	
	}
	@Test(description="������ҳ�ڵ��ת��")
	public void ztest3() throws Exception  {	
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id='contents']/li[1]/a/div[2]/object/a/span[1]");
		webtest.click("xpath=//*[@id='weibo_64']/div[1]/div/div[2]/div/div[2]/div[3]/a/i");
		assertTrue(webtest.isTextPresent("ͬʱ��Ϊ���۷���"));	
		Thread.sleep(2000);
		webtest.click("xpath//*[@id='frm-post-popup']/div/button");
	}
	@Test(description="���޻ظ�")
	public void zClick4() throws Exception  {	
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id='contents']/li[1]/a/div[2]/object/a/span[1]");
		Thread.sleep(2000);
		webtest.mouseoverElement("xpath=//*[@id='comment_13']/div/div[2]");
		webtest.click("��");
		assertTrue(webtest.isTextPresent("��л����֧��")||webtest.isTextPresent("��ȡ���˵���"));	
	}
	@Test(description="������ҳ�ڵ������")
	public void zClick3() throws Exception  {	
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id='contents']/li[1]/a/div[2]/object/a/span[1]");
		webtest.click("class=share-btn");
		assertTrue(webtest.isTextPresent("QQ�ռ�"));	
	}
//	��������2-1	
	@Test(description="�������΢��")
	public void ztest1() throws Exception  {
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id=\"contents\"]/li[3]/a/div[2]/h3");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='����΢��']");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("����΢������Ȧ"));		
	}
	
//	��������2-2
	@Test(description="�������������ַ")
	public void ztest2() throws Exception  {	
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id=\"contents\"]/li[3]/a/div[2]/h3");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@title='����������ַ']");
		Thread.sleep(2000);
		String content = webtest.getAlertTest();
		assertTrue(content.contains("��ʹ�õ�"));	
		webtest.alertAccept();
	}
	
}
