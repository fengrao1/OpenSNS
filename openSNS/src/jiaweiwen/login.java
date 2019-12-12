package jiaweiwen;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebDriverEngine;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.core.WebTestListener;
import com.webtest.utils.ReadProperties;
import java.util.Properties;

//��¼ģ��
@Listeners(WebTestListener.class)
public class login extends BaseTest{
	//��������
	@DataProvider(name="user_name")
	public Object[][] data()throws IOException {
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel.getTestDataByExcel("data/jiaweiwen/data.xlsx","Sheet1");
	}
	
	//�������� ��12����������
	@Test(dataProvider="user_name",description="��¼")
	public void testLogin(String u_name,String p_word,String string) throws InterruptedException, IOException {
		//�����ļ���ȡ��ַ
		String opensns_url =ReadProperties.getPropertyValue("base_url");
		//��ҳ��
		webtest.open(opensns_url);
		//�ı�������
		webtest.click("link=��¼");
		webtest.type("name=username", u_name);
		webtest.type("name=password", p_word);
		Thread.sleep(2000);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent(string));
		webtest.click("xpath=//span[@class='user-name text-ellipsis']");
		webtest.click("xpath=//div[@event-node='logout']");
	}	
}


