package yangliu;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByClassName;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.utils.ReadProperties;

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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Listeners(WebTestListener.class)

public class Demo1 extends BaseTest {
	
	@BeforeMethod
	public void doBeforeMethod() throws Exception{
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		webtest.open(url_h);
		webtest.type("name=username", "root");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(4000);
	}
	
	// ������������
		@DataProvider(name = "d")
		public Object[][] getData1() throws IOException {
			ExcelDataProvider d = new ExcelDataProvider();
			return d.getTestDataByExcel("data/yangliu/test.xlsx","Sheet1");
		}
		
		
	//test16
		@DataProvider(name = "d16")
		public Object[][] getData2() throws IOException {
			ExcelDataProvider d = new ExcelDataProvider();
			return d.getTestDataByExcel("data/yangliu/test16.xlsx","Sheet1");
		}
	
	//test23
		@DataProvider(name = "d23")
		public Object[][] getData3() throws IOException {
			ExcelDataProvider d = new ExcelDataProvider();
			return d.getTestDataByExcel("data/yangliu/test23.xlsx","Sheet1");
		}
		
	//test24
		@DataProvider(name = "d24")
		public Object[][] getData4() throws IOException {
			ExcelDataProvider d = new ExcelDataProvider();
			return d.getTestDataByExcel("data/yangliu/test24.xlsx","Sheet1");
		}
	
	public WebDriver getDriver() {
        return driver;
    }

	
	@Test(description="Ȩ�޹���",priority=1)
	public void test1() throws InterruptedException, IOException {
		// 2��4.1.1 ģ��Ȩ�޹���
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		String url_h=ReadProperties.getPropertyValue("url_h");
		Thread.sleep(2000);
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[1]/a");
		webtest.click("link=������ݷ���");
		
		webtest.click("name=role_module[13][]");	
		webtest.click("id=save-role-module-auth");
		
		//��ǰ̨���˳���¼
		webtest.open(Front_url);
		Thread.sleep(3000);
		webtest.mouseoverElement("link=root");
		webtest.click("class=os-icon-logout");
		
		webtest.click("xpath=//*[@id='nav_bar']/div/ul/li[4]/a/span[1]");
		assertTrue(webtest.isTextPresent("��ģ��δ�Էǵ�¼�û����š�"));
		
		webtest.open(url_h);
		webtest.type("name=username", "root");
		webtest.type("name=password", "root");
		webtest.click("xpath=//button[@type='submit']");
		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
		
		webtest.click("name=role_module[13][]");
		webtest.click("id=save-role-module-auth");
	}
	
	@Test(description="�Ǳ���",priority=2)
	public void test2() throws InterruptedException{
		// 2��4.1.2.1�Ǳ���
		webtest.click("link=��ҳ");
		assertTrue(webtest.isTextPresent("���ò���"));
	}
	
