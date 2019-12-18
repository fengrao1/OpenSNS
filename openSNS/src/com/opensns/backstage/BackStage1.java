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
 * @author 刘美宁
 * 后台：系统、扩展、模块管理、插件管理
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
	//进行刷新操作
	@Test(description = "消息管理-会话列表",priority=1)
	public void test1() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		// 会话列表
		webtest.click("link=会话列表");
		// 刷新按钮
		webtest.click("xpath=//*[@id='main']/div/div[4]/div/button");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert.getText());
		alert.accept();// 点击确认
	    assertTrue(webtest.isTextPresent("会话类型列表"));
		Thread.sleep(5000);
	}

	@Test(description = "消息管理-会话模板",priority=2)
	public void test2() throws InterruptedException {
		 webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
	     System.out.println(textEle.getAttribute("class"));//输入改变之前的值
	     System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
	     String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
	     ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
	     System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		 webtest.click("link=会话模板");
		 webtest.click("xpath=//*[@id='main']/div/div[4]/div/button");//刷新操作
		 Alert alert = driver.switchTo().alert();
		 Assert.assertEquals("确认该操作吗？", alert.getText());
		 alert.accept();// 点击确认
		 Thread.sleep(5000);
	     assertTrue(webtest.isTextPresent("消息模板列表"));

	}

	@Test(description = "消息管理-会话设置",priority=3)
	public void test3() throws InterruptedException {
		 webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
        String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
        ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
        System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		webtest.click("link=会话设置");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Select select = new Select(
				driver.findElement(By.xpath("//*[@id='main']/div/div[3]/div/div/form/div[1]/select")));
		select.selectByIndex(2);
		webtest.click("id=submit");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("会话列表模板  "));
		Thread.sleep(5000);
	}
	
	@DataProvider(name = "information")
	public Object[][] createNews() throws IOException {
		ExcelDataProvider edp = new ExcelDataProvider();
		return edp.getTestDataByExcel("data/liumeining/liu.xlsx","Sheet2");// 要测试的文档
	}
	@Test(dataProvider="information",description = "消息管理-消息模板",priority=4)
	public void test4567(String title, String sort) throws InterruptedException {
	   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		webtest.click("link=消息模板");
		webtest.click("link=添加模板");
		webtest.type("xpath=//*[@id='main']/div/div[3]/div/div/form/div[1]/input", title);
		webtest.type("xpath=//*[@id='main']/div/div[3]/div/div/form/div[2]/input", sort);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Select select = new Select(driver.findElement(By.name("status")));
		select.selectByIndex(2);
		webtest.click("xpath=//*[@id='submit']");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("消息模板"));
		webtest.click("xpath=//*[@id='main']/div/div[3]/div/div/form/div[7]/button[2]");
		assertTrue(webtest.isTextPresent(title));
		Thread.sleep(5000);
		//在输入<script>alert("123")</script>时，添加成功，但是事件只显示alert("123")
	}

	@Test(description = "用户配置",priority=5)
	public void test8() throws InterruptedException, IOException {
	   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//输入改变后前的值
	   webtest.click("link=网站设置");
	   webtest.click("link=用户配置");
	   webtest.type("name=config[USER_NAME_BAOLIU]", ",lmn");
	   webtest.click("xpath=//*[@id='main']/div/div[4]/div/form/div[3]/div/button[1]");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert.getText());
		alert.accept();
		webtest.open(ReadProperties.getPropertyValue("front_url"));


		if (!webtest.isElementPresent("link=admin")) {
			webtest.click("link=注册");
			webtest.type("id=email", "1239@qq.com");
			webtest.type("id=nickname", "lmn0");
			webtest.type("id=inputPassword", "lmn123");
			Thread.sleep(3000);
			//用于JavascriptExecutor直接在元素上发送单击。
			WebElement ele = driver.findElement(By.xpath("/html/body/div[2]/div[1]/form/div/button"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
			Thread.sleep(3000);
			assertTrue(webtest.isTextPresent("昵称被禁止注册"));
			
		} else {
			webtest.mouseoverElement("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
			webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
			webtest.click("link=注册");
			webtest.type("id=email", "1239@qq.com");
			webtest.type("id=nickname", "lmn0");
			webtest.type("id=inputPassword", "lmn123");
			Thread.sleep(3000);
			//用于JavascriptExecutor直接在元素上发送单击。
			WebElement ele = driver.findElement(By.xpath("/html/body/div[2]/div[1]/form/div/button"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
			assertTrue(webtest.isTextPresent("昵称被禁止注册"));
			
		}
	}
	@Test(description = "基本配置",priority=6)
	public void test9() throws InterruptedException{
	  webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	  WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
      System.out.println(textEle.getAttribute("class"));//输入改变之前的值
      System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
      String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
      ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
      System.out.println(textEle.getAttribute("class"));//输入改变后前的值
	  webtest.click("link=网站设置");
	  webtest.click("link=基本配置");
	  assertTrue(webtest.isTextPresent("登录前首页Url"));
	}
	@Test(description = "内容配置",priority=7)
	public void test10() throws InterruptedException{
	  webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	  WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
      System.out.println(textEle.getAttribute("class"));//输入改变之前的值
      System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
      String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
      ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
      System.out.println(textEle.getAttribute("class"));//输入改变后前的值
	  webtest.click("link=网站设置");
	  webtest.click("link=内容配置");
	  assertTrue(webtest.isTextPresent("空白说明"));
	}
	@Test(description = "系统配置",priority=8)
	public void test11() throws InterruptedException{
	  webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	  WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
      System.out.println(textEle.getAttribute("class"));//输入改变之前的值
      System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
      String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
      ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
      System.out.println(textEle.getAttribute("class"));//输入改变后前的值
	  webtest.click("link=网站设置");
      webtest.click("link=系统配置");
      assertTrue(webtest.isTextPresent("图片文件保存根目录"));
	}
	@Test(description = "邮件配置",priority=9)
	public void test12() throws InterruptedException{
	  webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	  WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
      System.out.println(textEle.getAttribute("class"));//输入改变之前的值
      System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
      String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
      ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
      System.out.println(textEle.getAttribute("class"));//输入改变后前的值
	  webtest.click("link=网站设置");
	  webtest.click("link=邮件配置");
	  assertTrue(webtest.isTextPresent("邮件类型"));
	}
	@Test(description = "网站信息-基本信息",priority=10)
	public void test13() throws InterruptedException {
	   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//输入改变之前的值
       System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		webtest.click("link=网站信息");
		webtest.click("link=基本信息");
		webtest.type("name=WEB_SITE_NAME", "123");
		webtest.click("xpath=//*[@id='submit']");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("网站名    "));
		Thread.sleep(5000);
	}
	@Test(description = "网站信息-页脚信息",priority=11)
	public void test14() throws InterruptedException {
	   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//输入改变之前的值
       System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		webtest.click("link=网站信息");
		webtest.click("link=页脚信息");
		driver.switchTo().frame("ueditor_0");
		driver.findElement(By.xpath("/html/body")).click();
		WebElement text = driver.findElement(By.xpath("/html/body"));
		text.sendKeys("页脚信息测试");
		driver.switchTo().defaultContent();// 跳出frame
		webtest.click("xpath=//*[@id='submit']");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("网站名    "));
		Thread.sleep(5000);
	}
	@Test(description = "网站信息-跳转页面",priority=12)
	public void test15() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//输入改变之前的值
       System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		webtest.click("link=网站信息");
		webtest.click("link=跳转页面");
		WebElement success_element = driver.findElement(By.name("SUCCESS_WAIT_TIME"));
		success_element.clear();
		success_element.sendKeys("2");
		WebElement fail_element = driver.findElement(By.name("ERROR_WAIT_TIME"));
		fail_element.clear();
		fail_element.sendKeys("5");
		webtest.click("xpath=//*[@id='submit']");////*[@id="submit"]
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("网站名    "));
		Thread.sleep(5000);
	}

	@Test(description = "网站信息-性能设置",priority=13)
	public void test16() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//输入改变之前的值
       System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		webtest.click("link=网站信息");
		webtest.click("link=性能设置");
		WebElement data_time = driver.findElement(By.name("GET_INFORMATION_INTERNAL"));
		data_time.clear();
		data_time.sendKeys("10");
		webtest.click("xpath=//*[@id='submit']");////*[@id="submit"]
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("网站名    "));
		Thread.sleep(5000);
	}

	@Test(description = "网站信息-上传配置",priority=14)
	public void test17() throws InterruptedException {
	   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//输入改变之前的值
       System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//输入改变后前的值
	   webtest.click("link=网站信息");
	   webtest.click("link=上传配置");
	   assertTrue(webtest.isTextPresent("图片上传驱动    "));
	   Thread.sleep(5000);
	}
	@Test(description = "网站信息-推送配置",priority=15)
	public void test18() throws InterruptedException {
	   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//输入改变之前的值
       System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//输入改变后前的值
	   webtest.click("link=网站信息");
	   webtest.click("link=推送配置");
	   assertTrue(webtest.isTextPresent("WebSocket地址    "));
	   Thread.sleep(5000);
	}
	
	@DataProvider(name = "add")
	public Object[][] createAdd() throws IOException {
		ExcelDataProvider edp = new ExcelDataProvider();
		return edp.getTestDataByExcel("data/liumeining/liu.xlsx","Sheet3");// 要测试的文档
	}
	@Test(dataProvider="add",description = "配置管理添加操作",priority=16)
	public void test1920212223(String sign,String title) throws InterruptedException {
	   Thread.sleep(3000);
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		webtest.click("link=配置管理");
		webtest.click("link=新 增");
		webtest.type("xpath=//*[@id='main']/div/div[2]/form/div[1]/div/input", sign);
		webtest.type("xpath=//*[@id='main']/div/div[2]/form/div[2]/div/input", title);
		webtest.click("xpath=//*[@id='submit']");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert.getText());
		alert.accept();
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent(title));
		Thread.sleep(2000);
	}

	@Test(description = "用户导航添加",priority=17)
	public void test24() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		webtest.click("link=用户导航");
		// 添加一级导航
		webtest.click("xpath=//*[@id='main']/div/div[3]/form/ul/li[1]/div[5]/a[1]/i");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Select select = new Select(driver.findElement(By.name("nav[1][module][]")));
		select.selectByIndex(2);
		WebElement element = driver.findElement(By.xpath("//*[@id='main']/div/div[3]/form/ul/li[2]/div[1]/input[1]"));
		element.clear();
		element.sendKeys("用户一级导航测试");
		webtest.click("xpath=//*[@id='submit']");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("网站主页"));
		Thread.sleep(5000);

	}

	@Test(description = "顶部导航添加",priority=18)
	public void test25() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		webtest.click("link=顶部导航");
		// 添加一级导航
		webtest.click("xpath=//*[@id='main']/div/div[3]/form/ul/li[1]/div[5]/a[1]/i");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Select select = new Select(driver.findElement(By.name("nav[1][module][]")));
		select.selectByIndex(2);
		WebElement element = driver.findElement(By.xpath("//*[@id='main']/div/div[3]/form/ul/li[2]/div[1]/input[1]"));
		element.clear();
		element.sendKeys("一级测试");
		webtest.click("xpath=//*[@id='submit']");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("一级测试"));
		

	}

	@Test(description = "顶部导航的子导航测试",priority=19)
	public void test26() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		webtest.click("link=顶部导航");
		webtest.click("xpath=//*[@id='main']/div/div[3]/form/ul/li[3]/div[5]/a[3]/i");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Select select = new Select(driver.findElement(By.name("nav[2][module][]")));
		select.selectByIndex(2);
		WebElement element = driver.findElement(By.name("nav[2][title][]"));
		element.clear();
		element.sendKeys("子导航测试");
		webtest.click("xpath=//*[@id='submit']");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("子导航测试"));
		Thread.sleep(2000);

	}

	@Test(description = "群发消息",priority=20)
	public void test27() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//输入改变之前的值
       System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		webtest.click("link=群发消息用户列表");
		webtest.click("xpath=//*[@id='main']/div/div[4]/div/button[2]");
		webtest.type("xpath=//*[@id='migration']/div[3]/input", "群发消息");
		// webtest.type("xpath=/html/body","群发消息");
		driver.switchTo().frame("ueditor_0");
		driver.findElement(By.xpath("/html/body")).click();
		WebElement text = driver.findElement(By.xpath("/html/body"));
		text.sendKeys("群发消息");
		driver.switchTo().defaultContent();// 跳出frame
		webtest.click("xpath=//*[@id='migration']/div[6]/a[1]");
		assertTrue(webtest.isTextPresent("群发用户列表"));
		Thread.sleep(5000);
	}

	@Test(description = "计划任务",priority=21)
	public void test28() throws InterruptedException {
	   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
	   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//输入改变后前的值
	   webtest.click("link=计划任务列表");
	   if (webtest.isElementPresent("link=Stop（点击运行）")) {
			webtest.click("xpath=//*[@id='main']/div/div[4]/div/a[1]");
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("确认该操作吗？", alert.getText());
			alert.accept();
			assertTrue(webtest.isTextPresent("Running （点击停止）"));
			Thread.sleep(5000);

		} else {
			webtest.click("link=Running （点击停止）");
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("确认该操作吗？", alert.getText());
			alert.accept();
//			assertTrue(webtest.isTextPresent("Stop（点击运行）"));
			Thread.sleep(5000);
		}
	   
	}
	@Test(description="编辑器配置",priority=22)
	public void test29() throws InterruptedException{
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");//滑动到系统上
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=编辑器配置");
		   assertTrue(webtest.isTextPresent("编辑器默认配置"));
		   Thread.sleep(1000);
		   
	}
	@Test(description="MarkDown配置",priority=23)
	public void test30() throws InterruptedException{
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");//滑动到系统上
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=MarkDown配置");
		   assertTrue(webtest.isTextPresent("编辑器默认配置"));
		   Thread.sleep(1000);
		   
	}
	//备份数据库
	@Test(description="备份数据库",priority=24)
	public void test31() throws InterruptedException{
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");//滑动到系统上
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=备份数据库");
		   webtest.click("link=立即备份");
		   assertTrue(webtest.isTextPresent("已备份"));
		   Thread.sleep(1000);
	}
	//还原数据库
	@Test(description="还原数据库",priority=25)
	public void test32() throws InterruptedException{
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");//滑动到系统上
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=还原数据库");
		   assertTrue(webtest.isTextPresent("数据备份"));
		   Thread.sleep(1000);
	}
	@Test(description="扩展-云市场-安装插件",priority=26)//
	public void test33() throws InterruptedException{
		   webtest.mouseoverElement("link=扩展");//滑动到扩展上
		   WebElement textEle=driver.findElement(By.linkText("扩展"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown open");
		   webtest.click("xpath=/html/body/header/nav/div/ul[1]/li[5]/ul/li/div/div/div[1]/ul/li[2]/a");//点击云市场
		   //[ 注销 ]
		   if(webtest.isElementPresent("link=[ 注销 ]")){
			   //webtest.mouseoverElement("xpath=/html/body/div[4]/div/ul/li[2]/ul/li[1]/a");
			   WebElement type_class=driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[2]/ul/li[1]/a"));
			   Actions action = new Actions(driver);
			   action.moveToElement(type_class).click().perform();
			   
			   WebElement load = driver.findElement(By.linkText("插件"));
			   JavascriptExecutor executor = (JavascriptExecutor)driver;
			   executor.executeScript("arguments[0].click();", load);
			   webtest.click("link=插件");
			   webtest.click("link=紫叶随风悬浮天气插件");
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
			   WebElement load = driver.findElement(By.linkText("插件"));
			   JavascriptExecutor executor = (JavascriptExecutor)driver;
			   executor.executeScript("arguments[0].click();", load);
			   webtest.click("link=插件");
			   webtest.click("link=紫叶随风悬浮天气插件");
			   webtest.click("class=button-buy");
			   webtest.click("class=btn btn-primary");			   
		   }
		   Thread.sleep(1000);
	}
	@Test(description="云市场-自动升级",priority=27)
	public void test34() throws InterruptedException{
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[5]/a");//滑动到扩展上
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[5]/a"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=自动升级");
		   webtest.click("link= 重新检测");
		   assertTrue(webtest.isTextPresent("自动升级"));
		   
	}
	
	@Test(description="插件管理-安装插件",priority=28)
	public void test35() throws InterruptedException{
		Thread.sleep(5000);
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[5]/a");//滑动到扩展上
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[5]/a"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=插件管理");
		   webtest.click("link=未安装");
		   webtest.click("xpath=//*[@id='main']/div/div[4]/div/div/div/div[1]/div/div[5]/div/a");
		   webtest.click("link=未安装");
		   assertTrue(!webtest.isTextPresent("飞鸽"));
	}
	@Test(description="插件管理-卸载",priority=29)
	public void test36() throws InterruptedException{
		Thread.sleep(5000);
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[5]/a");//滑动到扩展上
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[5]/a"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=插件管理");
		   webtest.click("xpath=//*[@id='main']/div/div[4]/div/div/div/div[3]/div/div[5]/div/a[3]");//卸载天气的插件
		   webtest.click("link=已安装");
		 //*[@id="main"]/div/div[4]/div/div/div/div[4]/div/div[5]/div/a[3]
		   Thread.sleep(3000);
		   assertTrue(!webtest.isTextPresent("飞鸽"));
	}
	
	@Test(description="模块管理-安装活动",priority=30)
	public void test38() throws InterruptedException{
		  Thread.sleep(3000);
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[5]/a");//滑动到扩展上
		     WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[5]/a"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=模块管理");
		   webtest.click("link=未安装");
		   webtest.click("xpath=//*[@id='main']/div/div[3]/div/ul/li/div[2]/div[3]/div[1]/a[2]");
		   webtest.click("xpath=//*[@id='submit']");
		   Alert alert = driver.switchTo().alert();
		   Assert.assertEquals("确认该操作吗？", alert.getText());
		   alert.accept();
		   webtest.click("link=已安装");
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent("活动"));
		   Thread.sleep(3000);
	}
	@Test(description="模块管理-卸载活动",priority=31)
	public void test39() throws InterruptedException{
		 Thread.sleep(3000);
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[5]/a");//滑动到扩展上
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[5]/a"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=模块管理");
		   webtest.click("xpath=//*[@id='main']/div/div[3]/div/ul/li[1]/div[2]/div[3]/div[1]/a[2]");
		   webtest.click("xpath=//*[@id='submit']");
		   Alert alert = driver.switchTo().alert();
		   Assert.assertEquals("确认该操作吗？", alert.getText());
		   alert.accept();
		   webtest.click("link=未安装");
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent("活动"));

	}
	
	@Test(description="主题管理-检查更新",priority=32)
	public void test40() throws InterruptedException{
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[5]/a");//滑动到扩展上
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[5]/a"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=主题管理");
		   webtest.click("link=  立刻检查更新");
		   assertTrue(webtest.isTextPresent("安装新主题"));
		   
	}
	@DataProvider(name = "cooperation")
	public Object[][] createData() throws IOException {
		ExcelDataProvider edp = new ExcelDataProvider();
		return edp.getTestDataByExcel("data/liumeining/liu.xlsx","Sheet1");// 要测试的文档
	}
	
	@Test(dataProvider="cooperation",description="合作单位",priority=33)
	public void test414344(String title,String link) throws InterruptedException{
		   webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[5]/a");//滑动到扩展上
		   WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[5]/a"));
	       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
	       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		   webtest.click("link=合作单位");
		   webtest.click("link=新 增");
		   webtest.type("name=title", title);
		   webtest.type("name=link", link);
		   webtest.click("xpath=//*[@id='form']/div[2]/input[1]");//点击确定  link=确定
		   //文本框中输入<script>alert('ceshi')</script>，点击确定，弹出提示框，返回站点名称不显示出来
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent(title));
	}
	
	
	@Test(description="论坛管理",priority=34)
	public void test45() throws InterruptedException{
		   webtest.click("xpath=//*[@id='treeforum']/a");
		   webtest.click("xpath=//*[@id='treeforum']/ul/li[2]/a");
		   webtest.click("link=新增");
		   webtest.type("name=title", "论坛测试");
		   WebElement sort =driver.findElement(By.name("sort"));
		   sort.clear();
		   sort.sendKeys("1");
		   //webtest.type("name=sort", "1");
		   webtest.click("xpath=//*[@id='submit']");//*[@id="submit"]
		   Alert alert = driver.switchTo().alert();
		   Assert.assertEquals("确认该操作吗？", alert.getText());
		   alert.accept();
//		   Thread.sleep(1000);
		   webtest.click("xpath=//*[@id='main']/div/div[3]/div/div/form/div[5]/button[2]");
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent("论坛测试"));
		   
	}
	
	@DataProvider(name = "plate")
	public Object[][] addPlate() throws IOException {
		ExcelDataProvider edp = new ExcelDataProvider();
		return edp.getTestDataByExcel("data/liumeining/liu.xlsx","Sheet4");// 要测试的文档
	}
	@Test(dataProvider="plate",description="板块管理-添加",priority=35)
	public void test46474849505152(String title,String admin) throws InterruptedException{
		Thread.sleep(3000);
		   webtest.click("xpath=//*[@id='treeforum']/a");
		   webtest.click("link=板块管理");
		   webtest.click("link=新增");
		   webtest.type("name=title", title);
		   webtest.type("name=admin", admin);
		   WebElement submit = driver.findElement(By.xpath("//*[@id='submit']"));
		   JavascriptExecutor executor = (JavascriptExecutor)driver;
		   executor.executeScript("arguments[0].click();", submit);
		   Alert alert = driver.switchTo().alert();
		   Assert.assertEquals("确认该操作吗？", alert.getText());
		   alert.accept();
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent(title));
		
	}
	
	@Test(description="找人-基本配置1",priority=36)
	public void test53() throws InterruptedException{
		   webtest.click("xpath=//*[@id='treepeople']/a");
		   webtest.click("link=基本设置");
		   webtest.type("name=MAX_SHOW_HEIGHT", "160");
		   webtest.click("xpath=//*[@id='submit']");
		   Alert alert = driver.switchTo().alert();
		   Assert.assertEquals("确认该操作吗？", alert.getText());
		   alert.accept();
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent("标签面板初始最大展示高度 "));
		  
	}
	//找人页右上侧展示
	@Test(description="找人-基本配置2",priority=37)
	public void test54() throws InterruptedException{
		   webtest.click("xpath=//*[@id='treepeople']/a");
		   webtest.click("link=基本设置");
		   webtest.click("link=找人页右上侧展示");
		   WebElement title = driver.findElement(By.name("USER_SHOW_TITLE0"));
		   title.clear();
		   webtest.type("name=USER_SHOW_TITLE0", "好友也关注");
		   WebElement people = driver.findElement(By.name("USER_SHOW_COUNT0"));
		   people.clear();
		   webtest.type("name=USER_SHOW_COUNT0","4");
		   webtest.click("xpath=//*[@id='submit']");//点击确定
		   Alert alert = driver.switchTo().alert();
		   Assert.assertEquals("确认该操作吗？", alert.getText());
		   alert.accept();
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent("标签面板初始最大展示高度 "));
		  
	}
	
	@Test(description="找人-基本配置3",priority=38)
	public void test55() throws InterruptedException{
		   webtest.click("xpath=//*[@id='treepeople']/a");
		   webtest.click("link=基本设置");
		   webtest.click("link=找人页右下侧展示");
		   WebElement title = driver.findElement(By.name("USER_SHOW_TITLE3"));
		   title.clear();
		   webtest.type("name=USER_SHOW_TITLE3", "随机推荐关注");
		   WebElement people = driver.findElement(By.name("USER_SHOW_COUNT3"));
		   people.clear();
		   webtest.type("name=USER_SHOW_COUNT3","4");
		   webtest.click("xpath=//*[@id='submit']");//点击确定
		   Alert alert = driver.switchTo().alert();
		   Assert.assertEquals("确认该操作吗？", alert.getText());
		   alert.accept();
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent("标签面板初始最大展示高度 "));
		  
	}
	
	//首页展示左侧栏
	
	@Test(description="找人-基本配置4",priority=39)
	public void test56() throws InterruptedException{
		   webtest.click("xpath=//*[@id='treepeople']/a");
		   webtest.click("link=基本设置");
		   webtest.click("link=首页展示左侧栏");
		   WebElement title = driver.findElement(By.name("USER_SHOW_TITLE1"));
		   title.clear();
		   webtest.type("name=USER_SHOW_TITLE1", "活跃会员");
		   WebElement people = driver.findElement(By.name("USER_SHOW_COUNT1"));
		   people.clear();
		   webtest.type("name=USER_SHOW_COUNT1","5");
		   webtest.click("xpath=//*[@id='submit']");//点击确定
		   Alert alert = driver.switchTo().alert();
		   Assert.assertEquals("确认该操作吗？", alert.getText());
		   alert.accept();
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent("标签面板初始最大展示高度 "));
		   
	}
	
	//首页展示右侧栏
	
	@Test(description="找人-基本配置5",priority=40)
	public void test57() throws InterruptedException{
		   webtest.click("xpath=//*[@id='treepeople']/a");
		   webtest.click("link=基本设置");
		   webtest.click("link=首页展示右侧栏");
		   WebElement title = driver.findElement(By.name("USER_SHOW_TITLE2"));
		   title.clear(); 
		   webtest.type("name=USER_SHOW_TITLE2", "最新会员");
		   WebElement people = driver.findElement(By.name("USER_SHOW_COUNT2"));
		   people.clear();
		   webtest.type("name=USER_SHOW_COUNT2","5");
		   webtest.click("xpath=//*[@id='submit']");//点击确定
		   Alert alert = driver.switchTo().alert();
		   Assert.assertEquals("确认该操作吗？", alert.getText());
		   alert.accept();
		   Thread.sleep(3000);
		   assertTrue(webtest.isTextPresent("标签面板初始最大展示高度 "));
		   
	}
	@Test(description="打开前台",priority=41)
	public void test42() throws InterruptedException{
		  webtest.click("link=打开前台");
		  Thread.sleep(3000);
		  assertTrue(webtest.isTextPresent("系统"));
		  Thread.sleep(3000);
	}
	
	
	//配置管理中新增<script>alert("123")</script>保存成功，有警示框弹出 攻击成功
}
