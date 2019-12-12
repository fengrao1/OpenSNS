package lishaohan;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.sql.rowset.WebRowSet;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.WebTestListener;
import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.RandNumber;
import com.webtest.utils.ReadProperties;

import freemarker.core.ReturnInstruction.Return;
import lishaohan.Login_Action;

@Listeners(WebTestListener.class)
public class L_Login extends BaseTest {
	Login_Action action;
	
//	@DataProvider(name="login_user")
//	public static Object[][] words() throws IOException{
//		ExcelDataProvider excel=new ExcelDataProvider();
//		return excel.getTestDataByExcel("E:\\selenium\\auto2019\\auto2019\\data\\login_user.xlsx", "Sheet1");
//	}
	@DataProvider(name="username")
	public Object[][] words2() throws IOException{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("data/lishaohan/L_name.xlsx", "Sheet1");
	}
	@DataProvider(name="person")
	public Object[][] words3() throws IOException{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("data/lishaohan/person.xlsx", "Sheet1");
	}
	@DataProvider(name="urlname")
	public Object[][] words4() throws IOException{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("data/lishaohan/urlName.xlsx", "Sheet1");
	}
	@DataProvider(name="psw")
	public Object[][] words5() throws IOException{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("data/lishaohan/psw.xlsx", "Sheet1");
	}
	
	@BeforeClass                //不同的地方的测试是分开的，在每个方法开始之前都会进行登录
	public void setup() throws IOException
	{
		action=new Login_Action(webtest);
		webtest.open(ReadProperties.getPropertyValue("Front_url"));
		action.login("651769329@qq.com", "123456");
		//webtes t.click1("xpath=/html/body/div[2]/div[3]/li[3]");
		webtest.pause(2000);
		webtest.click1("css=.dropdown");
		webtest.click1("css=div.link-box:nth-child(2)");
	}

	@Test(dataProvider="username",priority = 0)//在Excel表格中不能添加空字符
	public void changeName(String name,String str) throws Exception  {
		//基本资料
		webtest.clear("id=nickname");
		webtest.type("id=nickname", name);
		webtest.pause(3000);
		webtest.click1("css=button.btn");//点击保存
		assertTrue(webtest.isTextPresent(str));
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
//			webtest.click1("css=button.btn");
//			assertTrue(webtest.isTextPresent(name));
//		}
//		
	}
	
	@Test(priority = 1)
	public void changeSex() {
		//性别选项是否可以随意切换
		webtest.click1("css=label.radio-inline:nth-child(1) > input:nth-child(1)");
		System.out.println("选择成功");
		webtest.click1("css=label.radio-inline:nth-child(2) > input:nth-child(1)");
		System.out.println("选择成功");
		webtest.click1("css=label.radio-inline:nth-child(3) > input:nth-child(1)");
		System.out.println("选择成功");
		int max=3;
		int min=1;
		int number =RandNumber.getRandNumber(max, min);
		webtest.click1("css=label.radio-inline:nth-child("+number+") > input:nth-child(1)");//随机点击一个性别选项
		webtest.click1("css=button.btn");//点击保存
		assertTrue(webtest.isTextPresent("设置成功。") || webtest.isTextPresent("未修改数据。"));	
	}
//	
	@Test(priority = 2)
	public void changePalce() {
		//随机点击一个省份,然后点击城市和区县
		String[] str= {"id=J_province","id=J_city","id=J_district"};
		int MIN=1;
		String  province = null;
		String city = null;
		String district =null;		
		for(int i=0;i<3;i++) {
			int MAX=webtest.elementNumber(str[i]);
			int randNumber =RandNumber.getRandNumber(MAX, MIN);
			if (i==0) {
			    province="xpath=//*[@id=\"J_province\"]/option["+randNumber+"]";
				webtest.click1("id=J_province");
				webtest.click1(province);
			}
			if (i==1) {
				city="xpath=//*[@id=\"J_city\"]/option["+randNumber+"]";
				webtest.click1("id=J_city");
				webtest.click1(city);
			}
			if (i==2) {
				district="xpath=//*[@id=\"J_district\"]/option["+randNumber+"]";
				webtest.click1("id=J_district");
				webtest.click1(district);
			}
		}
		webtest.click1("css=button.btn");
		assertTrue(webtest.isTextPresent("设置成功。") || webtest.isTextPresent("未修改数据。"));
	}
	
