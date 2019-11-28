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

	
//	@Test(dataProvider = "d",description="登录")
//	public void test1(String p1, String p2) throws InterruptedException {
//		// 1)登录
//		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
//		webtest.type("name=username", p1);
//		webtest.type("name=password", p2);
//		webtest.click("xpath=//button[@type='submit']");
//		Thread.sleep(4000);
//	}
//
//	@Test(description="权限管理")
//	public void test2() throws InterruptedException {
//		// 2）4.1.1 模块权限管理
//		Thread.sleep(2000);
//		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[1]/a");
//		webtest.click("link=允许身份访问");
//		
//		webtest.click("name=role_module[13][]");	
//		webtest.click("id=save-role-module-auth");
//		
//		//打开前台，退出登录
//		webtest.open("http://localhost:8585/index.php?s=/forum/index/index.html");
//		Thread.sleep(3000);
//		webtest.mouseoverElement("link=root");
//		webtest.click("class=os-icon-logout");
//		
//		webtest.click("xpath=//*[@id='nav_bar']/div/ul/li[4]/a/span[1]");
//		assertTrue(webtest.isTextPresent("该模块未对非登录用户开放。"));
//	}
//	
//	@Test(description="仪表盘")
//	public void test3() throws InterruptedException{
//		// 2）4.1.2.1仪表盘
//		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
//		webtest.type("name=username", "root");
//		webtest.type("name=password", "root");
//		webtest.click("xpath=//button[@type='submit']");
//		Thread.sleep(4000);
//		webtest.click("link=首页");
//		assertTrue(webtest.isTextPresent("常用操作"));
//	}
//	
//	@Test(description="数据预览")
//	public void test4() throws InterruptedException{
//		// 2）4.1.2.2数据概览
//		webtest.mouseoverElement("xpath=/html/body/header/nav/div/ul[1]/li[1]/a");
//		webtest.click("link=数据概览");
//		
//		//添加图表
//		webtest.click("class=icon-plus");
//		webtest.click("xpath=//*[@id='portlet_list']/div[1]/a");
//				
//		//查看更多
//		webtest.click("link=查看更多");
//		webtest.click("link=详细");
//		webtest.click("xpath=//button[@class='btn btn-return']");
//		webtest.click("link=删除");
//		
//		Alert alert = driver.switchTo().alert();
//		Assert.assertEquals("确认要执行该操作吗?", alert.getText());
//		alert.accept();
//	}
	
	
	@Test(description="身份与用户_认证类型")
	public void test5() throws InterruptedException{
		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
		webtest.type("name=username", "root");
		webtest.type("name=password", "root");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(4000);
		
		webtest.mouseoverElement("link=用户与身份");
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
	
	
	@Test(description="身份与用户_用户信息")
	public void test6() throws InterruptedException{
		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
		webtest.type("name=username", "root");
		webtest.type("name=password", "root");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(4000);
		
		webtest.mouseoverElement("link=用户与身份");
		webtest.click("link=用户信息");
		
		//禁用
		webtest.click("class=ajax-get");
		webtest.type("xpath=//input[@name='forbid_day']","1");
		webtest.click("xpath=//button[@class='btn btn-block btn-primary red-btn']");
		
		assertTrue(webtest.isTextPresent("禁用至："));
		
		//删除
		Thread.sleep(3000);
		webtest.click("link=删除");
		Thread.sleep(3000);
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("确认要执行该操作吗?", alert1.getText());
		alert1.dismiss();
		Thread.sleep(3000);
	}
	
	
	@Test(description="身份与用户_基础配置")
	public void test7() throws InterruptedException{
		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
		webtest.type("name=username", "root");
		webtest.type("name=password", "root");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(4000);
		
		webtest.mouseoverElement("link=用户与身份");
		webtest.click("link=基础配置");
		
		webtest.click("id=id_REGISTER_TYPE_normal");
		webtest.click("xpath=//*[@id='submit']");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		//全不选注册开关即为关闭注册
		webtest.open("http://localhost:8585/index.php?s=/home/index/index.html");
		webtest.mouseoverElement("link=root");
		webtest.click("class=os-icon-logout");
		webtest.click("link=注册");
		assertTrue(webtest.isTextPresent("注册已关闭"));
		webtest.click("link=返回首页");
	}
	
	@Test(description="身份与用户_登录配置")
	public void test8() throws InterruptedException{
		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
		webtest.type("name=username", "root");
		webtest.type("name=password", "root");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(4000);
		
		webtest.mouseoverElement("link=用户与身份");
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
		webtest.open("http://localhost:8585/index.php?s=/forum/index/index.html");
		Thread.sleep(3000);
		webtest.mouseoverElement("link=root");
		webtest.click("class=os-icon-logout");
		webtest.click("link=登录");
		assertTrue(webtest.isTextPresent("欢迎回到 OpenSNS v5开源社群系统 ！"));
				
	}
	
	@Test(description="运营_友情链接")
	public void test9() throws InterruptedException{
		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
		webtest.type("name=username", "root");
		webtest.type("name=password", "root");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(4000);
		
		//添加友情链接
		webtest.mouseoverElement("link=运营");
		webtest.click("link=友情链接");
		webtest.click("link=新增");
		webtest.type("name=title","百度");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='tab1']/div[2]/div/label[2]/input");
		webtest.type("xpath=//input[@name='link']", "https://www.baidu.com/");
		webtest.click("xpath=//input[@type='submit']");
		
		//打开前台
		webtest.open("http://localhost:8585/index.php?s=/home/index/index.html");
		assertTrue(webtest.isTextPresent("百度"));
	}
	
	
	@Test(description="运营_公告列表_增加")
	public void test10() throws InterruptedException{
		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
		webtest.type("name=username", "root");
		webtest.type("name=password", "root");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(4000);
		
		//新增公告
		webtest.mouseoverElement("link=运营");
		webtest.click("link=公告列表");
		webtest.click("link=新增");
		webtest.type("xpath=//input[@name='title']","你好");
		webtest.type("xpath=//input[@name='link']","https://www.baidu.com/");
		webtest.click("xpath=//button[@type='submit']");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		assertTrue(webtest.isTextPresent("你好"));
	}
	
	
	@Test(description="运营_公告列表_删除")
	public void test11() throws InterruptedException{
		webtest.click("xpath=//input[@type='checkbox']");
		webtest.click("link=删除");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
	}
	
	
	@Test(description="运营_敏感词设置")
	public void test12() throws InterruptedException{
		webtest.open("http://localhost:8585/index.php?s=/admin/role/modulerole.html");
		webtest.type("name=username", "root");
		webtest.type("name=password", "root");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(4000);
		
		webtest.mouseoverElement("link=运营");
		webtest.click("link=敏感词设置");
		webtest.click("id=id_OPEN_SENSITIVE_1");
		webtest.click("id=submit");
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals("确认该操作吗？", alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
	}
	
	@Test(description="运营_敏感词列表")
	public void test13(){
		
	}

}