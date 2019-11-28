package fengrao;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import com.webtest.core.BaseTest;
@Listeners(com.webtest.core.ApiListener.class)
public class Demo2 extends BaseTest {
	/**
	 * ���ݱ����ժҪ�ؼ��ֲ�����Ѷ
	 **/
	@Test(description="���ݲ����ڵ����ݲ���")
	public void FindBytitle1() throws Exception  {	

		webtest.click("link=��Ѷ");
		webtest.type("xpath=//input[@placeholder='�������/ժҪ�ؼ���']","0");	
		webtest.tapClickEnter();//�س���
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("��������û����Ѷ~"));
	}
	@Test(description="���ݱ������")
	public void FindBytitle2() throws Exception  {		
		webtest.click("link=��Ѷ");
		webtest.type("xpath=//input[@placeholder='�������/ժҪ�ؼ���']","����");	
		webtest.tapClickEnter();//�س���
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("����"));
		assertTrue(!webtest.isTextPresent("��������û����Ѷ~"));
	}
	@Test(description="����ժҪ�ؼ��ֲ���")
	public void FindByContent() throws Exception  {		
		webtest.click("link=��Ѷ");
		webtest.type("xpath=//input[@placeholder='�������/ժҪ�ؼ���']","��ƪ��Ѷ��Ҫ");	
		webtest.tapClickEnter();//�س���
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("��ƪ��Ѷ��Ҫ"));
		assertTrue(!webtest.isTextPresent("��������û����Ѷ~"));
	}
}
