package xiangmu;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;


@Listeners(com.webtest.core.ApiListener.class)
public class Demo1 extends BaseTest{
	
	
	
//  ��������1
	@Test(description="������")
	public void FindInvitationByName1() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.type("xpath=//input[@placeholder='������']","����Ƚ1");	
		webtest.tapClickEnter();//�س���
		assertTrue(webtest.isTextPresent("����Ƚ1"));
		//assertTrue(webtest.isTextPresent("����"));	
	}
	
//	��������2��������������ֻ����ɣ�
//	@Test(description="������")
//	public void ReportInvitation() throws Exception  {	
//		
//		webtest.click("link=��̳");
//		webtest.click("link=������");
//		webtest.type("name=title","����Ƚ5");	
//		//webtest.click("xpath=//*[@id=\"edui1_iframeholder\"]");
//		getDriver().switchTo().frame("edui1_iframeholder");//���ı���
//		webtest.type("xpath=//*[@id=\"edui1_iframeholder\"]", "�濪��");
//		getDriver().switchTo().defaultContent();//���ı���
//		webtest.click("id=submit-content");
//		
//		//assertTrue(webtest.isTextPresent("����Ƚ1"));
//			
//	}

//	��������3	
	@Test(description="�ҵ�ȫ����������Ĭ�ϰ��")
	public void FindAllsections1() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("link=ȫ�����");
		webtest.click("xpath=//*[@id=\"main-container\"]/div/div[2]/div/a/div[2]");	
		
		assertTrue(webtest.isTextPresent("�����б�"));
	
	}
	
//	��������4
	@Test(description="�ҵ�ȫ���������Ĺٷ�����")
	public void FindAllsections2() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("link=ȫ�����");
		webtest.click("xpath=//*[@id=\"main-container\"]/div/div[3]/div/a/div[2]/p[1]");	
		
		assertTrue(webtest.isTextPresent("�����б�"));
	
	}

	
//	��������5
	@Test(description="�����㿴��������б��һ������")
	public void LookAroundInvitation1() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("link=��㿴��");
		webtest.click("link=����Ƚ4");	
		
		assertTrue(webtest.isTextPresent("����Ƚ4"));
	
	}
	
//	��������6	
	@Test(description="�����㿴�������һ��")
	public void LookAroundInvitation2() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("link=��㿴��");
		webtest.click("class=icon-refresh");	
		
		//assertTrue(webtest.isTextPresent("����Ƚ4"));
	
	}

//	��������7	
//	@Test(description="�����㿴�������һ��")
//	public void LookAroundInvitation3() throws Exception  {	
//		
//		webtest.click("link=��̳");
//		webtest.click("link=��㿴��");
//		webtest.click("class=icon-refresh");	
//		
//		//assertTrue(webtest.isTextPresent("����Ƚ4"));
//	
//	}
	
	
//	��������8		
	@Test(description="��������鿴�Լ���������������")
	public void FindPublishInvitation() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id=\"body-container\"]/div[2]/div[2]/div[2]/a[1]");	
		assertTrue(webtest.isTextPresent("root������"));
	
	}
	
//	��������9		
	@Test(description="��������鿴�Լ����еĻظ�")
	public void FindAllReply() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id=\"body-container\"]/div[2]/div[2]/div[2]/a[2]");	
		assertTrue(webtest.isTextPresent("root�Ļظ�"));
	
	}
	
//	��������10		
	@Test(description="����鿴�»�Ա�����й�ע")
	public void FindMember() throws Exception  {	
		
		webtest.click("link=��̳");
		webtest.click("xpath=//*[@id=\"body-container\"]/div[1]/div[2]/span[5]/a");
		webtest.click("xpath=//*[@id=\"main-container\"]/div/div/div/div[1]/div/div/div[2]/button[1]");
		
		assertTrue(webtest.isTextPresent("�ѹ�ע"));
	
	}
	
}
