package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.sql.rowset.WebRowSet;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

import freemarker.core.ReturnInstruction.Return;

@Listeners(WebTestListener.class)
public class L_Login extends BaseTest {
	Login_Action action;
	
//	@DataProvider(name="login_user")
//	public static Object[][] words() throws IOException{
//		ExcelDataProvider excel=new ExcelDataProvider();
//		return excel.getTestDataByExcel("E:\\selenium\\auto2019\\auto2019\\data\\login_user.xlsx", "Sheet1");
//	}
	@DataProvider(name="username")
	public static Object[][] words2() throws IOException{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("E:\\selenium\\auto2019\\auto2019\\data\\L_name.xlsx", "Sheet1");
	}
	@DataProvider(name="person")
	public static Object[][] words3() throws IOException{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("E:\\selenium\\auto2019\\auto2019\\data\\person.xlsx", "Sheet1");
	}
	
	@BeforeMethod                //不同的地方的测试是分开的，在每个方法开始之前都会进行登录
	public void setup() throws IOException
	{
		action=new Login_Action(webtest);
		webtest.open(ReadProperties.getPropertyValue("Front_url"));
		action.login("651769329@qq.com", "aaa111");
		//webtest.click("xpath=/html/body/div[2]/div[3]/li[3]");
		webtest.click("css=.dropdown");
		webtest.click("css=div.link-box:nth-child(2)");
	}

	@Test(dataProvider="username")//在Excel表格中不能添加空字符
	public void changeName(String name) throws Exception  {
		//基本资料
		webtest.clear("id=nickname");
		webtest.type("id=nickname", name);
		webtest.pause(3000);
		webtest.click("css=button.btn");//点击保存
		assertTrue(webtest.isTextPresent("设置成功。") || webtest.isTextPresent("未修改数据。"));
//		webtest.getRefresh();
		//因为无论是成功修改或是无法成功修改，如果不刷新在页面内都没有进行修改的名字，
		//所以采用刷新后进行判断是否修改成功，若未修改成功，再次填入，截屏，捕获失败原因
//		if(webtest.isTextPresent(name)) {
//			System.out.println("姓名更改成功");
//		}
//		else {
//			webtest.clear("id=nickname");
//			webtest.type("id=nickname", name);
//			webtest.pause(3000);
//			webtest.click("css=button.btn");
//			assertTrue(webtest.isTextPresent(name));
//		}
//		
	}
	
	@Test
	public void changeSex() {
		//性别选项是否可以随意切换
		webtest.click("css=label.radio-inline:nth-child(1) > input:nth-child(1)");
		System.out.println("选择成功");
		webtest.click("css=label.radio-inline:nth-child(2) > input:nth-child(1)");
		System.out.println("选择成功");
		webtest.click("css=label.radio-inline:nth-child(3) > input:nth-child(1)");
		System.out.println("选择成功");
		Random rand = new Random();
		int number =rand.nextInt(3 - 1 + 1) + 1;
		webtest.click("css=label.radio-inline:nth-child("+number+") > input:nth-child(1)");//随机点击一个性别选项
		webtest.click("css=button.btn");//点击保存
		assertTrue(webtest.isTextPresent("设置成功。") || webtest.isTextPresent("未修改数据。"));	
	}
	
	@Test
	public void changePalce() {
		//随机点击一个省份,然后点击城市和区县
		String[] str= {"id=J_province","id=J_city","id=J_district"};
		int MIN=1;
		String  province = null;
		String city = null;
		String district =null;		
		Random rand = new Random();
		for(int i=0;i<3;i++) {
			int MAX=webtest.elementNumber(str[i]);
			int randNumber =rand.nextInt(MAX - MIN + 1) + MIN;
			if (i==0) {
			    province="xpath=//*[@id=\"J_province\"]/option["+randNumber+"]";
				webtest.click("id=J_province");
				webtest.click(province);
			}
			if (i==1) {
				city="xpath=//*[@id=\"J_city\"]/option["+randNumber+"]";
				webtest.click("id=J_city");
				webtest.click(city);
			}
			if (i==2) {
				district="xpath=//*[@id=\"J_district\"]/option["+randNumber+"]";
				webtest.click("id=J_district");
				webtest.click(district);
			}
		}
		webtest.click("css=button.btn");
		assertTrue(webtest.isTextPresent("设置成功。") || webtest.isTextPresent("未修改数据。"));
	}
	
	@Test//(dataProvider="sign")
	public void sign(/*String text*/) {
		//修改个性签名，
		webtest.pause(5000);
		webtest.clear("id=signature");
		webtest.type("id=signature", "测试个性签名（text）");
		webtest.click("css=button.btn");
		webtest.getRefresh();
		assertTrue(webtest.isTextPresent("测试个性签名（text）"));
	}
	
	@Test(dataProvider="person")
	public void person(String qq,String birth) {
		webtest.pause(5000);
		webtest.click("css=.nav-secondary > li:nth-child(2) > a:nth-child(1)");
		webtest.pause(2000);
		webtest.clear("id=expand_1");
		webtest.pause(2000);
		webtest.type("id=expand_1", qq);
		webtest.pause(2000);
		webtest.clear("id=expand_2");
		webtest.type("id=expand_2", birth);
		webtest.click("id=expand_2");
		webtest.click("id=submit_btn");
		webtest.pause(1000);
		webtest.getRefresh();
		webtest.click("css=.nav-secondary > li:nth-child(2) > a:nth-child(1)");
		if(webtest.isTextPresent(qq)&&birth.contains("19700101")) {
				System.out.println("更改成功");
				assertTrue(true);
		}
		else {
			if (webtest.isTextPresent(qq)&&webtest.isTextPresent("1970-01-01")) {
				System.out.println("更改失败");
				assertTrue(false);
			}
			else if(webtest.isTextPresent(qq)&&webtest.getValue("id=expand_2").contains(birth)){
				System.out.println("更改成功");
				assertTrue(true);
			}
		}
		
		
	}

}
