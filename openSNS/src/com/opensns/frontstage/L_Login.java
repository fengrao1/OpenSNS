package com.opensns.frontstage;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webtest.core.WebTestListener;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.RandNumber;
import com.webtest.utils.ReadProperties;
/**
 * @author ���ٺ�
 * �������á�������ҳ
 */
@Listeners(WebTestListener.class)
public class L_Login extends BaseTest {
	Login_Action action;
	
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
	
	@BeforeClass                //��ͬ�ĵط��Ĳ����Ƿֿ��ģ���ÿ��������ʼ֮ǰ������е�¼
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

	@Test(dataProvider="username",priority = 0)//��Excel����в�����ӿ��ַ�
	public void changeName(String name,String str) throws Exception  {
		//��������
		webtest.clear("id=nickname");
		webtest.type("id=nickname", name);
		webtest.pause(3000);
		webtest.click1("css=button.btn");//�������
		assertTrue(webtest.isTextPresent(str));	
	}
	
	@Test(priority = 1)
	public void changeSex() {
		//�Ա�ѡ���Ƿ���������л�
		webtest.click1("css=label.radio-inline:nth-child(1) > input:nth-child(1)");
		System.out.println("ѡ��ɹ�");
		webtest.click1("css=label.radio-inline:nth-child(2) > input:nth-child(1)");
		System.out.println("ѡ��ɹ�");
		webtest.click1("css=label.radio-inline:nth-child(3) > input:nth-child(1)");
		System.out.println("ѡ��ɹ�");
		int max=3;
		int min=1;
		int number =RandNumber.getRandNumber(max, min);
		webtest.click1("css=label.radio-inline:nth-child("+number+") > input:nth-child(1)");//������һ���Ա�ѡ��
		webtest.click1("css=button.btn");//�������
		webtest.pause(1000);
		assertTrue(webtest.isTextPresent("���óɹ���") || webtest.isTextPresent("δ�޸����ݡ�"));	
	}
//	
	@Test(priority = 2)
	public void changePalce() {
		//������һ��ʡ��,Ȼ�������к�����
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
		assertTrue(webtest.isTextPresent("���óɹ���") || webtest.isTextPresent("δ�޸����ݡ�"));
	}
	
	@Test(priority = 3)
	public void sign() {
		//�޸ĸ���ǩ����
		webtest.pause(5000);
		webtest.clear("id=signature");
		webtest.type("id=signature", "���Ը���ǩ����text��");
		webtest.click1("css=button.btn");
		webtest.getRefresh();
		assertTrue(webtest.isTextPresent("���Ը���ǩ����text��"));
	}
	
	@Test(dataProvider="person",priority = 4)
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
		assertTrue(webtest.isTextPresent("����ɹ���"));
	}
	
	@Test(priority = 5)//����������
	public void person3() {
		webtest.pause(2000);
		webtest.click1("css=.nav-secondary > li:nth-child(3) > a:nth-child(1)");
		webtest.click1("id=expand_3");
		int MAX=6;
		int MIN=1;
		int randNumber =RandNumber.getRandNumber(MAX, MIN);
		webtest.click1("id=expand_3");//������һ���ó�����
		webtest.click1("css=#expand_3 > option:nth-child("+randNumber+")");
		
		webtest.click1("css=#expand_4 > li:nth-child(1) > label:nth-child(1) > input:nth-child(1)");
		webtest.click1("css=#expand_4 > li:nth-child(2) > label:nth-child(1) > input:nth-child(1)");//�Ƿ�н���Ŀ
		
		webtest.clear("id=expand_5");
		webtest.type("id=expand_5", "���Բ���");//���
		webtest.pause(1000);
		webtest.click1("css=#expand_6 > li:nth-child(1) > label:nth-child(1) > input:nth-child(1)");
		webtest.pause(1000);
		webtest.click1("css=#expand_6 > li:nth-child(2) > label:nth-child(1) > input:nth-child(1)");
		webtest.pause(5000);
		webtest.click1("css=#expand_tab_2 > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(3)");
		//ʹ��id��classΪʲô���Ҳ�����
		webtest.pause(2000);
		assertTrue(webtest.isTextPresent("����ɹ���")||webtest.isTextPresent("������ѡ��һ��")); 
		webtest.pause(2000);
	}
	
	@Test(dataProvider="urlname",priority = 6)//��������
	public void urlName(String name,String str) {
		webtest.click1("id=short_url");
		webtest.pause(1000);
		webtest.clear("id=short");
		webtest.type("id=short", name);
		webtest.pause(1000);
		webtest.click1("css=.btn");
		assertTrue(webtest.isTextPresent(str));
	}
	
	@Test(priority = 7)
	public void tag() {//�û���ǩ
		webtest.click1("id=tag");
		webtest.click1("css=div.one_tag:nth-child(1) > a:nth-child(1)");
		webtest.click1("css=div.one_tag:nth-child(2) > a:nth-child(1)");
		webtest.click1("css=button.btn");
		assertTrue(webtest.isTextPresent("���óɹ���")); 
	}
	
	@Test(priority = 8)//����ͷ��
	public void pic() throws Exception {
		webtest.click1("id=avatar");
		webtest.type("name=file", "D:\\picture\\1.jpg");
		//webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		webtest.click1("id=avatar_101_original");
		Thread.sleep(3000);
		webtest.click1("css=.btn");
		assertTrue(webtest.isTextPresent("ͷ����³ɹ�����ҳ�漴����ת��")); 
	}
	
	@Test(dataProvider="psw",priority = 9)//�޸�����-------------�����������Ѹ㣬������
	public void psw(String old,String newpws,String config) {
		webtest.click1("id=password");
		webtest.type("id=inputOldPassword", old);
		webtest.type("id=inputNewPassword", newpws);
		webtest.type("id=inputConfirmPassword", config);
		webtest.click1("css=.btn");
		assertTrue(webtest.isTextPresent("�޸�����ɹ�")); 
	}
	
	@Test(priority = 10)//�鿴���֣���֤��
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
