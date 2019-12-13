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
	
	// 定义数据驱动
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

	
	@Test(description="权限管理",priority=1)
	public void test1() throws InterruptedException, IOException {
		// 2）4.1.1 模块权限管理
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		String url_h=ReadProperties.getPropertyValue("url_h");
		Thread.sleep(2000);
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[1]/a");
		webtest.click("link=允许身份访问");
		
		webtest.click("name=role_module[13][]");	
		webtest.click("id=save-role-module-auth");
		
		//打开前台，退出登录
		webtest.open(Front_url);
		Thread.sleep(3000);
		webtest.mouseoverElement("link=root");
		webtest.click("class=os-icon-logout");
		
		webtest.click("xpath=//*[@id='nav_bar']/div/ul/li[4]/a/span[1]");
		assertTrue(webtest.isTextPresent("该模块未对非登录用户开放。"));
		
		webtest.open(url_h);
		webtest.type("name=username", "root");
		webtest.type("name=password", "root");
		webtest.click("xpath=//button[@type='submit']");
		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
		
		webtest.click("name=role_module[13][]");
		webtest.click("id=save-role-module-auth");
	}
	
	@Test(description="仪表盘",priority=2)
	public void test2() throws InterruptedException{
		// 2）4.1.2.1仪表盘
		webtest.click("link=首页");
		assertTrue(webtest.isTextPresent("常用操作"));
	}
	
	@Test(description="数据预览",priority=3)
	public void test3() throws InterruptedException{
		// 2）4.1.2.2数据概览
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[1]/a");
		webtest.click("link=数据概览");
		
		//添加图表
		webtest.click("class=icon-plus");
		webtest.click("xpath=//*[@id='portlet_list']/div[1]/a");
				
		//查看更多
		webtest.click("link=查看更多");
		webtest.click("link=详细");
		webtest.click("xpath=//button[@class='btn btn-return']");
		webtest.click("link=删除");
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("确认要执行该操作吗?", alert.getText());
		alert.accept();
	}
	
	
	@Test(description="身份与用户_认证类型",priority=4)
	public void test4() throws InterruptedException, IOException{
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[2]");
		WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[2]"));
		System.out.println(textEle.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		
		webtest.click("link=认证类型");
		
		//认证条件设置
		webtest.click("link=设置");
		webtest.type("xpath=//input[@name='follow']","1");
		webtest.click("xpath=//*[@id='submit']");
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert.getText());
		alert.accept();
		Thread.sleep(3000);
		
		//认证字段设置
		webtest.click("xpath=//*[@id='table-data']/tbody/tr[1]/td[19]/a");
		webtest.click("id=id_company_name_1");
		webtest.click("id=id_name_1");
		webtest.click("id=id_id_num_1");
		webtest.click("id=id_image_type_1");
		webtest.click("id=submit");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		//打开前台验证
		webtest.open("http://localhost:8585/index.php?s=/ucenter/attest/individual/id/1.html");
		assertTrue(webtest.isTextPresent("已符合"));
		webtest.click("link=申请");
	}
	
	
	@Test(description="身份与用户_用户禁用",priority=5)
	public void test5() throws InterruptedException{
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[2]");
		WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[2]"));
		System.out.println(textEle.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		
		webtest.click("link=用户信息");
		
		//禁用
		webtest.click("class=ajax-get");
		webtest.type("xpath=//input[@name='forbid_day']","1");
		webtest.click("xpath=//button[@class='btn btn-block btn-primary red-btn']");
		
		assertTrue(webtest.isTextPresent("禁用至："));
	}
	
	@Test(description="身份与用户_用户启用",priority=5)
	public void test5_1() throws InterruptedException{
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[2]");
		WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[2]"));
		System.out.println(textEle.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		
		webtest.click("link=用户信息");
		
		//禁用
		webtest.click("class=ajax-get");
		webtest.type("xpath=//input[@name='forbid_day']","1");
		webtest.click("xpath=//button[@class='btn btn-block btn-primary red-btn']");
		
		assertTrue(webtest.isTextPresent("禁用"));
	}
	
	@Test(description="身份与用户_用户删除",priority=5)
	public void test5_2() throws InterruptedException{
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[2]");
		WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[2]"));
		System.out.println(textEle.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		
		webtest.click("link=用户信息");
		
		//删除
		Thread.sleep(3000);
		webtest.click("link=删除");
		Thread.sleep(3000);
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("确认要执行该操作吗?", alert1.getText());
		alert1.dismiss();
		Thread.sleep(3000);
		
		assertTrue(webtest.isTextPresent("105"));
	}
	
	
	@Test(description="身份与用户_基础配置",priority=6)
	public void test6() throws InterruptedException, IOException{
		
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[2]");
		WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[2]"));
		System.out.println(textEle.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		webtest.click("link=基础配置");
		
		webtest.click("id=id_REG_SWITCH_email");
		webtest.click("xpath=//*[@id='submit']");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		//全不选注册开关即为关闭注册
		webtest.open(Front_url);
		webtest.mouseoverElement("link=root");
		webtest.click("class=os-icon-logout");
		webtest.click("link=注册");
		assertTrue(webtest.isTextPresent("注册已关闭"));
		webtest.click("link=返回首页");
		
		webtest.open(url_h);
		webtest.type("name=username", "root");
		webtest.type("name=password", "root");
		webtest.click("xpath=//button[@type='submit']");
		
		webtest.open("http://localhost:8585/index.php?s=/admin/user_config/index.html");
		webtest.click("id=id_REG_SWITCH_email");
		webtest.click("xpath=//*[@id='submit']");
		
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
	}
	
	@Test(description="身份与用户_登录配置 快捷登录",priority=7)
	public void test7() throws InterruptedException, IOException{
		
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[2]");
		WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[2]"));
		System.out.println(textEle.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		
		webtest.click("link=基础配置");
		
		//登录配置
		webtest.click("link=登录配置");
		webtest.click("id=id_OPEN_QUICK_LOGIN_1");
		webtest.click("id=submit");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		//打开前台，退出登录
		webtest.open(Front_url);
		Thread.sleep(3000);
		webtest.mouseoverElement("link=root");
		webtest.click("class=os-icon-logout");
		webtest.click("link=登录");
		assertTrue(webtest.isTextPresent("欢迎回到 OpenSNS v5开源社群系统 ！"));
				
	}
	
	@Test(description="身份与用户_登录配置 邮箱后缀",priority=8)
	public void test8() throws InterruptedException, IOException{
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[2]");
		WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[2]"));
		System.out.println(textEle.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown active open");
		System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		
		webtest.click("link=基础配置");
		
		//登录配置
		webtest.click("link=登录配置");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='main']/div/div[3]/div/div/form/div[2]/div[3]/input");
		WebElement input=driver.findElement(By.xpath("//*[@id='main']/div/div[3]/div/div/form/div[2]/div[3]/input"));
		input.clear();
		webtest.type("xpath=//*[@id='main']/div/div[3]/div/div/form/div[2]/div[3]/input","@163.com");
		webtest.click("id=submit");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		
		//进入用户列表，修改第三方登录邮箱后缀名
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[2]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[2]"));
		System.out.println(textEle1.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown active open");
		System.out.println(textEle1.getAttribute("class"));//输入改变后前的值
		
		webtest.click("link=用户信息");
		webtest.click("xpath=//*[@id='main']/div/div[4]/table/tbody/tr[1]/td[1]/input");
		
		webtest.click("xpath=//*[@id='main']/div/div[3]/div[1]/button[5]");
			
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
			
		//打开前台,登录
		webtest.open(Front_url);
		Thread.sleep(3000);
		webtest.mouseoverElement("link=root");
		webtest.click("class=os-icon-logout");
		webtest.click("link=登录");
			
		//原账户
		webtest.type("xpath=//input[@id='inputEmail']","123456@qq.com");
		webtest.type("xpath=//input[@type='password']","123456");
		webtest.click("xpath=//*[@id='triggerModal']/div[2]/div[2]/div[2]/form/div[4]/button");
		
		WebElement id=driver.findElement(By.xpath("//input[@id='inputEmail']"));
		id.clear();
		WebElement pw=driver.findElement(By.xpath("//input[@type='password']"));
		pw.clear();
		
		assertTrue(webtest.isTextPresent("首页"));
		Thread.sleep(2000);
	}
	
	
	
	@Test(description="运营_友情链接",priority=9)
	public void test9() throws InterruptedException, IOException{
		
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown open");
		System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		
		//添加友情链接
		webtest.click("link=友情链接");
		webtest.click("link=新增");
		webtest.type("name=title","百度");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='tab1']/div[2]/div/label[2]/input");
		webtest.type("xpath=//input[@name='link']", "https://www.baidu.com/");
		webtest.click("xpath=//input[@type='submit']");
		
		//打开前台
		webtest.open(Front_url);
		assertTrue(webtest.isTextPresent("百度"));
	}
	
	
	
	
	@Test(description="运营_公告访问路径",priority=10)
	public void test10() throws InterruptedException{
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt, textEle, "class", "mega-menu-dropdown open");
		System.out.println(textEle.getAttribute("class"));//输入改变后前的值
		
		//路径1
		webtest.click("link=公告列表");
		webtest.click("link=新增");
		webtest.type("xpath=//input[@name='title']","你好");
		webtest.type("xpath=//input[@name='link']","https://www.baidu.com/");
		
		//公告内容
		Thread.sleep(3000);
		WebElement frame=getDriver().findElement(By.id("ueditor_0"));
		getDriver().switchTo().frame(frame);
		webtest.click("tag=p");
		webtest.type("tag=body", "hello");
		getDriver().switchTo().defaultContent();
		
		webtest.click("id=id_is_force_0");
		webtest.click("xpath=//button[@type='submit']");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		assertTrue(webtest.isTextPresent("你好"));
		
		//路径2
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//输入改变后前的值
		
		//新增公告
		webtest.click("link=发布公告");
		webtest.type("xpath=//input[@name='title']","hello");
		webtest.type("xpath=//input[@name='link']","https://www.baidu.com/");
		
		//公告内容
		WebElement frame1=getDriver().findElement(By.id("ueditor_0"));
		getDriver().switchTo().frame(frame1);
		webtest.click("tag=p");
		webtest.type("tag=body", "hello");
		getDriver().switchTo().defaultContent();
		
		webtest.click("id=id_is_force_0");
		webtest.click("xpath=//button[@type='submit']");
		
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
		
		assertTrue(webtest.isTextPresent("hello"));
		
		
	}
	
	@Test(description="运营_新增公告_有效期为当前时间之前",priority=11)
	public void test11() throws InterruptedException, IOException{
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//输入改变后前的值
		
		//新增公告
		webtest.click("link=发布公告");
		webtest.type("xpath=//input[@name='title']","有效期之前");
		webtest.type("xpath=//input[@name='link']","https://music.163.com/");
		
		
		//公告内容
		WebElement frame=getDriver().findElement(By.id("ueditor_0"));
		getDriver().switchTo().frame(frame);
		webtest.click("tag=p");
		webtest.type("tag=body", "hello");
		getDriver().switchTo().defaultContent();
		
		webtest.click("id=id_is_force_0");
		//有效期
		WebElement input=driver.findElement(By.xpath("//*[@id='main']/div/div[3]/div/div/form/div[8]/div/input"));
		input.clear();
		webtest.click("xpath=//*[@id='main']/div/div[3]/div/div/form/div[8]/div/input");
		webtest.type("xpath=//*[@id='main']/div/div[3]/div/div/form/div[8]/div/input","2019-11-24 04:20");
		
		webtest.click("xpath=//button[@type='submit']");
		
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
		
		//进入前台查看公告
		webtest.open(Front_url);
		webtest.click("xpath=/html/body/div[2]/div[3]/li[2]/a/i");
		Thread.sleep(3000);
		
		WebElement ele = driver.findElement(By.xpath("//*[@id='message_block_Common_announce']/div/ul/li[1]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("音乐"));
		
		webtest.switchWidow(1);
		webtest.closeTab();
	}
	
	
	@Test(description="运营_新增公告_有效期为当前时间之后",priority=12)
	public void test12() throws InterruptedException, IOException{
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//输入改变后前的值
		
		//新增公告
		webtest.click("link=发布公告");
		webtest.type("xpath=//input[@name='title']","有效期之后");
		webtest.type("xpath=//input[@name='link']","https://music.163.com/");
		
		//公告内容
		WebElement frame=getDriver().findElement(By.id("ueditor_0"));
		getDriver().switchTo().frame(frame);
		webtest.click("tag=p");
		webtest.type("tag=body", "hello");
		getDriver().switchTo().defaultContent();
		
		webtest.click("id=id_is_force_0");
		//有效期
		WebElement input=driver.findElement(By.xpath("//*[@id='main']/div/div[3]/div/div/form/div[8]/div/input"));
		input.clear();
		webtest.click("xpath=//*[@id='main']/div/div[3]/div/div/form/div[8]/div/input");
		webtest.type("xpath=//*[@id='main']/div/div[3]/div/div/form/div[8]/div/input","2019-12-30 04:20");
		
		webtest.click("xpath=//button[@type='submit']");
		
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
		
		//进入前台查看公告
		webtest.open(Front_url);
		webtest.click("xpath=/html/body/div[2]/div[3]/li[2]/a/i");
		Thread.sleep(3000);
		
		WebElement ele = driver.findElement(By.xpath("//*[@id='message_block_Common_announce']/div/ul/li[1]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("音乐"));
		
		webtest.switchWidow(1);
		webtest.closeTab();
		
	}
	
	
	@Test(description="运营_新增公告_链接为www开头",priority=13)
	public void test13() throws InterruptedException, IOException{
		
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//输入改变后前的值
		
		//新增公告
		webtest.click("link=发布公告");
		webtest.type("xpath=//input[@name='title']","链接以www开头");
		webtest.type("xpath=//input[@name='link']","www.baidu.com");
		
		//内容
		WebElement frame=getDriver().findElement(By.id("ueditor_0"));
		getDriver().switchTo().frame(frame);
		webtest.click("tag=p");
		webtest.type("tag=body", "hello");
		getDriver().switchTo().defaultContent();
		
		webtest.click("id=id_is_force_0");
		webtest.click("xpath=//button[@type='submit']");
		
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
		
		//进入前台查看公告
		webtest.open(Front_url);
		webtest.click("xpath=/html/body/div[2]/div[3]/li[2]/a/i");
		Thread.sleep(3000);
		
		WebElement ele = driver.findElement(By.xpath("//*[@id='message_block_Common_announce']/div/ul/li[1]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("非法操作:www.baidu.com"));
		
		webtest.switchWidow(1);
		webtest.closeTab();
	}
	
	@Test(description="运营_新增公告_链接为不是完整链接",priority=14)
	public void test14() throws InterruptedException, IOException{
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//输入改变后前的值
		
		//新增公告
		webtest.click("link=发布公告");
		webtest.type("xpath=//input[@name='title']","链接不是完整链接");
		webtest.type("xpath=//input[@name='link']","www.baidu");
		
		//公告内容
		WebElement frame=getDriver().findElement(By.id("ueditor_0"));
		getDriver().switchTo().frame(frame);
		webtest.click("tag=p");
		webtest.type("tag=body", "hello");
		getDriver().switchTo().defaultContent();
		
		webtest.click("id=id_is_force_0");
		
		webtest.click("xpath=//button[@type='submit']");
		
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
		
		//进入前台查看公告
		webtest.open(Front_url);
		webtest.click("xpath=/html/body/div[2]/div[3]/li[2]/a/i");
		Thread.sleep(3000);
		
		WebElement ele = driver.findElement(By.xpath("//*[@id='message_block_Common_announce']/div/ul/li[1]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("非法操作:www.baidu"));
		
	}
	
	
	@Test(description="运营_新增公告_链接为站内链接",priority=15)
	public void test15() throws InterruptedException, IOException{
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//输入改变后前的值
		
		//新增公告
		webtest.click("link=发布公告");
		webtest.type("xpath=//input[@name='title']","链接为站内链接");
		webtest.type("xpath=//input[@name='link']","http://localhost:8585/index.php?s=/people/index/index.html");
		
		//公告内容
		WebElement frame=getDriver().findElement(By.id("ueditor_0"));
		getDriver().switchTo().frame(frame);
		webtest.click("tag=p");
		webtest.type("tag=body", "hello");
		getDriver().switchTo().defaultContent();
		
		webtest.click("id=id_is_force_0");
		webtest.click("xpath=//button[@type='submit']");
		
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
		
		//进入前台查看公告
		webtest.open(Front_url);
		webtest.click("xpath=/html/body/div[2]/div[3]/li[2]/a/i");
		Thread.sleep(3000);
		
		WebElement ele = driver.findElement(By.xpath("//*[@id='message_block_Common_announce']/div/ul/li[1]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("会员展示"));
		
		webtest.switchWidow(1);
		webtest.closeTab();
	}
	
	
	@Test(description="运营_新增公告_禁用",priority=16)
	public void test16() throws InterruptedException, IOException{
		String url_h=ReadProperties.getPropertyValue("url_h");
		String Front_url=ReadProperties.getPropertyValue("Front_url");
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//输入改变后前的值
		
		//新增公告
		webtest.click("link=发布公告");
		webtest.type("xpath=//input[@name='title']","禁用");
		webtest.type("xpath=//input[@name='link']","http://localhost:8585/index.php?s=/people/index/index.html");
		
		//公告内容
		WebElement frame=getDriver().findElement(By.id("ueditor_0"));
		getDriver().switchTo().frame(frame);
		webtest.click("tag=p");
		webtest.type("tag=body", "hello");
		getDriver().switchTo().defaultContent();
		
		webtest.click("id=id_is_force_0");
		//禁用
		Select se1 = new Select(driver.findElement(By.name("status")));
		se1.selectByValue("0");
		
		webtest.click("xpath=//button[@type='submit']");
		
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert2.getText());
		alert2.accept();
		Thread.sleep(3000);
		
		//进入前台查看公告
		webtest.open(Front_url);
		webtest.click("xpath=/html/body/div[2]/div[3]/li[2]/a/i");
		
		WebElement ele = driver.findElement(By.xpath("//*[@id='message_block_Common_announce']/div/ul/li[1]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
	}
	
	
	@Test(dataProvider = "d16",description="运营_公告列表_筛选",priority=17)
	public void test17(String p1,String p2) throws InterruptedException{
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//输入改变后前的值
		
		webtest.click("link=公告列表");
		
		Thread.sleep(3000);
		//用Select方式 点击下拉框
		Select se1 = new Select(driver.findElement(By.xpath("//*[@id='selectForm']/div[1]/div[2]/select")));
		se1.selectByValue(p1);
		Thread.sleep(3000);
		Select se2 = new Select(driver.findElement(By.xpath("//*[@id='selectForm']/div[2]/div[2]/select")));
		se2.selectByValue(p2);
		Thread.sleep(3000);
		
	}
	
	
	@Test(description="运营_公告列表_全部删除",priority=24)
	public void test24() throws InterruptedException{
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//输入改变后前的值
		
		webtest.click("link=公告列表");
		webtest.click("xpath=//input[@type='checkbox']");
		webtest.click("xpath=//button[@class='btn ajax-post btn-danger btn btn-default']");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert1.getText());
		alert1.dismiss();
		Thread.sleep(3000);
	}
	
	@Test(description="运营_公告列表_部分删除",priority=25)
	public void test25() throws InterruptedException{
		
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//输入改变后前的值
		
		webtest.click("link=公告列表");
		webtest.click("xpath=//input[@class='ids']");
		webtest.click("xpath=//button[@class='btn ajax-post btn-danger btn btn-default']");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
	}
	
	
	
	@Test(description="运营_敏感词设置",priority=30)
	public void test30() throws InterruptedException{
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//输入改变后前的值
		
		webtest.click("link=敏感词设置");
		webtest.click("id=id_OPEN_SENSITIVE_1");
		webtest.click("id=submit");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
	}
	
	
	@Test(description="运营_敏感词启用",priority=36)
	public void test36() throws InterruptedException, IOException{
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//输入改变后前的值
		
		webtest.click("link=敏感词列表");
		webtest.click("link=新增");
		webtest.type("xpath=//input[@type='text']","你好");
		webtest.click("id=submit");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		//打开前台 发微博
		webtest.open("http://localhost:8585/index.php?s=/weibo/index/index.html");
		webtest.click("class=add-weibo");
		webtest.click("class=icon-zs");
		webtest.click("id=weibo_content");
		webtest.type("id=weibo_content","你好");
		webtest.click("xpath=//*[@id='send_box']/div/div[3]/div[2]/a[1]/i");
		assertTrue(webtest.isTextPresent("***"));
		
	}
	
	@Test(description="运营_敏感词禁用",priority=40)
	public void test40() throws InterruptedException{
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//输入改变后前的值
		
		webtest.click("link=敏感词列表");
		webtest.click("link=新增");
		webtest.type("xpath=//input[@type='text']","测试");
		
		Select se1 = new Select(driver.findElement(By.xpath("//*[@id='main']/div/div[3]/div/div/form/div[3]/select")));
		se1.selectByValue("-1");
		webtest.click("id=submit");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		//打开前台 发微博
		webtest.open("http://localhost:8585/index.php?s=/weibo/index/index.html");
		webtest.click("class=add-weibo");
		//webtest.click("class=icon-zs");
		webtest.click("id=weibo_content");
		webtest.type("id=weibo_content","测试");
		webtest.click("xpath=//*[@id='send_box']/div/div[3]/div[2]/a[1]/i");
		assertTrue(webtest.isTextPresent("测试"));
		
	}
	
	
	@Test(dataProvider = "d23",description="运营_新增敏感词",priority=41)
	public void test41(String p1,String p2) throws InterruptedException{
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//输入改变后前的值
		
		webtest.click("link=敏感词列表");
		webtest.click("link=新增");
		webtest.type("xpath=//input[@type='text']",p1);
		webtest.click("id=submit");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		//打开前台 发微博
		webtest.open("http://localhost:8585/index.php?s=/weibo/index/index.html");
		webtest.click("class=add-weibo");
		//webtest.click("class=icon-zs");
		webtest.click("id=weibo_content");
		webtest.type("id=weibo_content",p2);
		webtest.click("xpath=//*[@id='send_box']/div/div[3]/div[2]/a[1]/i");
	}
	
	@Test(dataProvider = "d24",description="运营_敏感词批量增加",priority=42)
	public void test42(String p1) throws InterruptedException{
		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[3]");
		WebElement textEle1=driver.findElement(By.xpath("/html/body/header/nav/div/ul[1]/li[3]"));
		System.out.println(textEle1.getAttribute("class"));//输入改变之前的值
		String jsStrToSetAtt1="arguments[0].setAttribute(arguments[1],arguments[2])";//改变属性的js
		((JavascriptExecutor) driver).executeScript(jsStrToSetAtt1, textEle1, "class", "mega-menu-dropdown open");
		System.out.println(textEle1.getAttribute("class"));//输入改变后前的值
		
		webtest.click("link=批量添加");
		webtest.click("name=titles");
		webtest.type("xpath=//input[@type='text']",p1);
		webtest.click("id=submit");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
	}
	
	
	
	
}