package com.opensns.backstage;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

/**
 * @author ������
 * ��̨��ϵͳ����չ��ģ������������
 */
@Listeners(com.webtest.core.WebTestListener.class)
public class BackStage1 extends BaseTest {

	@BeforeClass
	public void Login() throws IOException, InterruptedException{
		 String admin_login = ReadProperties.getPropertyValue("url_h");
			webtest.open(admin_login);
			webtest.type("name=username", "root");
			webtest.type("name=password", "123456");
			webtest.click("class=login-btn");
			Thread.sleep(3000);
	}
	//����ˢ�²���
	@Test(description = "��Ϣ����-�Ự�б�",priority=1)
	public void test1() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		// �Ự�б�
		webtest.click("link=�Ự�б�");
		// ˢ�°�ť
		webtest.click("xpath=//*[@id='main']/div/div[4]/div/button");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		alert.accept();// ���ȷ��
	    assertTrue(webtest.isTextPresent("�Ự�����б�"));
		Thread.sleep(5000);
	}

	@Test(description = "��Ϣ����-�Ựģ��",priority=2)
	public void test2() throws InterruptedException {
		 webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
	     System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
	     System.out.println(textEle.getAttribute("data-id"));//����ı�֮ǰ��ֵ
	     String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
	     ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
	     System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		 webtest.click("link=�Ựģ��");
		 webtest.click("xpath=//*[@id='main']/div/div[4]/div/button");//ˢ�²���
		 Alert alert = driver.switchTo().alert();
		 Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		 alert.accept();// ���ȷ��
		 Thread.sleep(5000);
	     assertTrue(webtest.isTextPresent("��Ϣģ���б�"));

	}

	@Test(description = "��Ϣ����-�Ự����",priority=3)
	public void test3() throws InterruptedException {
		 webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
        String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
        ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
        System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		webtest.click("link=�Ự����");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Select select = new Select(
				driver.findElement(By.xpath("//*[@id='main']/div/div[3]/div/div/form/div[1]/select")));
		select.selectByIndex(2);
		webtest.click("id=submit");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("�Ự�б�ģ��  "));
		Thread.sleep(5000);
	}
	
	@DataProvider(name = "information")
	public Object[][] createNews() throws IOException {
		ExcelDataProvider edp = new ExcelDataProvider();
		return edp.getTestDataByExcel("data/liumeining/liu.xlsx","Sheet2");// Ҫ���Ե��ĵ�
	}
	@Test(dataProvider="information",description = "��Ϣ����-��Ϣģ��",priority=4)
	public void test4567(String title, String sort) throws InterruptedException {
	   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		webtest.click("link=��Ϣģ��");
		webtest.click("link=���ģ��");
		webtest.type("xpath=//*[@id='main']/div/div[3]/div/div/form/div[1]/input", title);
		webtest.type("xpath=//*[@id='main']/div/div[3]/div/div/form/div[2]/input", sort);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Select select = new Select(driver.findElement(By.name("status")));
		select.selectByIndex(2);
		webtest.click("xpath=//*[@id='submit']");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("��Ϣģ��"));
		webtest.click("xpath=//*[@id='main']/div/div[3]/div/div/form/div[7]/button[2]");
		assertTrue(webtest.isTextPresent(title));
		Thread.sleep(5000);
		//������<script>alert("123")</script>ʱ����ӳɹ��������¼�ֻ��ʾalert("123")
	}

	@Test(description = "�û�����",priority=5)
	public void test8() throws InterruptedException, IOException {
	   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
	   webtest.click("link=��վ����");
	   webtest.click("link=�û�����");
	   webtest.type("name=config[USER_NAME_BAOLIU]", ",lmn");
	   webtest.click("xpath=//*[@id='main']/div/div[4]/div/form/div[3]/div/button[1]");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		alert.accept();
		webtest.open(ReadProperties.getPropertyValue("front_url"));


		if (!webtest.isElementPresent("link=admin")) {
			webtest.click("link=ע��");
			webtest.type("id=email", "1239@qq.com");
			webtest.type("id=nickname", "lmn0");
			webtest.type("id=inputPassword", "lmn123");
			Thread.sleep(3000);
			//����JavascriptExecutorֱ����Ԫ���Ϸ��͵�����
			WebElement ele = driver.findElement(By.xpath("/html/body/div[2]/div[1]/form/div/button"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
			Thread.sleep(3000);
			assertTrue(webtest.isTextPresent("�ǳƱ���ֹע��"));
			
		} else {
			webtest.mouseoverElement("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
			webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
			webtest.click("link=ע��");
			webtest.type("id=email", "1239@qq.com");
			webtest.type("id=nickname", "lmn0");
			webtest.type("id=inputPassword", "lmn123");
			Thread.sleep(3000);
			//����JavascriptExecutorֱ����Ԫ���Ϸ��͵�����
			WebElement ele = driver.findElement(By.xpath("/html/body/div[2]/div[1]/form/div/button"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
			assertTrue(webtest.isTextPresent("�ǳƱ���ֹע��"));
			
		}
	}
	@Test(description = "��������",priority=6)
	public void test9() throws InterruptedException{
	  webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	  WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
      System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
      System.out.println(textEle.getAttribute("data-id"));//����ı�֮ǰ��ֵ
      String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
      ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
      System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
	  webtest.click("link=��վ����");
	  webtest.click("link=��������");
	  assertTrue(webtest.isTextPresent("��¼ǰ��ҳUrl"));
	}
	@Test(description = "��������",priority=7)
	public void test10() throws InterruptedException{
	  webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	  WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
      System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
      System.out.println(textEle.getAttribute("data-id"));//����ı�֮ǰ��ֵ
      String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
      ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
      System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
	  webtest.click("link=��վ����");
	  webtest.click("link=��������");
	  assertTrue(webtest.isTextPresent("�հ�˵��"));
	}
	@Test(description = "ϵͳ����",priority=8)
	public void test11() throws InterruptedException{
	  webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	  WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
      System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
      System.out.println(textEle.getAttribute("data-id"));//����ı�֮ǰ��ֵ
      String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
      ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
      System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
	  webtest.click("link=��վ����");
      webtest.click("link=ϵͳ����");
      assertTrue(webtest.isTextPresent("ͼƬ�ļ������Ŀ¼"));
	}
	@Test(description = "�ʼ�����",priority=9)
	public void test12() throws InterruptedException{
	  webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	  WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
      System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
      System.out.println(textEle.getAttribute("data-id"));//����ı�֮ǰ��ֵ
      String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
      ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
      System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
	  webtest.click("link=��վ����");
	  webtest.click("link=�ʼ�����");
	  assertTrue(webtest.isTextPresent("�ʼ�����"));
	}
	@Test(description = "��վ��Ϣ-������Ϣ",priority=10)
	public void test13() throws InterruptedException {
	   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
       System.out.println(textEle.getAttribute("data-id"));//����ı�֮ǰ��ֵ
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		webtest.click("link=��վ��Ϣ");
		webtest.click("link=������Ϣ");
		webtest.type("name=WEB_SITE_NAME", "123");
		webtest.click("xpath=//*[@id='submit']");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("��վ��    "));
		Thread.sleep(5000);
	}
	@Test(description = "��վ��Ϣ-ҳ����Ϣ",priority=11)
	public void test14() throws InterruptedException {
	   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
       System.out.println(textEle.getAttribute("data-id"));//����ı�֮ǰ��ֵ
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		webtest.click("link=��վ��Ϣ");
		webtest.click("link=ҳ����Ϣ");
		driver.switchTo().frame("ueditor_0");
		driver.findElement(By.xpath("/html/body")).click();
		WebElement text = driver.findElement(By.xpath("/html/body"));
		text.sendKeys("ҳ����Ϣ����");
		driver.switchTo().defaultContent();// ����frame
		webtest.click("xpath=//*[@id='submit']");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("��վ��    "));
		Thread.sleep(5000);
	}
	@Test(description = "��վ��Ϣ-��תҳ��",priority=12)
	public void test15() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
       System.out.println(textEle.getAttribute("data-id"));//����ı�֮ǰ��ֵ
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		webtest.click("link=��վ��Ϣ");
		webtest.click("link=��תҳ��");
		WebElement success_element = driver.findElement(By.name("SUCCESS_WAIT_TIME"));
		success_element.clear();
		success_element.sendKeys("2");
		WebElement fail_element = driver.findElement(By.name("ERROR_WAIT_TIME"));
		fail_element.clear();
		fail_element.sendKeys("5");
		webtest.click("xpath=//*[@id='submit']");////*[@id="submit"]
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("��վ��    "));
		Thread.sleep(5000);
	}

	@Test(description = "��վ��Ϣ-��������",priority=13)
	public void test16() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
       System.out.println(textEle.getAttribute("data-id"));//����ı�֮ǰ��ֵ
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		webtest.click("link=��վ��Ϣ");
		webtest.click("link=��������");
		WebElement data_time = driver.findElement(By.name("GET_INFORMATION_INTERNAL"));
		data_time.clear();
		data_time.sendKeys("10");
		webtest.click("xpath=//*[@id='submit']");////*[@id="submit"]
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("��վ��    "));
		Thread.sleep(5000);
	}

	@Test(description = "��վ��Ϣ-�ϴ�����",priority=14)
	public void test17() throws InterruptedException {
	   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
       System.out.println(textEle.getAttribute("data-id"));//����ı�֮ǰ��ֵ
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
	   webtest.click("link=��վ��Ϣ");
	   webtest.click("link=�ϴ�����");
	   assertTrue(webtest.isTextPresent("ͼƬ�ϴ�����    "));
	   Thread.sleep(5000);
	}
	@Test(description = "��վ��Ϣ-��������",priority=15)
	public void test18() throws InterruptedException {
	   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
       System.out.println(textEle.getAttribute("data-id"));//����ı�֮ǰ��ֵ
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
	   webtest.click("link=��վ��Ϣ");
	   webtest.click("link=��������");
	   assertTrue(webtest.isTextPresent("WebSocket��ַ    "));
	   Thread.sleep(5000);
	}
	
	@DataProvider(name = "add")
	public Object[][] createAdd() throws IOException {
		ExcelDataProvider edp = new ExcelDataProvider();
		return edp.getTestDataByExcel("data/liumeining/liu.xlsx","Sheet3");// Ҫ���Ե��ĵ�
	}
	@Test(dataProvider="add",description = "���ù�����Ӳ���",priority=16)
	public void test1920212223(String sign,String title) throws InterruptedException {
	   Thread.sleep(3000);
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		webtest.click("link=���ù���");
		webtest.click("link=�� ��");
		webtest.type("xpath=//*[@id='main']/div/div[2]/form/div[1]/div/input", sign);
		webtest.type("xpath=//*[@id='main']/div/div[2]/form/div[2]/div/input", title);
		webtest.click("xpath=//*[@id='submit']");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		alert.accept();
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent(title));
		Thread.sleep(2000);
	}

	@Test(description = "�û��������",priority=17)
	public void test24() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		webtest.click("link=�û�����");
		// ���һ������
		webtest.click("xpath=//*[@id='main']/div/div[3]/form/ul/li[1]/div[5]/a[1]/i");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Select select = new Select(driver.findElement(By.name("nav[1][module][]")));
		select.selectByIndex(2);
		WebElement element = driver.findElement(By.xpath("//*[@id='main']/div/div[3]/form/ul/li[2]/div[1]/input[1]"));
		element.clear();
		element.sendKeys("�û�һ����������");
		webtest.click("xpath=//*[@id='submit']");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("��վ��ҳ"));
		Thread.sleep(5000);

	}

	@Test(description = "�����������",priority=18)
	public void test25() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		webtest.click("link=��������");
		// ���һ������
		webtest.click("xpath=//*[@id='main']/div/div[3]/form/ul/li[1]/div[5]/a[1]/i");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Select select = new Select(driver.findElement(By.name("nav[1][module][]")));
		select.selectByIndex(2);
		WebElement element = driver.findElement(By.xpath("//*[@id='main']/div/div[3]/form/ul/li[2]/div[1]/input[1]"));
		element.clear();
		element.sendKeys("һ������");
		webtest.click("xpath=//*[@id='submit']");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("һ������"));
		

	}

	@Test(description = "�����������ӵ�������",priority=19)
	public void test26() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		webtest.click("link=��������");
		webtest.click("xpath=//*[@id='main']/div/div[3]/form/ul/li[3]/div[5]/a[3]/i");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Select select = new Select(driver.findElement(By.name("nav[2][module][]")));
		select.selectByIndex(2);
		WebElement element = driver.findElement(By.name("nav[2][title][]"));
		element.clear();
		element.sendKeys("�ӵ�������");
		webtest.click("xpath=//*[@id='submit']");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("�ӵ�������"));
		Thread.sleep(2000);

	}

	@Test(description = "Ⱥ����Ϣ",priority=20)
	public void test27() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//����ı�֮ǰ��ֵ
       System.out.println(textEle.getAttribute("data-id"));//����ı�֮ǰ��ֵ
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
		webtest.click("link=Ⱥ����Ϣ�û��б�");
		webtest.click("xpath=//*[@id='main']/div/div[4]/div/button[2]");
		webtest.type("xpath=//*[@id='migration']/div[3]/input", "Ⱥ����Ϣ");
		// webtest.type("xpath=/html/body","Ⱥ����Ϣ");
		driver.switchTo().frame("ueditor_0");
		driver.findElement(By.xpath("/html/body")).click();
		WebElement text = driver.findElement(By.xpath("/html/body"));
		text.sendKeys("Ⱥ����Ϣ");
		driver.switchTo().defaultContent();// ����frame
		webtest.click("xpath=//*[@id='migration']/div[6]/a[1]");
		assertTrue(webtest.isTextPresent("Ⱥ���û��б�"));
		Thread.sleep(5000);
	}

	@Test(description = "�ƻ�����",priority=21)
	public void test28() throws InterruptedException {
	   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//����ı��ǰ��ֵ
	   webtest.click("link=�ƻ������б�");
	   if (webtest.isElementPresent("link=Stop��������У�")) {
			webtest.click("xpath=//*[@id='main']/div/div[4]/div/a[1]");
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("ȷ�ϸò�����", alert.getText());
			alert.accept();
			assertTrue(webtest.isTextPresent("Running �����ֹͣ��"));
			Thread.sleep(5000);

		} else {
			webtest.click("link=Running �����ֹͣ��");
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("ȷ�ϸò�����", alert.getText());
			alert.accept();
//			assertTrue(webtest.isTextPresent("Stop��������У�"));
			Thread.sleep(5000);
		}
	   
	}
	@Test(description="�༭������",priority=22)
	public void test29() throws InterruptedException{
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");//������ϵͳ��
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=�༭������");
		   assertTrue(webtest.isTextPresent("�༭��Ĭ������"));
		   Thread.sleep(1000);
		   
	}
	@Test(description="MarkDown����",priority=23)
	public void test30() throws InterruptedException{
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");//������ϵͳ��
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=MarkDown����");
		   assertTrue(webtest.isTextPresent("�༭��Ĭ������"));
		   Thread.sleep(1000);
		   
	}
	//�������ݿ�
	@Test(description="�������ݿ�",priority=24)
	public void test31() throws InterruptedException{
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");//������ϵͳ��
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=�������ݿ�");
		   webtest.click("link=��������");
		   assertTrue(webtest.isTextPresent("�ѱ���"));
		   Thread.sleep(1000);
	}
	//��ԭ���ݿ�
	@Test(description="��ԭ���ݿ�",priority=25)
	public void test32() throws InterruptedException{
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");//������ϵͳ��
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=��ԭ���ݿ�");
		   assertTrue(webtest.isTextPresent("���ݱ���"));
		   Thread.sleep(1000);
	}
	@Test(description="��չ-���г�-��װ���",priority=26)//
	public void test33() throws InterruptedException{
		   webtest.mouseoverElement("link=��չ");//��������չ��
		   WebElement textEle=driver.findElement(By.linkText("��չ"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown open");
		   webtest.click("xpath=/html/body/header/nav/div/ul[1]/li[5]/ul/li/div/div/div[1]/ul/li[2]/a");//������г�
		   //[ ע�� ]
		   if(webtest.isElementPresent("link=[ ע�� ]")){
			   //webtest.mouseoverElement("xpath=/html/body/div[4]/div/ul/li[2]/ul/li[1]/a");
			   WebElement type_class=driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[2]/ul/li[1]/a"));
			   Actions action = new Actions(driver);
			   action.moveToElement(type_class).click().perform();
			   
			   WebElement load = driver.findElement(By.linkText("���"));
			   JavascriptExecutor executor = (JavascriptExecutor)driver;
			   executor.executeScript("arguments[0].click();", load);
			   webtest.click("link=���");
			   webtest.click("link=��Ҷ��������������");
			   webtest.click("class=button-buy");
			   webtest.click("class=btn btn-primary");
			   
		   }else{
			   Thread.sleep(5000);
			   WebElement login=driver.findElement(By.xpath("/html/body/div[1]/div/div/a[1]"));
			   Actions action = new Actions(driver);
			   action.moveToElement(login).click();
			   webtest.type("name=username","admin");
			   webtest.type("name=password", "123456");
			   webtest .click("class=btn btn-block btn-primary green-btn");
			   WebElement type_class=driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[2]/ul/li[1]/a"));
			   Actions action1 = new Actions(driver);
			   action.moveToElement(type_class).click().perform();
			   WebElement load = driver.findElement(By.linkText("���"));
			   JavascriptExecutor executor = (JavascriptExecutor)driver;
			   executor.executeScript("arguments[0].click();", load);
			   webtest.click("link=���");
			   webtest.click("link=��Ҷ��������������");
			   webtest.click("class=button-buy");
			   webtest.click("class=btn btn-primary");			   
		   }
		   Thread.sleep(1000);
	}
	@Test(description="���г�-�Զ�����",priority=27)
	public void test34() throws InterruptedException{
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[5]/a");//��������չ��
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[5]/a"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=�Զ�����");
		   webtest.click("link= ���¼��");
		   assertTrue(webtest.isTextPresent("�Զ�����"));
		   
	}
	
	@Test(description="�������-��װ���",priority=28)
	public void test35() throws InterruptedException{
		Thread.sleep(5000);
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[5]/a");//��������չ��
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[5]/a"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=�������");
		   webtest.click("link=δ��װ");
		   webtest.click("xpath=//*[@id='main']/div/div[4]/div/div/div/div[1]/div/div[5]/div/a");
		   webtest.click("link=δ��װ");
		   assertTrue(!webtest.isTextPresent("�ɸ�"));
	}
	@Test(description="�������-ж��",priority=29)
	public void test36() throws InterruptedException{
		Thread.sleep(5000);
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[5]/a");//��������չ��
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[5]/a"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=�������");
		   webtest.click("xpath=//*[@id='main']/div/div[4]/div/div/div/div[3]/div/div[5]/div/a[3]");//ж�������Ĳ��
		   webtest.click("link=�Ѱ�װ");
		 //*[@id="main"]/div/div[4]/div/div/div/div[4]/div/div[5]/div/a[3]
		   Thread.sleep(3000);
		   assertTrue(!webtest.isTextPresent("�ɸ�"));
	}
	
	@Test(description="ģ�����-��װ�",priority=30)
	public void test38() throws InterruptedException{
		  Thread.sleep(3000);
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[5]/a");//��������չ��
		     WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[5]/a"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=ģ�����");
		   webtest.click("link=δ��װ");
		   webtest.click("xpath=//*[@id='main']/div/div[3]/div/ul/li/div[2]/div[3]/div[1]/a[2]");
		   webtest.click("xpath=//*[@id='submit']");
		   Alert alert = driver.switchTo().alert();
		   Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		   alert.accept();
		   webtest.click("link=�Ѱ�װ");
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent("�"));
		   Thread.sleep(3000);
	}
	@Test(description="ģ�����-ж�ػ",priority=31)
	public void test39() throws InterruptedException{
		 Thread.sleep(3000);
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[5]/a");//��������չ��
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[5]/a"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=ģ�����");
		   webtest.click("xpath=//*[@id='main']/div/div[3]/div/ul/li[1]/div[2]/div[3]/div[1]/a[2]");
		   webtest.click("xpath=//*[@id='submit']");
		   Alert alert = driver.switchTo().alert();
		   Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		   alert.accept();
		   webtest.click("link=δ��װ");
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent("�"));

	}
	
	@Test(description="�������-������",priority=32)
	public void test40() throws InterruptedException{
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[5]/a");//��������չ��
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[5]/a"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=�������");
		   webtest.click("link=  ���̼�����");
		   assertTrue(webtest.isTextPresent("��װ������"));
		   
	}
	@DataProvider(name = "cooperation")
	public Object[][] createData() throws IOException {
		ExcelDataProvider edp = new ExcelDataProvider();
		return edp.getTestDataByExcel("data/liumeining/liu.xlsx","Sheet1");// Ҫ���Ե��ĵ�
	}
	
	@Test(dataProvider="cooperation",description="������λ",priority=33)
	public void test414344(String title,String link) throws InterruptedException{
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[5]/a");//��������չ��
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[5]/a"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//�ı����Ե�js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=������λ");
		   webtest.click("link=�� ��");
		   webtest.type("name=title", title);
		   webtest.type("name=link", link);
		   webtest.click("xpath=//*[@id='form']/div[2]/input[1]");//���ȷ��  link=ȷ��
		   //�ı���������<script>alert('ceshi')</script>�����ȷ����������ʾ�򣬷���վ�����Ʋ���ʾ����
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent(title));
	}
	
	
	@Test(description="��̳����",priority=34)
	public void test45() throws InterruptedException{
		   webtest.click("xpath=//*[@id='treeforum']/a");
		   webtest.click("xpath=//*[@id='treeforum']/ul/li[2]/a");
		   webtest.click("link=����");
		   webtest.type("name=title", "��̳����");
		   WebElement sort =driver.findElement(By.name("sort"));
		   sort.clear();
		   sort.sendKeys("1");
		   //webtest.type("name=sort", "1");
		   webtest.click("xpath=//*[@id='submit']");//*[@id="submit"]
		   Alert alert = driver.switchTo().alert();
		   Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		   alert.accept();
//		   Thread.sleep(1000);
		   webtest.click("xpath=//*[@id='main']/div/div[3]/div/div/form/div[5]/button[2]");
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent("��̳����"));
		   
	}
	
	@DataProvider(name = "plate")
	public Object[][] addPlate() throws IOException {
		ExcelDataProvider edp = new ExcelDataProvider();
		return edp.getTestDataByExcel("data/liumeining/liu.xlsx","Sheet4");// Ҫ���Ե��ĵ�
	}
	@Test(dataProvider="plate",description="������-���",priority=35)
	public void test46474849505152(String title,String admin) throws InterruptedException{
		Thread.sleep(3000);
		   webtest.click("xpath=//*[@id='treeforum']/a");
		   webtest.click("link=������");
		   webtest.click("link=����");
		   webtest.type("name=title", title);
		   webtest.type("name=admin", admin);
		   WebElement submit = driver.findElement(By.xpath("//*[@id='submit']"));
		   JavascriptExecutor executor = (JavascriptExecutor)driver;
		   executor.executeScript("arguments[0].click();", submit);
		   Alert alert = driver.switchTo().alert();
		   Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		   alert.accept();
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent(title));
		
	}
	
	@Test(description="����-��������1",priority=36)
	public void test53() throws InterruptedException{
		   webtest.click("xpath=//*[@id='treepeople']/a");
		   webtest.click("link=��������");
		   webtest.type("name=MAX_SHOW_HEIGHT", "160");
		   webtest.click("xpath=//*[@id='submit']");
		   Alert alert = driver.switchTo().alert();
		   Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		   alert.accept();
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent("��ǩ����ʼ���չʾ�߶� "));
		  
	}
	//����ҳ���ϲ�չʾ
	@Test(description="����-��������2",priority=37)
	public void test54() throws InterruptedException{
		   webtest.click("xpath=//*[@id='treepeople']/a");
		   webtest.click("link=��������");
		   webtest.click("link=����ҳ���ϲ�չʾ");
		   WebElement title = driver.findElement(By.name("USER_SHOW_TITLE0"));
		   title.clear();
		   webtest.type("name=USER_SHOW_TITLE0", "����Ҳ��ע");
		   WebElement people = driver.findElement(By.name("USER_SHOW_COUNT0"));
		   people.clear();
		   webtest.type("name=USER_SHOW_COUNT0","4");
		   webtest.click("xpath=//*[@id='submit']");//���ȷ��
		   Alert alert = driver.switchTo().alert();
		   Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		   alert.accept();
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent("��ǩ����ʼ���չʾ�߶� "));
		  
	}
	
	@Test(description="����-��������3",priority=38)
	public void test55() throws InterruptedException{
		   webtest.click("xpath=//*[@id='treepeople']/a");
		   webtest.click("link=��������");
		   webtest.click("link=����ҳ���²�չʾ");
		   WebElement title = driver.findElement(By.name("USER_SHOW_TITLE3"));
		   title.clear();
		   webtest.type("name=USER_SHOW_TITLE3", "����Ƽ���ע");
		   WebElement people = driver.findElement(By.name("USER_SHOW_COUNT3"));
		   people.clear();
		   webtest.type("name=USER_SHOW_COUNT3","4");
		   webtest.click("xpath=//*[@id='submit']");//���ȷ��
		   Alert alert = driver.switchTo().alert();
		   Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		   alert.accept();
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent("��ǩ����ʼ���չʾ�߶� "));
		  
	}
	
	//��ҳչʾ�����
	
	@Test(description="����-��������4",priority=39)
	public void test56() throws InterruptedException{
		   webtest.click("xpath=//*[@id='treepeople']/a");
		   webtest.click("link=��������");
		   webtest.click("link=��ҳչʾ�����");
		   WebElement title = driver.findElement(By.name("USER_SHOW_TITLE1"));
		   title.clear();
		   webtest.type("name=USER_SHOW_TITLE1", "��Ծ��Ա");
		   WebElement people = driver.findElement(By.name("USER_SHOW_COUNT1"));
		   people.clear();
		   webtest.type("name=USER_SHOW_COUNT1","5");
		   webtest.click("xpath=//*[@id='submit']");//���ȷ��
		   Alert alert = driver.switchTo().alert();
		   Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		   alert.accept();
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent("��ǩ����ʼ���չʾ�߶� "));
		   
	}
	
	//��ҳչʾ�Ҳ���
	
	@Test(description="����-��������5",priority=40)
	public void test57() throws InterruptedException{
		   webtest.click("xpath=//*[@id='treepeople']/a");
		   webtest.click("link=��������");
		   webtest.click("link=��ҳչʾ�Ҳ���");
		   WebElement title = driver.findElement(By.name("USER_SHOW_TITLE2"));
		   title.clear(); 
		   webtest.type("name=USER_SHOW_TITLE2", "���»�Ա");
		   WebElement people = driver.findElement(By.name("USER_SHOW_COUNT2"));
		   people.clear();
		   webtest.type("name=USER_SHOW_COUNT2","5");
		   webtest.click("xpath=//*[@id='submit']");//���ȷ��
		   Alert alert = driver.switchTo().alert();
		   Assert.assertEquals("ȷ�ϸò�����", alert.getText());
		   alert.accept();
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent("��ǩ����ʼ���չʾ�߶� "));
		   
	}
	@Test(description="��ǰ̨",priority=41)
	public void test42() throws InterruptedException{
		  webtest.click("link=��ǰ̨");
		  Thread.sleep(3000);
		  assertTrue(webtest.isTextPresent("ϵͳ"));
		  Thread.sleep(3000);
	}
	
	
	//���ù���������<script>alert("123")</script>����ɹ����о�ʾ�򵯳� �����ɹ�
}
