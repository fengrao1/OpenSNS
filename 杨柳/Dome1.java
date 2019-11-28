package com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.WebConnection;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.ISDTContent;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Listeners(com.webtest.core.ApiListener.class)

public class Dome1 extends BaseTest {

	
//	@Test(dataProvider = "d",description="��¼")
//	public void test1(String p1, String p2) throws InterruptedException {
//		// 1)��¼
//		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
//		webtest.type("name=username", p1);
//		webtest.type("name=password", p2);
//		webtest.click("xpath=//button[@type='submit']");
//		Thread.sleep(4000);
//	}
//
//	@Test(description="Ȩ�޹���")
//	public void test2() throws InterruptedException {
//		// 2��4.1.1 ģ��Ȩ�޹���
//		Thread.sleep(2000);
//		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[1]/a");
//		webtest.click("link=������ݷ���");
//		
//		webtest.click("name=role_module[13][]");	
//		webtest.click("id=save-role-module-auth");
//		
//		//��ǰ̨���˳���¼
//		webtest.open("http://localhost:8585/index.php?s=/forum/index/index.html");
//		Thread.sleep(3000);
//		webtest.mouseoverElement("link=root");
//		webtest.click("class=os-icon-logout");
//		
//		webtest.click("xpath=//*[@id='nav_bar']/div/ul/li[4]/a/span[1]");
//		assertTrue(webtest.isTextPresent("��ģ��δ�Էǵ�¼�û����š�"));
//	}
//	
//	@Test(description="�Ǳ���")
//	public void test3() throws InterruptedException{
//		// 2��4.1.2.1�Ǳ���
//		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
//		webtest.type("name=username", "root");
//		webtest.type("name=password", "root");
//		webtest.click("xpath=//button[@type='submit']");
//		Thread.sleep(4000);
//		webtest.click("link=��ҳ");
//		assertTrue(webtest.isTextPresent("���ò���"));
//	}
//	
//	@Test(description="����Ԥ��")
//	public void test4() throws InterruptedException{
//		// 2��4.1.2.2���ݸ���
//		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[1]/a");
//		webtest.click("link=���ݸ���");
//		
//		//���ͼ��
//		webtest.click("class=icon-plus");
//		webtest.click("xpath=//*[@id='portlet_list']/div[1]/a");
//				
//		//�鿴����
//		webtest.click("link=�鿴����");
//		webtest.click("link=��ϸ");
//		webtest.click("xpath=//button[@class='btn btn-return']");
//		webtest.click("link=ɾ��");
//		
//		Alert alert = driver.switchTo().alert();
//		Assert.assertEquals("ȷ��Ҫִ�иò�����?", alert.getText());
//		alert.accept();
//	}
	
	
	@Test(description="������û�_��֤����")
	public void test5() throws InterruptedException{
		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
		webtest.type("name=username", "root");
		webtest.type("name=password", "root");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(4000);
		
		webtest.mouseoverElement("link=�û������");
		webtest.click("link=��֤����");
		
		//��֤��������
		webtest.click("link=����");
		webtest.type("xpath=//input[@name='follow']","1");
		webtest.click("xpath=//*[@id='submit']");
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		alert.accept();
		Thread.sleep(3000);
		
		//��֤�ֶ�����
		webtest.click("xpath=//*[@id='table-data']/tbody/tr[1]/td[19]/a");
		webtest.click("id=id_company_name_1");
		webtest.click("id=id_name_1");
		webtest.click("id=id_id_num_1");
		webtest.click("id=id_image_type_1");
		webtest.click("id=submit");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		//��ǰ̨��֤
		webtest.open("http://localhost:8585/index.php?s=/ucenter/attest/individual/id/1.html");
		assertTrue(webtest.isTextPresent("�ѷ���"));
		webtest.click("link=����");
	}
	
	
	@Test(description="������û�_�û���Ϣ")
	public void test6() throws InterruptedException{
		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
		webtest.type("name=username", "root");
		webtest.type("name=password", "root");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(4000);
		
		webtest.mouseoverElement("link=�û������");
		webtest.click("link=�û���Ϣ");
		
		//����
		webtest.click("class=ajax-get");
		webtest.type("xpath=//input[@name='forbid_day']","1");
		webtest.click("xpath=//button[@class='btn btn-block btn-primary red-btn']");
		
		assertTrue(webtest.isTextPresent("��������"));
		
		//ɾ��
		Thread.sleep(3000);
		webtest.click("link=ɾ��");
		Thread.sleep(3000);
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("ȷ��Ҫִ�иò�����?", alert1.getText());
		alert1.dismiss();
		Thread.sleep(3000);
	}
	
	
	@Test(description="������û�_��������")
	public void test7() throws InterruptedException{
		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
		webtest.type("name=username", "root");
		webtest.type("name=password", "root");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(4000);
		
		webtest.mouseoverElement("link=�û������");
		webtest.click("link=��������");
		
		webtest.click("id=id_REGISTER_TYPE_normal");
		webtest.click("xpath=//*[@id='submit']");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		//ȫ��ѡע�Ὺ�ؼ�Ϊ�ر�ע��
		webtest.open("http://localhost:8585/index.php?s=/home/index/index.html");
		webtest.mouseoverElement("link=root");
		webtest.click("class=os-icon-logout");
		webtest.click("link=ע��");
		assertTrue(webtest.isTextPresent("ע���ѹر�"));
		webtest.click("link=������ҳ");
	}
	
