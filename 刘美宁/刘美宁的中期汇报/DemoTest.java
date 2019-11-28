package com.webtest.demo;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;

@Listeners(com.webtest.core.WebTestListener.class)
public class DemoTest extends BaseTest {

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
        System.out.println(textEle.getAttribute("class"));//输入改变之前的值
        System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
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
		Thread.sleep(5000);
	}

	@Test(description = "消息管理-消息模板",priority=4)
	public void test4() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//输入改变之前的值
       System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		webtest.click("link=消息模板");
		webtest.click("link=添加模板");
		webtest.type("xpath=//*[@id='main']/div/div[3]/div/div/form/div[1]/input", "lmn");
		webtest.type("xpath=//*[@id='main']/div/div[3]/div/div/form/div[2]/input", "123");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Select select = new Select(driver.findElement(By.name("status")));
		select.selectByIndex(2);
		webtest.click("xpath=//*[@id='submit']");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert.getText());
		alert.accept();
		assertTrue(webtest.isTextPresent("消息模板"));
		webtest.click("xpath=//*[@id='main']/div/div[3]/div/div/form/div[7]/button[2]");
		Thread.sleep(5000);
	}

	@Test(description = "用户配置",priority=5)
	public void test5() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//输入改变之前的值
       System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
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
		webtest.open("http://localhost:9898/index.php?s=/home/index/index.html");

		if (!webtest.isElementPresent("link=admin")) {
			webtest.click("link=注册");
			webtest.type("id=email", "123@qq.com");
			webtest.type("id=nickname", "lmn001");
			webtest.type("id=inputPassword", "lmn123");
			webtest.click("xpath=/html/body/div[2]/div[1]/form/div/button");
			webtest.open("http://localhost:9898/index.php?s=/admin/public/login.html");
			Thread.sleep(5000);
		} else {
			webtest.mouseoverElement("xpath=/html/body/div[2]/div[3]/li[3]/a/span[2]");
			webtest.click("xpath=/html/body/div[2]/div[3]/li[3]/ul/div[4]/div[2]/div");
			webtest.click("link=注册");
			webtest.type("id=email", "123@qq.com");
			webtest.type("id=nickname", "lmn001");
			webtest.type("id=inputPassword", "lmn123");
			webtest.click("class=btn btn-primary new-btn green-btn");
			webtest.open("http://localhost:9898/index.php?s=/admin/public/login.html");
			Thread.sleep(5000);
		}
	}

	@Test(description = "网站信息",priority=6)
	public void test6() throws InterruptedException {

		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//输入改变之前的值
       System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		webtest.click("link=网站信息");
		webtest.type("name=WEB_SITE_NAME", "123");
		webtest.click("xpath=//*[@id='submit']");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert.getText());
		alert.accept();
		Thread.sleep(5000);
	}

	@Test(description = "配置管理添加操作",priority=7)
	public void test7() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//输入改变之前的值
       System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		webtest.click("link=配置管理");
		webtest.click("link=新 增");
		webtest.type("xpath=//*[@id='main']/div/div[2]/form/div[1]/div/input", "123");
		webtest.type("xpath=//*[@id='main']/div/div[2]/form/div[2]/div/input", "123");
		webtest.click("xpath=//*[@id='submit']");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert.getText());
		alert.accept();
		Thread.sleep(5000);
	}

	@Test(description = "用户导航添加",priority=8)
	public void test8() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//输入改变之前的值
       System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
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
		Thread.sleep(5000);

	}

	@Test(description = "顶部导航添加",priority=9)
	public void test9() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//输入改变之前的值
       System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
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

	}

	@Test(description = "顶部导航的子导航测试",priority=10)
	public void test10() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//输入改变之前的值
       System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
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
		Thread.sleep(5000);

	}

	@Test(description = "群发消息",priority=11)
	public void test11() throws InterruptedException {
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
		Thread.sleep(5000);
	}

	@Test(description = "计划任务",priority=12)
	public void test12() throws InterruptedException {
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[4]/a");
		 WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[4]"));
       System.out.println(textEle.getAttribute("class"));//输入改变之前的值
       System.out.println(textEle.getAttribute("data-id"));//输入改变之前的值
       String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
       ((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
       System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		webtest.click("link=计划任务列表");
		if (!webtest.isElementPresent("link=Stop（点击运行）")) {
			webtest.click("link=Stop（点击运行）");
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("确认该操作吗？", alert.getText());
			alert.accept();
			Thread.sleep(5000);

		} else {
			webtest.click("link=Running （点击停止）");
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("确认该操作吗？", alert.getText());
			alert.accept();
			Thread.sleep(5000);
		}
	}
}
