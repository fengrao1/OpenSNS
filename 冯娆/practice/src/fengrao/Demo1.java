package fengrao;

import static org.testng.Assert.assertTrue;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
@Listeners(com.webtest.core.ApiListener.class)
public class Demo1 extends BaseTest{
	
	@DataProvider(name="TestData")
	public static Object[][] words() throws Exception{
		ExcelDataProvider d = new ExcelDataProvider();
		return d.getTestDataByExcel("d:\\txt\\TestData1.xlsx","Sheet1");
	}
/**
 * 搜索框查找用户
 **/
	@Test(description="查找存在的用户")
	public void FindPeopleByName1() throws Exception  {	
		
		webtest.click("link=会员展示");
		webtest.type("xpath=//input[@placeholder='昵称']","feng1");	
		webtest.tapClickEnter();//回车键
		assertTrue(webtest.isTextPresent("feng1"));
		assertTrue(webtest.isTextPresent("积分"));	
	}
	@Test(description="查找空值")
	public void FindPeopleByName2() throws Exception  {	
		webtest.click("link=会员展示");
		webtest.type("xpath=//input[@placeholder='昵称']","");	
		webtest.tapClickEnter();//回车键
		assertTrue(webtest.isTextPresent("feng1"));
		assertTrue(webtest.isTextPresent("root"));
		assertTrue(webtest.isTextPresent("积分"));	
	}
	@Test(description="查找不存在的用户")
	public void FindPeopleByName3() throws Exception  {	
		webtest.click("link=会员展示");
		webtest.type("xpath=//input[@placeholder='昵称']","feng0");	
		webtest.tapClickEnter();//回车键
		assertTrue(!webtest.isTextPresent("积分"));
	}

/**
 * 通过身份查找用户
 * @throws Exception
 */
	@Test(description="查找开发者")
	public void FindPeopleByStatus1() throws Exception  {	
		webtest.click("link=会员展示");
		webtest.mouseoverElement("xpath=//*[text()='默认']");
		webtest.click("link=开发者");
		assertTrue(webtest.isTextPresent("feng"));
		assertTrue(webtest.isTextPresent("feng1"));
		assertTrue(webtest.isTextPresent("积分"));
	}
	@Test(description="查找站长")
	public void FindPeopleByStatus2() throws Exception  {	
		webtest.click("link=会员展示");
		webtest.mouseoverElement("xpath=//*[text()='默认']");
		webtest.click("link=站长");
		assertTrue(webtest.isTextPresent("feng2"));
		assertTrue(webtest.isTextPresent("feng3"));
		assertTrue(webtest.isTextPresent("积分"));
	}
	@Test(description="普通用户")
	public void FindPeopleByStatus3() throws Exception  {	
		webtest.click("link=会员展示");
		webtest.click("link=普通用户");
		assertTrue(webtest.isTextPresent("root"));
		assertTrue(webtest.isTextPresent("feng2"));
		assertTrue(webtest.isTextPresent("积分"));
	}
	
/***
 * 关注和取消关注，粉丝数量显示,关注人数显示
 */	
	@Test(description="进入用户个人主页取消关注",dataProvider="TestData")
	public void HandlePeople1(String name) throws Exception  {	
		webtest.click("link=会员展示");
		webtest.type("xpath=//input[@placeholder='昵称']",name);	
		webtest.tapClickEnter();
		webtest.click("link="+name);
		Thread.sleep(2000);
		if(webtest.isTextPresent("已关注")){
			webtest.click("xpath=//button[contains(text(),'已关注')]");
			assertTrue(webtest.isTextPresent("关注"));
		}
		
	}
	@Test(description="关注用户",dataProvider="TestData")
	public void HandlePeople2(String name) throws Exception  {	
		webtest.click("link=会员展示");
		webtest.type("xpath=//input[@placeholder='昵称']",name);	
		webtest.tapClickEnter();
		webtest.click("link="+name);
		Thread.sleep(2000);
		if(!webtest.isTextPresent("已关注")){
			List<WebElement> list2=driver.findElements(By.tagName("button"));
			list2.get(0).click();
			Thread.sleep(5000);
			assertTrue(webtest.isTextPresent("已关注"));
		}		
	}
	