	@Test(description="����Ԥ��",priority=3)
	public void test3() throws InterruptedException{
		// 2��4.1.2.2���ݸ���
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[1]/a");
		webtest.click("link=���ݸ���");
		
		//���ͼ��
		webtest.click("class=icon-plus");
		webtest.click("xpath=//*[@id='portlet_list']/div[1]/a");
				
		//�鿴����
		webtest.click("link=�鿴����");
		webtest.click("link=��ϸ");
		webtest.click("xpath=//button[@class='btn btn-return']");
		webtest.click("link=ɾ��");
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("ȷ��Ҫִ�иò�����?", alert.getText());
		alert.accept();
	}
	
	
	@Test(description="������û�_��֤����",priority=4)
	public void test4() throws InterruptedException, IOException{
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[2]");
		WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[2]"));
		System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		
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
	
	
	@Test(description="������û�_�û�����",priority=5)
	public void test5() throws InterruptedException{
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[2]");
		WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[2]"));
		System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		
		webtest.click("link=�û���Ϣ");
		
		//����
		webtest.click("class=ajax-get");
		webtest.type("xpath=//input[@name='forbid_day']","1");
		webtest.click("xpath=//button[@class='btn btn-block btn-primary red-btn']");
		
		assertTrue(webtest.isTextPresent("��������"));
	}
	
	@Test(description="������û�_�û�����",priority=5)
	public void test5_1() throws InterruptedException{
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[2]");
		WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[2]"));
		System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		
		webtest.click("link=�û���Ϣ");
		
		//����
		webtest.click("class=ajax-get");
		webtest.type("xpath=//input[@name='forbid_day']","1");
		webtest.click("xpath=//button[@class='btn btn-block btn-primary red-btn']");
		
		assertTrue(webtest.isTextPresent("����"));
	}
	
	@Test(description="������û�_�û�ɾ��",priority=5)
	public void test5_2() throws InterruptedException{
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[2]");
		WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[2]"));
		System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		
		webtest.click("link=�û���Ϣ");
		
		//ɾ��
		Thread.sleep(3000);
		webtest.click("link=ɾ��");
		Thread.sleep(3000);
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("ȷ��Ҫִ�иò�����?", alert1.getText());
		alert1.dismiss();
		Thread.sleep(3000);
		
		assertTrue(webtest.isTextPresent("105"));
	}
	
	
	@Test(description="������û�_��������",priority=6)
	public void test6() throws InterruptedException, IOException{
		
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[2]");
		WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[2]"));
		System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		webtest.click("link=��������");
		
		webtest.click("id=id_REG_SWITCH_email");
		webtest.click("xpath=//*[@id='submit']");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		//ȫ��ѡע�Ὺ�ؼ�Ϊ�ر�ע��
		webtest.open(Front_url);
		webtest.mouseoverElement("link=root");
		webtest.click("class=os-icon-logout");
		webtest.click("link=ע��");
		assertTrue(webtest.isTextPresent("ע���ѹر�"));
		webtest.click("link=������ҳ");
		
		webtest.open(url_h);
		webtest.type("name=username", "root");
		webtest.type("name=password", "root");
		webtest.click("xpath=//button[@type='submit']");
		
		webtest.open("http://localhost:8585/index.php?s=/admin/user_config/index.html");
		webtest.click("id=id_REG_SWITCH_email");
		webtest.click("xpath=//*[@id='submit']");
		
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
	}
	
	@Test(description="������û�_��¼���� ��ݵ�¼",priority=7)
	public void test7() throws InterruptedException, IOException{
		
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[2]");
		WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[2]"));
		System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		
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
		webtest.open(Front_url);
		Thread.sleep(3000);
		webtest.mouseoverElement("link=root");
		webtest.click("class=os-icon-logout");
		webtest.click("link=��¼");
		assertTrue(webtest.isTextPresent("��ӭ�ص� OpenSNS v5��Դ��Ⱥϵͳ ��"));
				
	}
	
	@Test(description="������û�_��¼���� �����׺",priority=8)
	public void test8() throws InterruptedException, IOException{
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[2]");
		WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[2]"));
		System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		
		webtest.click("link=��������");
		
		//��¼����
		webtest.click("link=��¼����");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='main']/div/div[3]/div/div/form/div[2]/div[3]/input");
		WebElement input=driver.findElement(By.xpath("//*[@id='main']/div/div[3]/div/div/form/div[2]/div[3]/input"));
		input.clear();
		webtest.type("xpath=//*[@id='main']/div/div[3]/div/div/form/div[2]/div[3]/input","@163.com");
		webtest.click("id=submit");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		
		//�����û��б��޸ĵ�������¼�����׺��
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[2]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[2]"));
		System.out.println(textEle1.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown active open");
		System.out.println(textEle1.getAttribute("class"));//����ı��ǰ��ֵ
		
		webtest.click("link=�û���Ϣ");
		webtest.click("xpath=//*[@id='main']/div/div[4]/table/tbody/tr[1]/td[1]/input");
		
		webtest.click("xpath=//*[@id='main']/div/div[3]/div[1]/button[5]");
			
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
			
		//��ǰ̨,��¼
		webtest.open(Front_url);
		Thread.sleep(3000);
		webtest.mouseoverElement("link=root");
		webtest.click("class=os-icon-logout");
		webtest.click("link=��¼");
			
		//ԭ�˻�
		webtest.type("xpath=//input[@id='inputEmail']","123456@qq.com");
		webtest.type("xpath=//input[@type='password']","123456");
		webtest.click("xpath=//*[@id='triggerModal']/div[2]/div[2]/div[2]/form/div[4]/button");
		
		WebElement id=driver.findElement(By.xpath("//input[@id='inputEmail']"));
		id.clear();
		WebElement pw=driver.findElement(By.xpath("//input[@type='password']"));
		pw.clear();
		
		assertTrue(webtest.isTextPresent("��ҳ"));
		Thread.sleep(2000);
	}
	
	
	
	@Test(description="��Ӫ_��������",priority=9)
	public void test9() throws InterruptedException, IOException{
		
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown open");
		System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		
		//�����������
		webtest.click("link=��������");
		webtest.click("link=����");
		webtest.type("name=title","�ٶ�");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='tab1']/div[2]/div/label[2]/input");
		webtest.type("xpath=//input[@name='link']", "https://www.baidu.com/");
		webtest.click("xpath=//input[@type='submit']");
		
		//��ǰ̨
		webtest.open(Front_url);
		assertTrue(webtest.isTextPresent("�ٶ�"));
	}
	
	
	
	
	@Test(description="��Ӫ_�������·��",priority=10)
	public void test10() throws InterruptedException{
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown open");
		System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		
		//·��1
		webtest.click("link=�����б�");
		webtest.click("link=����");
		webtest.type("xpath=//input[@name='title']","���");
		webtest.type("xpath=//input[@name='link']","https://www.baidu.com/");
		
		//��������
		Thread.sleep(3000);
		WebElement frame=getDriver().findElement(By.id("ueditor_0"));
		getDriver().switchTo().frame(frame);
		webtest.click("tag=p");
		webtest.type("tag=body", "hello");
		getDriver().switchTo().defaultContent();
		
		webtest.click("id=id_is_force_0");
		webtest.click("xpath=//button[@type='submit']");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		assertTrue(webtest.isTextPresent("���"));
		
		//·��2
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//����ı��ǰ��ֵ
		
		//��������
		webtest.click("link=��������");
		webtest.type("xpath=//input[@name='title']","hello");
		webtest.type("xpath=//input[@name='link']","https://www.baidu.com/");
		
		//��������
		WebElement frame1=getDriver().findElement(By.id("ueditor_0"));
		getDriver().switchTo().frame(frame1);
		webtest.click("tag=p");
		webtest.type("tag=body", "hello");
		getDriver().switchTo().defaultContent();
		
		webtest.click("id=id_is_force_0");
		webtest.click("xpath=//button[@type='submit']");
		
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
		
		assertTrue(webtest.isTextPresent("hello"));
		
		
	}
	
