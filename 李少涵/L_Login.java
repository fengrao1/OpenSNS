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
	
	@BeforeMethod                //��ͬ�ĵط��Ĳ����Ƿֿ��ģ���ÿ��������ʼ֮ǰ������е�¼
	public void setup() throws IOException
	{
		action=new Login_Action(webtest);
		webtest.open(ReadProperties.getPropertyValue("Front_url"));
		action.login("651769329@qq.com", "aaa111");
		//webtest.click("xpath=/html/body/div[2]/div[3]/li[3]");
		webtest.click("css=.dropdown");
		webtest.click("css=div.link-box:nth-child(2)");
	}

	@Test(dataProvider="username")//��Excel����в�����ӿ��ַ�
	public void changeName(String name) throws Exception  {
		//��������
		webtest.clear("id=nickname");
		webtest.type("id=nickname", name);
		webtest.pause(3000);
		webtest.click("css=button.btn");//�������
		assertTrue(webtest.isTextPresent("���óɹ���") || webtest.isTextPresent("δ�޸����ݡ�"));
//		webtest.getRefresh();
		//��Ϊ�����ǳɹ��޸Ļ����޷��ɹ��޸ģ������ˢ����ҳ���ڶ�û�н����޸ĵ����֣�
		//���Բ���ˢ�º�����ж��Ƿ��޸ĳɹ�����δ�޸ĳɹ����ٴ����룬����������ʧ��ԭ��
//		if(webtest.isTextPresent(name)) {
//			System.out.println("�������ĳɹ�");
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
		//�Ա�ѡ���Ƿ���������л�
		webtest.click("css=label.radio-inline:nth-child(1) > input:nth-child(1)");
		System.out.println("ѡ��ɹ�");
		webtest.click("css=label.radio-inline:nth-child(2) > input:nth-child(1)");
		System.out.println("ѡ��ɹ�");
		webtest.click("css=label.radio-inline:nth-child(3) > input:nth-child(1)");
		System.out.println("ѡ��ɹ�");
		Random rand = new Random();
		int number =rand.nextInt(3 - 1 + 1) + 1;
		webtest.click("css=label.radio-inline:nth-child("+number+") > input:nth-child(1)");//������һ���Ա�ѡ��
		webtest.click("css=button.btn");//�������
		assertTrue(webtest.isTextPresent("���óɹ���") || webtest.isTextPresent("δ�޸����ݡ�"));	
	}
	
	@Test
	public void changePalce() {
		//������һ��ʡ��,Ȼ�������к�����
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
		assertTrue(webtest.isTextPresent("���óɹ���") || webtest.isTextPresent("δ�޸����ݡ�"));
	}
	
	@Test//(dataProvider="sign")
	public void sign(/*String text*/) {
		//�޸ĸ���ǩ����
		webtest.pause(5000);
		webtest.clear("id=signature");
		webtest.type("id=signature", "���Ը���ǩ����text��");
		webtest.click("css=button.btn");
		webtest.getRefresh();
		assertTrue(webtest.isTextPresent("���Ը���ǩ����text��"));
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
				System.out.println("���ĳɹ�");
				assertTrue(true);
		}
		else {
			if (webtest.isTextPresent(qq)&&webtest.isTextPresent("1970-01-01")) {
				System.out.println("����ʧ��");
				assertTrue(false);
			}
			else if(webtest.isTextPresent(qq)&&webtest.getValue("id=expand_2").contains(birth)){
				System.out.println("���ĳɹ�");
				assertTrue(true);
			}
		}
		
		
	}

}