	@Test(priority = 3)//(dataProvider="sign")
	public void sign(/*String text*/) {
		//修改个性签名，
		webtest.pause(5000);
		webtest.clear("id=signature");
		webtest.type("id=signature", "测试个性签名（text）");
		webtest.click1("css=button.btn");
		webtest.getRefresh();
		assertTrue(webtest.isTextPresent("测试个性签名（text）"));
	}
	
	@Test(dataProvider="person",priority = 4)//-----------------------------QQ和生日数据驱动和断言有问题
	public void person(String qq,String birth) {
		webtest.pause(5000);
		webtest.click1("css=.nav-secondary > li:nth-child(2) > a:nth-child(1)");
		webtest.pause(2000);
		webtest.clear("id=expand_1");
		webtest.pause(2000);
		webtest.type("id=expand_1", "625722535");
		webtest.pause(2000);
		webtest.clear("id=expand_2");
		webtest.type("id=expand_2", "1970-01-01");
		webtest.click1("id=expand_2");
		webtest.click1("id=submit_btn");
		assertTrue(webtest.isTextPresent("保存成功！"));  //多次点击保存按钮，提示信息修改时出错？？？	-------------------
	}
	
	@Test(priority = 5)//开发者资料
	public void person3() {
		webtest.pause(2000);
		webtest.click1("css=.nav-secondary > li:nth-child(3) > a:nth-child(1)");
		webtest.click1("id=expand_3");
		int MAX=6;
		int MIN=1;
		int randNumber =RandNumber.getRandNumber(MAX, MIN);
		webtest.click1("id=expand_3");//随意点击一个擅长语言
		webtest.click1("css=#expand_3 > option:nth-child("+randNumber+")");
		
		webtest.click1("css=#expand_4 > li:nth-child(1) > label:nth-child(1) > input:nth-child(1)");
		webtest.click1("css=#expand_4 > li:nth-child(2) > label:nth-child(1) > input:nth-child(1)");//是否承接项目
		
		webtest.clear("id=expand_5");
		webtest.type("id=expand_5", "测试测试");//简介
		webtest.pause(1000);
		webtest.click1("css=#expand_6 > li:nth-child(1) > label:nth-child(1) > input:nth-child(1)");
		webtest.pause(1000);
		webtest.click1("css=#expand_6 > li:nth-child(2) > label:nth-child(1) > input:nth-child(1)");
		webtest.pause(5000);
		webtest.click1("css=#expand_tab_2 > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(3)");
		//使用id和class为什么会找不到呢
		assertTrue(webtest.isTextPresent("保存成功！")); 
	}
//	
	@Test(dataProvider="urlname",priority = 6)//个性域名
	public void urlName(String name,String str) {
		webtest.click1("id=short_url");
		webtest.pause(1000);
		webtest.clear("id=short");
		webtest.type("id=short", name);
		webtest.pause(1000);
		webtest.click1("css=.btn");
		assertTrue(webtest.isTextPresent(str));
	}
//	
	@Test(priority = 7)
	public void tag() {//用户标签
		webtest.click1("id=tag");
		webtest.click1("css=div.one_tag:nth-child(1) > a:nth-child(1)");
		webtest.click1("css=div.one_tag:nth-child(2) > a:nth-child(1)");
		webtest.click1("css=button.btn");
		assertTrue(webtest.isTextPresent("设置成功！")); 
	}
//	
	@Test(priority = 8)//更改头像
	public void pic() {
		webtest.click1("id=avatar");
		webtest.type("name=file", "D:\\picture\\1.jpg");
		//webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		webtest.click1("id=avatar_101_original");
		webtest.click1("css=.btn");
		assertTrue(webtest.isTextPresent("头像更新成功！，页面即将跳转～")); 
	}
//	
	@Test(dataProvider="psw",priority = 9)//修改密码-------------数据驱动很难搞，有问题
	public void psw(String old,String newpws,String config) {
		webtest.click1("id=password");
		webtest.type("id=inputOldPassword", old);
		webtest.type("id=inputNewPassword", newpws);
		webtest.type("id=inputConfirmPassword", config);
		webtest.click1("css=.btn");
		assertTrue(webtest.isTextPresent("修改密码成功")); 
	}
//	
	@Test(priority = 10)//查看积分，认证等
	public void watch() {
		webtest.click1("id=score");
		webtest.pause(2000); 
		webtest.click1("id=process");
		webtest.pause(2000);
		webtest.goBack();
		webtest.click1("id=rank");
		webtest.pause(2000);
		webtest.click1("id=other");
		webtest.pause(2000);
	}

}
