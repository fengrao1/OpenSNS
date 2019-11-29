package com.webtest.openSNS;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebDriverEngine;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.jiaweiwen.ApiListener;

//��¼ģ��
@Listeners(ApiListener.class)
public class login extends BaseTest{
	
	@DataProvider(name="user_name")
	public Object[][] data()throws IOException {
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("F://��Ŀʵѵ//data3.xlsx","Sheet1");
	}
	
	//�������� ��12����������
	@Test(dataProvider="user_name",description="name")
	public void testLogin(String u_name,String p_word) throws InterruptedException {
		//��ҳ��
		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
		//�ı�������
		//��¼�ɹ�
		webtest.click("link=��¼");
		webtest.type("name=username", u_name);
		webtest.type("name=password", p_word);
		Thread.sleep(2000);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("΢��"));
		webtest.click("xpath=//span[@class='user-name text-ellipsis']");
		//webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
	}
//	
//	@Test
//	public void testLoginSuccess2() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		//��¼�ɹ�
//		webtest.click("link=��¼");
//		webtest.type("name=username", "13303093175");
//		webtest.type("name=password", "user123456");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		Thread.sleep(2000);
//		assertTrue(webtest.isTextPresent("grandmother"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
//	@Test
//	public void testLoginFail() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		//��¼ʧ�� ������������ȷ������
//		webtest.click("link=��¼");
//		webtest.type("name=username", "183309191071@163.com");
//		webtest.type("name=password", "jww18330919107");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("jiaweiwen"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
//	@Test
//	public void testLoginFail2() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		//��¼ʧ�� ��������� ��ȷ�������
//		webtest.click("link=��¼");
//		webtest.type("name=username", "18330919107@163.com");
//		webtest.type("name=password", "jww183309");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("jiaweiwen"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
//	@Test
//	public void testLoginFail3() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		//��¼ʧ�� �յ������ �� ����
//		webtest.click("link=��¼");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("jiaweiwen"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
//	@Test
//	public void testLoginFail4() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		//��¼ʧ�� ����δע��������
//		webtest.click("link=��¼");
//		webtest.type("name=username", "18731179963@163.com");
//		webtest.type("name=password", "jww18330919107");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("jiaweiwen"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
////	
//	@Test
//	public void testLoginFail5() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		//��¼ʧ�� ����δע���ֻ���
//		webtest.click("link=��¼");
//		webtest.type("name=username", "13131986099");
//		webtest.type("name=password", "jww18330919107");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("mother"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
//	@Test
//	public void testLoginFail6() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		//��¼ʧ�� ��������Сд��Ϊ��д
//		webtest.click("link=��¼");
//		webtest.type("name=username", "18330919107@163.com");
//		webtest.type("name=password", "JWW18330919107");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("jiaweiwen"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
//	@Test
//	public void testLoginFail7() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		//��¼ʧ�� ʹ���û�����¼
//		webtest.click("link=��¼");
//		webtest.type("name=username", "jiaweiwen");
//		webtest.type("name=password", "jww18330919107");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("jiaweiwen"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
//	@Test
//	public void testLoginFail8() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		//��¼ʧ�� ������ֻ��Ŵ��������
//		webtest.click("link=��¼");
//		webtest.type("name=username", "13131986099");
//		webtest.type("name=password", "jww18330919107");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("mother"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
//	@Test
//	public void testLoginFail9() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		//��¼ʧ�� ��ȷ���ֻ��Ŵ��������
//		webtest.click("link=��¼");
//		webtest.type("name=username", "13303093175");
//		webtest.type("name=password", "jww18330919107");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("grandmother"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
//	@Test
//	public void testLoginFail10() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		//��¼ʧ�� ���������淶
//		webtest.click("link=��¼");
//		webtest.type("name=username", "18330919107@163.COM");
//		webtest.type("name=password", "jww18330919107");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("jiawenwen"));
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
//		webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
//	}
//	
}