	@Test(description="��Ӫ_��������_��Ч��Ϊ��ǰʱ��֮ǰ",priority=11)
	public void test11() throws InterruptedException, IOException{
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//����ı��ǰ��ֵ
		
		//��������
		webtest.click("link=��������");
		webtest.type("xpath=//input[@name='title']","��Ч��֮ǰ");
		webtest.type("xpath=//input[@name='link']","https://music.163.com/");
		
		
		//��������
		WebElement frame=getDriver().findElement(By.id("ueditor_0"));
		getDriver().switchTo().frame(frame);
		webtest.click("tag=p");
		webtest.type("tag=body", "hello");
		getDriver().switchTo().defaultContent();
		
		webtest.click("id=id_is_force_0");
		//��Ч��
		WebElement input=driver.findElement(By.xpath("//*[@id='main']/div/div[3]/div/div/form/div[8]/div/input"));
		input.clear();
		webtest.click("xpath=//*[@id='main']/div/div[3]/div/div/form/div[8]/div/input");
		webtest.type("xpath=//*[@id='main']/div/div[3]/div/div/form/div[8]/div/input","2019-11-24 04:20");
		
		webtest.click("xpath=//button[@type='submit']");
		
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
		
		//����ǰ̨�鿴����
		webtest.open(Front_url);
		webtest.click("xpath=/html/body/div[2]/div[3]/li[2]/a/i");
		Thread.sleep(3000);
		
		WebElement ele = driver.findElement(By.xpath("//*[@id='message_block_Common_announce']/div/ul/li[1]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("����"));
		
		webtest.switchWidow(1);
		webtest.closeTab();
	}
	
	
	@Test(description="��Ӫ_��������_��Ч��Ϊ��ǰʱ��֮��",priority=12)
	public void test12() throws InterruptedException, IOException{
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//����ı��ǰ��ֵ
		
		//��������
		webtest.click("link=��������");
		webtest.type("xpath=//input[@name='title']","��Ч��֮��");
		webtest.type("xpath=//input[@name='link']","https://music.163.com/");
		
		//��������
		WebElement frame=getDriver().findElement(By.id("ueditor_0"));
		getDriver().switchTo().frame(frame);
		webtest.click("tag=p");
		webtest.type("tag=body", "hello");
		getDriver().switchTo().defaultContent();
		
		webtest.click("id=id_is_force_0");
		//��Ч��
		WebElement input=driver.findElement(By.xpath("//*[@id='main']/div/div[3]/div/div/form/div[8]/div/input"));
		input.clear();
		webtest.click("xpath=//*[@id='main']/div/div[3]/div/div/form/div[8]/div/input");
		webtest.type("xpath=//*[@id='main']/div/div[3]/div/div/form/div[8]/div/input","2019-12-30 04:20");
		
		webtest.click("xpath=//button[@type='submit']");
		
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
		
		//����ǰ̨�鿴����
		webtest.open(Front_url);
		webtest.click("xpath=/html/body/div[2]/div[3]/li[2]/a/i");
		Thread.sleep(3000);
		
		WebElement ele = driver.findElement(By.xpath("//*[@id='message_block_Common_announce']/div/ul/li[1]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("����"));
		
		webtest.switchWidow(1);
		webtest.closeTab();
		
	}
	
	
	@Test(description="��Ӫ_��������_����Ϊwww��ͷ",priority=13)
	public void test13() throws InterruptedException, IOException{
		
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//����ı��ǰ��ֵ
		
		//��������
		webtest.click("link=��������");
		webtest.type("xpath=//input[@name='title']","������www��ͷ");
		webtest.type("xpath=//input[@name='link']","www.baidu.com");
		
		//����
		WebElement frame=getDriver().findElement(By.id("ueditor_0"));
		getDriver().switchTo().frame(frame);
		webtest.click("tag=p");
		webtest.type("tag=body", "hello");
		getDriver().switchTo().defaultContent();
		
		webtest.click("id=id_is_force_0");
		webtest.click("xpath=//button[@type='submit']");
		
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
		
		//����ǰ̨�鿴����
		webtest.open(Front_url);
		webtest.click("xpath=/html/body/div[2]/div[3]/li[2]/a/i");
		Thread.sleep(3000);
		
		WebElement ele = driver.findElement(By.xpath("//*[@id='message_block_Common_announce']/div/ul/li[1]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("�Ƿ�����:www.baidu.com"));
		
		webtest.switchWidow(1);
		webtest.closeTab();
	}
	
	@Test(description="��Ӫ_��������_����Ϊ������������",priority=14)
	public void test14() throws InterruptedException, IOException{
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//����ı��ǰ��ֵ
		
		//��������
		webtest.click("link=��������");
		webtest.type("xpath=//input[@name='title']","���Ӳ�����������");
		webtest.type("xpath=//input[@name='link']","www.baidu");
		
		//��������
		WebElement frame=getDriver().findElement(By.id("ueditor_0"));
		getDriver().switchTo().frame(frame);
		webtest.click("tag=p");
		webtest.type("tag=body", "hello");
		getDriver().switchTo().defaultContent();
		
		webtest.click("id=id_is_force_0");
		
		webtest.click("xpath=//button[@type='submit']");
		
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
		
		//����ǰ̨�鿴����
		webtest.open(Front_url);
		webtest.click("xpath=/html/body/div[2]/div[3]/li[2]/a/i");
		Thread.sleep(3000);
		
		WebElement ele = driver.findElement(By.xpath("//*[@id='message_block_Common_announce']/div/ul/li[1]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("�Ƿ�����:www.baidu"));
		
	}
	
	
	@Test(description="��Ӫ_��������_����Ϊվ������",priority=15)
	public void test15() throws InterruptedException, IOException{
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//����ı��ǰ��ֵ
		
		//��������
		webtest.click("link=��������");
		webtest.type("xpath=//input[@name='title']","����Ϊվ������");
		webtest.type("xpath=//input[@name='link']","http://localhost:8585/index.php?s=/people/index/index.html");
		
		//��������
		WebElement frame=getDriver().findElement(By.id("ueditor_0"));
		getDriver().switchTo().frame(frame);
		webtest.click("tag=p");
		webtest.type("tag=body", "hello");
		getDriver().switchTo().defaultContent();
		
		webtest.click("id=id_is_force_0");
		webtest.click("xpath=//button[@type='submit']");
		
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
		
		//����ǰ̨�鿴����
		webtest.open(Front_url);
		webtest.click("xpath=/html/body/div[2]/div[3]/li[2]/a/i");
		Thread.sleep(3000);
		
		WebElement ele = driver.findElement(By.xpath("//*[@id='message_block_Common_announce']/div/ul/li[1]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("��Աչʾ"));
		
		webtest.switchWidow(1);
		webtest.closeTab();
	}
	
	
	@Test(description="��Ӫ_��������_����",priority=16)
	public void test16() throws InterruptedException, IOException{
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//����ı��ǰ��ֵ
		
		//��������
		webtest.click("link=��������");
		webtest.type("xpath=//input[@name='title']","����");
		webtest.type("xpath=//input[@name='link']","http://localhost:8585/index.php?s=/people/index/index.html");
		
		//��������
		WebElement frame=getDriver().findElement(By.id("ueditor_0"));
		getDriver().switchTo().frame(frame);
		webtest.click("tag=p");
		webtest.type("tag=body", "hello");
		getDriver().switchTo().defaultContent();
		
		webtest.click("id=id_is_force_0");
		//����
		Select se1 = new Select(driver.findElement(By.name("status")));
		se1.selectByValue("0");
		
		webtest.click("xpath=//button[@type='submit']");
		
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
		
		//����ǰ̨�鿴����
		webtest.open(Front_url);
		webtest.click("xpath=/html/body/div[2]/div[3]/li[2]/a/i");
		
		WebElement ele = driver.findElement(By.xpath("//*[@id='message_block_Common_announce']/div/ul/li[1]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
	}
	
	
	@Test(dataProvider = "d16",description="��Ӫ_�����б�_ɸѡ",priority=17)
	public void test17(String p1,String p2) throws InterruptedException{
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//����ı��ǰ��ֵ
		
		webtest.click("link=�����б�");
		
		Thread.sleep(3000);
		//��Select��ʽ ���������
		Select se1 = new Select(driver.findElement(By.xpath("//*[@id='selectForm']/div[1]/div[2]/select")));
		se1.selectByValue(p1);
		Thread.sleep(3000);
		Select se2 = new Select(driver.findElement(By.xpath("//*[@id='selectForm']/div[2]/div[2]/select")));
		se2.selectByValue(p2);
		Thread.sleep(3000);
		
	}
	
	
	@Test(description="��Ӫ_�����б�_ȫ��ɾ��",priority=24)
	public void test24() throws InterruptedException{
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//����ı��ǰ��ֵ
		
		webtest.click("link=�����б�");
		webtest.click("xpath=//input[@type='checkbox']");
		webtest.click("xpath=//button[@class='btn ajax-post btn-danger btn btn-default']");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert1.getText());
		alert1.dismiss();
		Thread.sleep(3000);
	}
	
	@Test(description="��Ӫ_�����б�_����ɾ��",priority=25)
	public void test25() throws InterruptedException{
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//����ı��ǰ��ֵ
		
		webtest.click("link=�����б�");
		webtest.click("xpath=//input[@class='ids']");
		webtest.click("xpath=//button[@class='btn ajax-post btn-danger btn btn-default']");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
	}
	
	
	
	@Test(description="��Ӫ_���д�����",priority=30)
	public void test30() throws InterruptedException{
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//����ı��ǰ��ֵ
		
		webtest.click("link=���д�����");
		webtest.click("id=id_OPEN_SENSITIVE_1");
		webtest.click("id=submit");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
	}
	
	
	@Test(description="��Ӫ_���д�����",priority=36)
	public void test36() throws InterruptedException, IOException{
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//����ı��ǰ��ֵ
		
		webtest.click("link=���д��б�");
		webtest.click("link=����");
		webtest.type("xpath=//input[@type='text']","���");
		webtest.click("id=submit");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		//��ǰ̨ ��΢��
		webtest.open("http://localhost:8585/index.php?s=/weibo/index/index.html");
		webtest.click("class=add-weibo");
		webtest.click("class=icon-zs");
		webtest.click("id=weibo_content");
		webtest.type("id=weibo_content","���");
		webtest.click("xpath=//*[@id='send_box']/div/div[3]/div[2]/a[1]/i");
		assertTrue(webtest.isTextPresent("***"));
		
	}
	
	@Test(description="��Ӫ_���дʽ���",priority=40)
	public void test40() throws InterruptedException{
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//����ı��ǰ��ֵ
		
		webtest.click("link=���д��б�");
		webtest.click("link=����");
		webtest.type("xpath=//input[@type='text']","����");
		
		Select se1 = new Select(driver.findElement(By.xpath("//*[@id='main']/div/div[3]/div/div/form/div[3]/select")));
		se1.selectByValue("-1");
		webtest.click("id=submit");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		//��ǰ̨ ��΢��
		webtest.open("http://localhost:8585/index.php?s=/weibo/index/index.html");
		webtest.click("class=add-weibo");
		//webtest.click("class=icon-zs");
		webtest.click("id=weibo_content");
		webtest.type("id=weibo_content","����");
		webtest.click("xpath=//*[@id='send_box']/div/div[3]/div[2]/a[1]/i");
		assertTrue(webtest.isTextPresent("����"));
		
	}
	
	
	@Test(dataProvider = "d23",description="��Ӫ_�������д�",priority=41)
	public void test41(String p1,String p2) throws InterruptedException{
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//����ı��ǰ��ֵ
		
		webtest.click("link=���д��б�");
		webtest.click("link=����");
		webtest.type("xpath=//input[@type='text']",p1);
		webtest.click("id=submit");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		//��ǰ̨ ��΢��
		webtest.open("http://localhost:8585/index.php?s=/weibo/index/index.html");
		webtest.click("class=add-weibo");
		//webtest.click("class=icon-zs");
		webtest.click("id=weibo_content");
		webtest.type("id=weibo_content",p2);
		webtest.click("xpath=//*[@id='send_box']/div/div[3]/div[2]/a[1]/i");
	}
	
	@Test(dataProvider = "d24",description="��Ӫ_���д���������",priority=42)
	public void test42(String p1) throws InterruptedException{
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//����ı�֮ǰ��ֵ
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//����ı��ǰ��ֵ
		
		webtest.click("link=�������");
		webtest.click("name=titles");
		webtest.type("xpath=//input[@type='text']",p1);
		webtest.click("id=submit");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
	}
	
	
	
	
}