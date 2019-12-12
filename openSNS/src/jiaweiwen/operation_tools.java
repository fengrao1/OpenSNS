package jiaweiwen;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;

import com.webtest.utils.ReadProperties;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

@Listeners(WebTestListener.class)
public class operation_tools extends BaseTest{
	
	public void login_before() throws InterruptedException, IOException{
		String opensns_url =ReadProperties.getPropertyValue("base_url");
		//��ҳ��
		webtest.open(opensns_url);
		//��¼�ɹ�
		webtest.click("link=��¼");
		webtest.type("name=username", "z1");
		webtest.type("name=password", "123456");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(2000);
		//ǩ��
		webtest.click("link=΢��");
	}
	
	@Test(description="ǩ��")
	public void operation_toolsSuccess() throws InterruptedException, IOException {
		login_before();
		webtest.click("xpath=//i[@class='c-icon c-icon-checking']");
		webtest.click("ǩ��");
		webtest.click("link=X");
		assertTrue(webtest.isTextPresent("��ǩ"));
	}
	
	@Test
	public void operation_toolsSuccess2() throws InterruptedException, IOException {
		//���а�
		login_before();
		webtest.click("xpath=//i[@class='c-icon c-icon-rank']");
		webtest.click("xpath=/html/body/div[5]/div/div[2]/div[1]/div[4]/div[2]/p[1]/span[2]/a[2]");
		assertTrue(webtest.isTextPresent("����"));
	}
	
	@Test
	public void operation_toolsSuccess3() throws InterruptedException, IOException {
		//�û���Ƭ���ע
		login_before();
		webtest.click("xpath=//button[@class='btn btn-primary']");
		//ȡ����ע
		webtest.click("xpath=//button[@class='btn btn-primary']");
		assertTrue(webtest.isTextPresent("��ע"));
	}
	
	
	@Test
	public void operation_toolsSuccess5() throws InterruptedException, IOException {
		//΢��ҳ�������Ƭ
		login_before();
		webtest.click("link=΢��");
		webtest.click("link=root");
		assertTrue(webtest.isTextPresent("����"));
	}
	
	@Test
	public void operation_toolsSuccess6() throws InterruptedException, IOException {
		//΢��ҳ��鿴24Сʱ����
		login_before();
		webtest.click("link=΢��");
		webtest.click("link=�鿴����");
		webtest.click("link=24Сʱ����");
		assertTrue(webtest.isTextPresent("24Сʱ����"));
	}
	
	@Test
	public void operation_toolsSuccess7() throws InterruptedException, IOException {
		//΢��ҳ��鿴7������
		login_before();
		webtest.click("link=΢��");
		webtest.click("link=�鿴����");
		webtest.click("link=7������");
		assertTrue(webtest.isTextPresent("7������"));
	}
	
	@Test
	public void operation_toolsSuccess8() throws InterruptedException, IOException {
		//΢��ҳ��ȫվ����
		login_before();
		webtest.click("xpath=//i[@class='iconfont icon-zxc']");
		webtest.click("xpath=//input[@placeholder='ȫվ����']");
		webtest.type("class=input", "hello");
		Thread.sleep(1000);
		webtest.click("xpath=//i[@class='icon icon-search pull-right']");
		assertTrue(webtest.isTextPresent("����"));
	}
	
	@Test
	public void operation_toolsSuccess9() throws InterruptedException, IOException {
		//΢��ҳ��һ�����ض���
		login_before();
	    webtest.toBottom();
		webtest.click("xpath=//*[@id='go-top']");
		assertTrue(webtest.isTextPresent("΢��"));
	}
	
	@Test
	public void operation_toolsSuccess11() throws InterruptedException, IOException {
		//�鿴����
		login_before();
		webtest.click("xpath=//i[@class='iconfont icon-duihua']");
		assertTrue(webtest.isTextPresent("֪ͨ"));
	}

	
}









