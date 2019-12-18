package com.opensns.frontstage;

import java.io.IOException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.utils.ReadProperties;
/**
 * @author ��ΰ��
 * �û�����
 */
@Listeners(WebTestListener.class)
public class Usercenter extends BaseTest{
	@Test(description="�鿴δ����Ϣ")
	public void testusercenterSuccess() throws InterruptedException, IOException {
		String opensns_url =ReadProperties.getPropertyValue("base_url");
		//��ҳ��
		webtest.open(opensns_url);
		//�ı�������
		//��¼�ɹ�
		webtest.click("link=��¼");
		webtest.type("name=username", "139748643@qq.com");
		webtest.type("name=password", "123456");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(4000);
		webtest.click("xpath=//i[@class='iconfont icon-caidan']");
		webtest.click("link=��Ϣ����");
		webtest.click("link=δ����Ϣ");
//		assertTrue(webtest.isTextPresent("�˳�"));
	}
	
	@Test(description="�鿴ȫ����Ϣ")
	public void testusercenterSuccess2() throws InterruptedException {
		webtest.click("link=ȫ����Ϣ");
//		assertTrue(webtest.isTextPresent("�˳�"));
	}

	@Test(description="�鿴ϵͳ��Ϣ")
	public void testusercenterSuccess3() throws InterruptedException {
		webtest.click("link=ϵͳ��Ϣ");
//		assertTrue(webtest.isTextPresent("�˳�"));
	}
	
	@Test(description="�鿴�û���Ϣ")
	public void testusercenterSuccess4() throws InterruptedException {
		webtest.click("link=�û���Ϣ");
//		assertTrue(webtest.isTextPresent("�˳�"));
	}
	
	@Test(description="�鿴Ӧ����Ϣ")
	public void testusercenterSuccess5() throws InterruptedException {
		webtest.click("link=Ӧ����Ϣ");
//		assertTrue(webtest.isTextPresent("�˳�"));
	}
	
	@Test(description="�鿴��̳�����ղ�")
	public void testusercenterSuccess6() throws InterruptedException {
		webtest.click("link=�ҵ��ղ�");
		webtest.click("link=��̳�����ղ�");
//		assertTrue(webtest.isTextPresent("�˳�"));
	}
	
	@Test(description="Ⱥ�������ղ�")
	public void testusercenterSuccess7() throws InterruptedException {
		webtest.click("link=�ҵ��ղ�");
		webtest.click("link=Ⱥ�������ղ�");
//		assertTrue(webtest.isTextPresent("�˳�"));
	}
	
	@Test(description="����������")
	public void testusercenterSuccess8() throws InterruptedException {
		webtest.click("link=�������");
		webtest.click("link=����������");
		webtest.click("data-role=create_invite");
//		assertTrue(webtest.isTextPresent("�˳�"));
	}
	
	@Test(description="�������б�")
	public void testusercenterSuccess9() throws InterruptedException {
		webtest.click("link=�������б�");
		webtest.click("id=zclip-ZeroClipboardMovie_1");
//		assertTrue(webtest.isTextPresent("�˳�"));
	}

}