	@Test(description="������û�_��¼����")
	public void test8() throws InterruptedException{
		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
		webtest.type("name=username", "root");
		webtest.type("name=password", "root");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(4000);
		
		webtest.mouseoverElement("link=�û������");
		webtest.click("link=��������");
		
		//��¼����
		webtest.click("link=��¼����");
		webtest.click("id=id_OPEN_QUICK_LOGIN_1");
		webtest.click("id=submit");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		//��ǰ̨���˳���¼
		webtest.open("http://localhost:8585/index.php?s=/forum/index/index.html");
		Thread.sleep(3000);
		webtest.mouseoverElement("link=root");
		webtest.click("class=os-icon-logout");
		webtest.click("link=��¼");
		assertTrue(webtest.isTextPresent("��ӭ�ص� OpenSNS v5��Դ��Ⱥϵͳ ��"));
				
	}
	
	@Test(description="��Ӫ_��������")
	public void test9() throws InterruptedException{
		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
		webtest.type("name=username", "root");
		webtest.type("name=password", "root");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(4000);
		
		//�����������
		webtest.mouseoverElement("link=��Ӫ");
		webtest.click("link=��������");
		webtest.click("link=����");
		webtest.type("name=title","�ٶ�");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='tab1']/div[2]/div/label[2]/input");
		webtest.type("xpath=//input[@name='link']", "https://www.baidu.com/");
		webtest.click("xpath=//input[@type='submit']");
		
		//��ǰ̨
		webtest.open("http://localhost:8585/index.php?s=/home/index/index.html");
		assertTrue(webtest.isTextPresent("�ٶ�"));
	}
	
	
	@Test(description="��Ӫ_�����б�_����")
	public void test10() throws InterruptedException{
		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
		webtest.type("name=username", "root");
		webtest.type("name=password", "root");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(4000);
		
		//��������
		webtest.mouseoverElement("link=��Ӫ");
		webtest.click("link=�����б�");
		webtest.click("link=����");
		webtest.type("xpath=//input[@name='title']","���");
		webtest.type("xpath=//input[@name='link']","https://www.baidu.com/");
		webtest.click("xpath=//button[@type='submit']");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		assertTrue(webtest.isTextPresent("���"));
	}
	
	
	@Test(description="��Ӫ_�����б�_ɾ��")
	public void test11() throws InterruptedException{
		webtest.click("xpath=//input[@type='checkbox']");
		webtest.click("link=ɾ��");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
	}
	
	
	@Test(description="��Ӫ_���д�����")
	public void test12() throws InterruptedException{
		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
		webtest.type("name=username", "root");
		webtest.type("name=password", "root");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(4000);
		
		webtest.mouseoverElement("link=��Ӫ");
		webtest.click("link=���д�����");
		webtest.click("id=id_OPEN_SENSITIVE_1");
		webtest.click("id=submit");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
	}
	
	@Test(description="��Ӫ_���д��б�")
	public void test13(){
		
	}

}