package opensns;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Demo2 extends BaseTest{
	SoftAssert soft =new SoftAssert();
	
	/**  �鿴������ҳ  **/
	@Test(description="������ҳ-΢��")
	public void Homepage1() throws Exception{
		webtest.click("link=΢��");
		webtest.click("xpath=//*[@class=\"dropdown li-hover self-info\"]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class=\"link-wrap\"]/div[1]/a[1]/div");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a");	
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("��վ��"));
		
//		soft.assertTrue(webtest.isTextPresent("��վ��"));
//		soft.assertAll();

	}
	
	@Test(description="������ҳ-��ע")
	public void Homepage2() throws Exception{
		webtest.click("link=΢��");
		webtest.click("xpath=//*[@class=\"dropdown li-hover self-info\"]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class=\"link-wrap\"]/div[1]/a[1]/div");
		Thread.sleep(3000);
		webtest.click("link=TA�Ĺ�ע/��˿");	
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("admin"));
	}
	
	@Test(description="������ҳ-��˿")
	public void Homepage3() throws Exception{
		webtest.click("link=΢��");
		webtest.click("xpath=//*[@class=\"dropdown li-hover self-info\"]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class=\"link-wrap\"]/div[1]/a[1]/div");
		Thread.sleep(3000);
		webtest.click("link=TA�Ĺ�ע/��˿");	
		webtest.click("xpath=//*[@class=\"col-xs-12 uc_fans\"]/ul/li[2]/a");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("admin"));
	}
	
	@Test(description="������ҳ-����")
	public void Homepage4() throws Exception{
		webtest.click("link=΢��");
		webtest.click("xpath=//*[@class=\"dropdown li-hover self-info\"]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class=\"link-wrap\"]/div[1]/a[1]/div");
		Thread.sleep(3000);
		webtest.click("link=����");	
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("��������"));
	}
	
	@Test(description="������ҳ-ͷ��")
	public void Homepage5() throws Exception{
		webtest.click("link=΢��");
		webtest.click("xpath=//*[@class=\"dropdown li-hover self-info\"]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class=\"link-wrap\"]/div[1]/a[1]/div");
		Thread.sleep(3000);
		webtest.click("link=ͷ��");	
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("���޸�����ͷ��Ŷ�� "));
	}
	
	@Test(description="������ҳ-��ע�Ļ���")
	public void Homepage6() throws Exception{
		webtest.click("link=΢��");
		webtest.click("xpath=//*[@class=\"dropdown li-hover self-info\"]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class=\"link-wrap\"]/div[1]/a[1]/div");
		Thread.sleep(3000);
		webtest.click("link=��ע�Ļ���");	
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("�����б�"));
	} 
	
	//ͨ������������ۻ���
	@Test(description="�����������")
	public void TopicEmoji() throws Exception{
		webtest.click("link=΢��");
		webtest.click("class=topic-head");
		Thread.sleep(2000);	
		webtest.click("link=����");
		webtest.click("xpath=//*[@class=\"topic-content\"]/ul/li[1]/a/div[2]");
		Thread.sleep(2000);
		webtest.click("link=����̬");
		webtest.click("xpath=//*[@class=\"col-xs-12\"]/a[1]/img");
		webtest.click("xpath=//*[@id=\"face\"]/a[1]");
		webtest.click("xpath=//input[@value='���� Ctrl+Enter']");
		assertTrue(webtest.isTextPresent("����"));
	}
	
	/**  ����΢����̬  **/
	@Test(description="����΢��-����")
	public void publish1() throws InterruptedException {
		webtest.click("link=΢��");
		webtest.click("title=΢��");
		Thread.sleep(1000);
		webtest.click("class=add-weibo");
		Thread.sleep(3000);
		webtest.click("class=icon-zs");
		Thread.sleep(2000);
		webtest.type("id=weibo_content","��ѩ��");
		webtest.click("class=send-right");
		assertTrue(webtest.isTextPresent("�����ɹ�"));
	}
	
	
	@Test(description="����΢��-�հ�����")
	public void publish2() throws InterruptedException {
		webtest.click("link=΢��");
		webtest.click("title=΢��");
		Thread.sleep(2000);
		webtest.click("class=add-weibo");
		Thread.sleep(2000);
		webtest.click("class=icon-zs");
		Thread.sleep(1000);
		webtest.type("id=weibo_content","");
		webtest.click("class=send-right");
		assertTrue(webtest.isTextPresent("����ʧ��"));
	}
	
	@Test(description="����΢��-����")
	public void publish3() throws InterruptedException {
		webtest.click("link=΢��");
		webtest.click("title=΢��");
		Thread.sleep(1000);
		webtest.click("class=add-weibo");
		Thread.sleep(3000);
		webtest.click("class=icon-zs");
		Thread.sleep(2000);
		webtest.type("id=weibo_content","[love] [qiang]");
		webtest.click("class=send-right");
		assertTrue(webtest.isTextPresent("�����ɹ�"));
	}

	@Test(description="����΢��-����")
	public void publish4() throws Exception {
		webtest.click("link=΢��");
		webtest.click("title=΢��");
		Thread.sleep(2000);
		webtest.click("class=add-weibo");
		Thread.sleep(2000);
		webtest.click("class=icon-zs");
		Thread.sleep(1000);
		webtest.type("id=weibo_content","#��ѧ#");
		webtest.click("class=send-right");
		assertTrue(webtest.isTextPresent("�����ɹ�"));
	}
	
	
	@Test(description="ȡ������΢��")
	public void publish5() throws InterruptedException {
		webtest.click("link=΢��");
		webtest.click("title=΢��");
		Thread.sleep(2000);
		webtest.click("class=add-weibo");
		Thread.sleep(2000);
		webtest.click("class=icon-zs");
		Thread.sleep(1000);
		webtest.type("id=weibo_content","abcd");
		webtest.click("class=send-wrong");
		assertTrue(webtest.isTextPresent("����̬"));
	}

	
	
	/**  ΢����ҳ��Ҫģ��  **/
	@Test(description="�鿴�ҵĹ�ע")
	public void Follow() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("id=concerned");
		assertTrue(webtest.isTextPresent("�ҵĹ�ע"));
	}
	
	@Test(description="�鿴ȫվ��̬")
	public void AllTrends() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("id=all");
		assertTrue(webtest.isTextPresent("ȫվ��̬"));
	}
	
	@Test(description="�鿴���Ŷ�̬")
	public void HotTrends() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("id=hot");
		assertTrue(webtest.isTextPresent("���Ŷ�̬"));
	}
	
	@Test(description="�鿴�ҵ�ϲ��")
	public void MyLike() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("id=fav");
		assertTrue(webtest.isTextPresent("�ҵ�ϲ��"));
	}
	
	@Test(description="����")
	public void DianZan() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@id=\"weibo_55\"]/div[1]/div/div[2]/div/div[2]/div[1]/a");
		assertTrue(webtest.isTextPresent("1"));
	}
	

   /** ��Ϣ���� **/
	@Test(description="�鿴ϵͳ��Ϣ����")
	public void Remind1() throws Exception{
		webtest.click("link=΢��");	
		webtest.click("xpath=//*[@class=\"col-xs-3 box c-b-right\"]/li[2]/a/i");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("�û���Ϣ"));
		assertTrue(webtest.isTextPresent("��ȥ������"));
		
	}
	
	@Test(description="�鿴��̬��Ϣ����")
	public void Remind2() throws Exception{
		webtest.click("link=΢��");	
		webtest.click("xpath=//*[@class=\"col-xs-3 box c-b-right\"]/li[2]/a/i");
		webtest.click("xpath=//*[@class=\"session-list\"]/li[2]/a/div/div/div[1]/img");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("admin"));
		
	}
	
	@Test(description="�鿴�û���Ϣ����")
	public void Remind3() throws Exception{
		webtest.click("link=΢��");	
		webtest.click("xpath=//*[@class=\"col-xs-3 box c-b-right\"]/li[2]/a/i");
		webtest.click("xpath=//*[@class=\"session-list\"]/li[3]/a/div/div/div[1]/img");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("���ظ���"));
	}
	
   /** �鿴���а� **/  
	@Test(description="�鿴���а�")
	public void Rank() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("link=����");
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("���а�"));
	}
	
	@Test(description="�鿴�������а�-24Сʱ")
	public void Topic_24() throws Exception{
		webtest.click("link=΢��");
		webtest.click("class=topic-head");
		webtest.click("link=�鿴����");
		Thread.sleep(2000);
		webtest.click("link= 24Сʱ����");
	}
	
	@Test(description="�鿴�������а�-7��")
	public void Topic_7() throws Exception{
		webtest.click("link=΢��");
		webtest.click("class=topic-head");
		webtest.click("link=�鿴����");
		Thread.sleep(2000);
		webtest.click("link= 7������");
	}
	
	
	/** ���� **/
	@Test(description="�������-�������б�")
	public void Invite1() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("link=��������");
		webtest.click("link=�������б�");
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("ϵͳĬ��������"));
	}
	
	@Test(description="�������-����������")
	public void Invite2() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("link=��������");
		webtest.click("link=����������");
		Thread.sleep(1000);
		webtest.click("link=�һ�����");
		Thread.sleep(2000);
		webtest.click("link=�һ�");
		Thread.sleep(2000);
		webtest.alertAccept();
	//	webtest.click("xpath=//*[@class=\"invite_content\"]/table/tbody/tr/td[8]/a[2]");
		webtest.click("xpath=/html/body/div[4]/div/table/tbody/tr[2]/td[2]/div/div[2]/table/tbody/tr/td[8]/a[2]");	
	//	webtest.click("class=btn btn-primary");
		Thread.sleep(2000);
		webtest.click("link=����");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("������������"));
	}
	
	@Test(description="����-��Ϣ����")
	public void Invite() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("link=��������");
		webtest.click("link=��Ϣ����");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("δ����Ϣ"));
	}
	
	@Test(description="����-�ҵ��ղ�")
	public void Collection() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("link=��������");
		webtest.click("link=�ҵ��ղ�");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("��̳�����ղ�"));
	}
}
