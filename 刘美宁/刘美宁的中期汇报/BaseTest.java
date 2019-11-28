package com.webtest.core;


import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.Log;
import com.webtest.utils.ReadProperties;

/**
 * author:lihuanzhen
 * ��ʼ�������
 */


public class BaseTest {

	public  WebDriverEngine webtest;
	protected   WebDriver driver;
	public String driverType;

	
	

	private WebDriver newWebDriver(String driverType) throws IOException {
		WebDriver driver = null;
	 if (driverType.equalsIgnoreCase("firefox")) {
		    String firefox_driver =ReadProperties.getPropertyValue("gecko_driver");
			String firefox_path = ReadProperties.getPropertyValue("firefox_path");
			System.setProperty("webdriver.gecko.driver", firefox_driver);
			System.setProperty("webdriver.firefox.bin", firefox_path);
			driver = new FirefoxDriver();
			Log.info("Using Firefox");
		}  else if (driverType.equalsIgnoreCase("chrome")) {
			String chrome_path = ReadProperties.getPropertyValue("chrome_path");
			System.setProperty("webdriver.chrome.driver",chrome_path);
			driver = new ChromeDriver();
			Log.info("Using Chrome");
			
		}else{
			return null;
		}

		
		return driver;

	
	}


	/**
	 * 
	 *��ʼ�������
	 * 
	 */


	@BeforeClass
	public void doBeforeClass() throws Exception {

		driverType=ReadProperties.getPropertyValue("driverType");
		driver = this.newWebDriver(driverType);
		driver.manage().window().maximize();
		Log.info(driverType);
		webtest = new WebDriverEngine(driver);
		
		}
	
	
	@BeforeMethod
	public void login() throws InterruptedException{
		webtest.open("http://localhost:9898/index.php?s=/admin/public/login.html");
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.click("class=login-btn");
		//assertTrue(webtest.isTextPresent("��ǰ̨"));
		Thread.sleep(3000);
	}
	
//	@AfterMethod
//	public void loginout(){
//		webtest.click("xpath=/html/body/header/nav/div/ul[2]/li[3]/a");
//		webtest.click("xpath=/html/body/header/nav/div/ul[2]/li[3]/ul/div[2]/a[2]");
//	}
	
	
	



//	@AfterSuite
//	public void doAfterMethod() {
//		if(this.driver != null){
//			this.driver.quit();
//			}
//		Log.info("Quitted Browser");
//	}
//	

	

	
	public WebDriver getDriver() {
        return driver;
    }


	

}
