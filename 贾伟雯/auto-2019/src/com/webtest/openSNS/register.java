package com.webtest.openSNS;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.jiaweiwen.ApiListener;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
//ע��ģ��
@Listeners(ApiListener.class)
public class register extends BaseTest{
	@DataProvider(name="register_name")
	public Object[][] data()throws IOException {
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("F://��Ŀʵѵ//data2.xlsx","Sheet1");
	}
	
	//�������� ��18����������  ����ע��
	@Test(dataProvider="register_name",description="����ע��")
	public void testRegister(String u_name,String n_name,String p_word) throws InterruptedException {
		//��ҳ��
		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
		//�ı�������
		webtest.click("link=ע��");
		//����ע�� 
		webtest.click("link=����ע��");
		webtest.type("name=username", u_name);
		webtest.type("name=nickname", n_name);
		webtest.type("name=password", p_word);
		Thread.sleep(3000);
		webtest.click("xpath=//button[@type='submit']");
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("΢��"));
	}
	
	//�������� ��18���������� �ֻ���ע��
	@Test(dataProvider="register_name",description="�ֻ�ע��")
	public void testRegisterByPhoneSuccess(String u_name,String n_name,String p_word) throws InterruptedException {
		//��ҳ��
		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
		//�ı�������
		webtest.click("link=ע��");
		//�ֻ���ע�� 
		webtest.click("link=�ֻ�ע��");
		webtest.type("id=mobile", u_name);
		webtest.type("id=nickname", n_name);
		webtest.type("id=inputPassword", p_word);
		Thread.sleep(3000);
		webtest.click("xpath=//button[@type='submit']");
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("΢��"));
	}
	
