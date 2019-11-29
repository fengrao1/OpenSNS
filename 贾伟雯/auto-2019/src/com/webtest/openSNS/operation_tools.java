package com.webtest.openSNS;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.jiaweiwen.ApiListener;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

@Listeners(ApiListener.class)
public class operation_tools extends BaseTest{
	
	public void login_before() throws InterruptedException{
		//��ҳ��
		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
		//�ı�������
		//��¼�ɹ�
		webtest.click("link=��¼");
		webtest.type("name=username", "18330919107@163.com");
		webtest.type("name=password", "jww18330919107");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(2000);
		//ǩ��
		webtest.click("link=΢��");
	}
	
	@Test(description="ǩ��")
	public void operation_toolsSuccess() throws InterruptedException {
		login_before();
		webtest.click("xpath=//i[@class='c-icon c-icon-checking']");
		webtest.click("ǩ��");
		webtest.click("link=X");
		assertTrue(webtest.isTextPresent("��ǩ"));
	}
//	
//	@Test
//	public void operation_toolsSuccess2() throws InterruptedException {
//		//���а�
//		login_before();
//		webtest.click("xpath=//i[@class='c-icon c-icon-rank']");
//		webtest.click("xpath=/html/body/div[5]/div/div[2]/div[1]/div[4]/div[2]/p[1]/span[2]/a[2]");
//		assertTrue(webtest.isTextPresent("����"));
//	}
//	
//	@Test
//	public void operation_toolsSuccess3() throws InterruptedException {
//		//�û���Ƭ���ע
//		login_before();
//		webtest.click("xpath=//button[@class='btn btn-primary']");
//		//ȡ����ע
//		webtest.click("xpath=//button[@class='btn btn-primary']");
//		assertTrue(webtest.isTextPresent("��ע"));
//	}
//	
//	@Test
//	public void operation_toolsSuccess4() throws InterruptedException {
//		//�û���Ƭ������
//		login_before();
//		webtest.click("xpath=/html/body/div[4]/div/div/div/div/div[1]/div/div/div[2]/button[2]");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
//	
//	@Test
//	public void operation_toolsSuccess5() throws InterruptedException {
//		//΢��ҳ�������Ƭ
//		login_before();
//		webtest.click("link=΢��");
//		webtest.click("link=root");
//		assertTrue(webtest.isTextPresent("����"));
//	}
//	
//	@Test
//	public void operation_toolsSuccess6() throws InterruptedException {
//		//΢��ҳ��鿴24Сʱ����
//		login_before();
//		webtest.click("link=΢��");
//		webtest.click("link=�鿴����");
//		webtest.click("link=24Сʱ����");
//		assertTrue(webtest.isTextPresent("24Сʱ����"));
//	}
//	
//	@Test
//	public void operation_toolsSuccess7() throws InterruptedException {
//		//΢��ҳ��鿴7������
//		login_before();
//		webtest.click("link=΢��");
//		webtest.click("link=�鿴����");
//		webtest.click("link=7������");
//		assertTrue(webtest.isTextPresent("7������"));
//	}
//	
//	@Test
//	public void operation_toolsSuccess8() throws InterruptedException {
//		//΢��ҳ��ȫվ����
//		login_before();
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[1]/a/i");
//		webtest.click("xpath=//input[@placeholder='ȫվ����']");
//		webtest.type("class=input", "hello");
//		webtest.click("xpayh=/html/body/div[2]/div[4]/div/div[1]/form/a/i");
//		assertTrue(webtest.isTextPresent("����"));
//	}
//	
//	@Test
//	public void operation_toolsSuccess9() throws InterruptedException {
//		//΢��ҳ��һ�����ض���
//		login_before();
//	    webtest.toBottom();
//		webtest.click("xpath=//*[@id='go-top']");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
//	
//	@Test
//	public void operation_toolsSuccess10() throws InterruptedException {
//		//����
//		login_before();
//		webtest.click("xpath=/html/body/div[4]/div/div/div/div/div[1]/div/div/div[2]/button[2]");
//		webtest.click("xpath=//*[@id='chat_content']");
//		webtest.type("id=chat_content", "hello");
//		webtest.click("xpath=/html/body/div[1]/div[2]/div[2]/div[4]/div[2]/button");
//		webtest.click("xpath=/html/body/div[1]/div[2]/div[2]/div[4]/div[1]/button/i");
//		webtest.click("xpath=/html/body/div[1]/div[2]/div[2]/div[1]/div[2]/a/i");
//	}
//	
//	@Test
//	public void operation_toolsSuccess11() throws InterruptedException {
//		//�鿴����
//		login_before();
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[2]/a/i");
//		assertTrue(webtest.isTextPresent("֪ͨ"));
//	}
}