	@Test(description="指定用户显示的粉丝人数变化")
	public void HandlePeople3() throws Exception  {	
		webtest.click("link=会员展示");
		webtest.type("xpath=//input[@placeholder='昵称']","feng1");	
		webtest.tapClickEnter();
		Thread.sleep(3000);
		String number=driver.findElement(By.className("f2")).getText();//关注人数
		int n1=Integer.parseInt(number);
		System.out.println(number);
		Thread.sleep(3000);
		webtest.click("link=feng1");  //参数化
		
		if(webtest.isTextPresent("已关注")){
			webtest.click("xpath=//button[contains(text(),'已关注')]");
		}else{
			List<WebElement> list2=driver.findElements(By.tagName("button"));
			list2.get(0).click();
			Thread.sleep(5000);
			assertTrue(webtest.isTextPresent("已关注"));
		}
		webtest.click("link=会员展示");
		webtest.type("xpath=//input[@placeholder='昵称']","feng1");	
		webtest.tapClickEnter();
		Thread.sleep(3000);
		String number1=driver.findElement(By.className("f2")).getText();//关注或取消关注后的关注人数
		System.out.println(number);
		int n2=Integer.parseInt(number);
		assertTrue(n1!=n2);
	}
	@Test(description="登录用户的关注人数变化")
	public void HandlePeople4() throws Exception  {	
		webtest.click("link=会员展示");
		webtest.type("xpath=//input[@placeholder='昵称']","feng");	
		webtest.tapClickEnter();
		Thread.sleep(3000);
		List<WebElement> list=driver.findElements(By.className("fo2"));
		String number=list.get(0).getText();
		System.out.println(number);
		int n1=Integer.parseInt(number);
		Thread.sleep(3000);
		webtest.type("xpath=//input[@placeholder='昵称']","feng1");
		webtest.click("link=feng1");  //参数化
		if(webtest.isTextPresent("已关注")){
			webtest.click("xpath=//button[contains(text(),'已关注')]");
		}else{
			List<WebElement> list1=driver.findElements(By.tagName("button"));
			list1.get(0).click();
		}
		
		webtest.click("link=会员展示");
		webtest.type("xpath=//input[@placeholder='昵称']","feng");	
		webtest.tapClickEnter();
		Thread.sleep(3000);
		List<WebElement> list2=driver.findElements(By.className("fo2"));
		String number1=list2.get(0).getText();
		System.out.println(number1);
		int n2=Integer.parseInt(number1);
		assertTrue(n1!=n2);
	}
/**
 * 发起聊天
 * @throws Exception
 */
	@Test(description="对指定用户发起聊天")
	public void HandlePeople5() throws Exception  {	
		webtest.click("link=会员展示");
		webtest.type("xpath=//input[@placeholder='昵称']","feng1");	
		webtest.tapClickEnter();
		webtest.click("link=feng1");
		List<WebElement> list2=driver.findElements(By.tagName("button"));
		list2.get(1).click();
		Thread.sleep(5000);
		webtest.click("xpath=//button[contains(text(),'聊天')]");
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("发送"));
		
	}
/**
 * 按地区找人
 */
	@Test(description="按地区找人并关注，有用户存在的地区")
	public void FindPeopleByAddress1(){
		webtest.click("link=会员展示");
		webtest.click("link=按地区找人");
		webtest.click("link=河北省(2)");
		webtest.click("link=石家庄市(2)");
		webtest.click("link=裕华区(2)");
		assertTrue(webtest.isTextPresent("feng1"));
		assertTrue(webtest.isTextPresent("feng3"));
		assertTrue(webtest.isTextPresent("积分"));
	}
	@Test(description="按地区找人并关注，无用户存在的地区")
	public void FindPeopleByAddress2(){
		webtest.click("link=会员展示");
		webtest.click("link=按地区找人");
		webtest.click("link=北京市(0)");
		webtest.click("link=北京市(0)");
		webtest.click("link=东城区(0)");
		assertTrue(!webtest.isTextPresent("积分"));
	}	
}