//	@Test
//	public void testRegisterByEmailFail() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		webtest.click("link=ע��");
//		//����ע�� ʧ�� ʹ����ע������ע��
//		webtest.click("link=����ע��");
//		webtest.type("name=username", "18330919107@163.com");
//		webtest.type("name=nickname", "user2");
//		webtest.type("name=password", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
//	
//	@Test
//	public void testRegisterByEmailFail2() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		webtest.click("link=ע��");
//		//����ע�� ʧ�� ʹ�ó��Ȳ�����Ҫ�������
//		webtest.click("link=����ע��");
//		webtest.type("name=username", "18330919107@163.com");
//		webtest.type("name=nickname", "user3");
//		webtest.type("name=password", "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
//	
//	@Test
//	public void testRegisterByEmailFail3() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		webtest.click("link=ע��");
//		//����ע�� ʧ�� ʹ�ò���ȷ������
//		webtest.click("link=����ע��");
//		webtest.type("name=username", "18330919107");
//		webtest.type("name=nickname", "user4");
//		webtest.type("name=password", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
//	
//	@Test
//	public void testRegisterByEmailFail4() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		webtest.click("link=ע��");
//		//����ע�� ʧ�� ʹ����ע����û���
//		webtest.click("link=����ע��");
//		webtest.type("name=username", "272904051@qq.com");
//		webtest.type("name=nickname", "jiaweiwen");
//		webtest.type("name=password", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
//	
//	@Test
//	public void testRegisterByEmailFail5() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		webtest.click("link=ע��");
//		//����ע�� ʧ�� ʹ�ò�����Ҫ����û���
//		webtest.click("link=����ע��");
//		webtest.type("name=username", "272904051@qq.com");
//		webtest.type("name=nickname", "&&&&&&&&");
//		webtest.type("name=password", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
//	
//	@Test
//	public void testRegisterByEmailFail6() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		webtest.click("link=ע��");
//		//����ע�� ʧ�� ʹ�ó��Ȳ����Ϲ淶���û���
//		webtest.click("link=����ע��");
//		webtest.type("name=username", "272904051@qq.com");
//		webtest.type("name=nickname", "h");
//		webtest.type("name=password", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
//	
//	@Test
//	public void testRegisterByEmailFail7() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		webtest.click("link=ע��");
//		//����ע�� ʧ�� ����Ϊ������
//		webtest.click("link=����ע��");
//		webtest.type("name=username", "272904051@qq.com");
//		webtest.type("name=nickname", "hello1");
//		webtest.type("name=password", "123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
//	
//	@Test
//	public void testRegisterByEmailFail8() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		webtest.click("link=ע��");
//		//����ע�� ʧ�� ʹ�ÿյ��û���
//		webtest.click("link=����ע��");
//		webtest.type("name=username", "272904051@qq.com");
//		webtest.type("name=password", "123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
//	
//	@Test
//	public void testRegisterByPhoneSuccess() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		webtest.click("link=ע��");
//		//�ֻ���ע�� �ɹ�
//		webtest.click("link=�ֻ�ע��");
//		webtest.type("id=mobile", "18731179963");
//		webtest.type("id=nickname", "user5");
//		webtest.type("id=inputPassword", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
//	
//	@Test
//	public void testRegisterByPhoneFail1() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		webtest.click("link=ע��");
//		//�ֻ���ע�� ʧ�� �ֻ��ų��ȴ���
//		webtest.click("link=�ֻ�ע��");
//		webtest.type("id=mobile", "187311799631");
//		webtest.type("id=nickname", "user6");
//		webtest.type("id=inputPassword", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
//	
//	@Test
//	public void testRegisterByPhoneFail2() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		webtest.click("link=ע��");
//		//�ֻ���ע�� ʧ�� ʹ����ע������ֻ���
//		webtest.click("link=�ֻ�ע��");
//		webtest.type("id=mobile", "18330919107");
//		webtest.type("id=nickname", "user7");
//		webtest.type("id=inputPassword", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
//
//	@Test
//	public void testRegisterByPhoneFail3() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		webtest.click("link=ע��");
//		//�ֻ���ע�� ʧ�� ����յ��ֻ���
//		webtest.click("link=�ֻ�ע��");
//		webtest.type("id=nickname", "user8");
//		webtest.type("id=inputPassword", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
//	
//	@Test
//	public void testRegisterByPhoneFail4() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		webtest.click("link=ע��");
//		//�ֻ���ע�� ʧ�� �ֻ��Ÿ�ʽ����
//		webtest.click("link=�ֻ�ע��");
//		webtest.type("id=mobile", "18330919107@163.com");
//		webtest.type("id=nickname", "user9");
//		webtest.type("id=inputPassword", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
//	
//	@Test
//	public void testRegisterByPhoneFail5() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		webtest.click("link=ע��");
//		//�ֻ���ע�� ʧ�� ʹ����ע���û���ע��
//		webtest.click("link=�ֻ�ע��");
//		webtest.type("id=mobile", "13785984807");
//		webtest.type("id=nickname", "jiaweiwen");
//		webtest.type("id=inputPassword", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
//	
//	@Test
//	public void testRegisterByPhoneFail6() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		webtest.click("link=ע��");
//		//�ֻ���ע�� ʧ�� �û��������Ϲ淶
//		webtest.click("link=�ֻ�ע��");
//		webtest.type("id=mobile", "13785984807");
//		webtest.type("id=nickname", "��������������");
//		webtest.type("id=inputPassword", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
//	
//	@Test
//	public void testRegisterByPhoneFail7() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		webtest.click("link=ע��");
//		//�ֻ���ע�� ʧ�� �û������Ȳ����Ϲ淶
//		webtest.click("link=�ֻ�ע��");
//		webtest.type("id=mobile", "13785984807");
//		webtest.type("id=nickname", "h");
//		webtest.type("id=inputPassword", "user123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
//	
//	@Test
//	public void testRegisterByPhoneFail8() throws InterruptedException {
//		//��ҳ��
//		webtest.open("http://localhost:8080/opensns/index.php?s=/home/index/index.html");
//		//�ı�������
//		webtest.click("link=ע��");
//		//�ֻ���ע�� ʧ�� ����Ϊ������
//		webtest.click("link=�ֻ�ע��");
//		webtest.type("id=mobile", "13785984807");
//		webtest.type("id=nickname", "user10");
//		webtest.type("id=inputPassword", "123456");
//		Thread.sleep(3000);
//		webtest.click("xpath=//button[@type='submit']");
//		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("΢��"));
//	}
}



