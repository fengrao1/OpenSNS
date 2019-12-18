package com.opensns.frontstage;

import com.webtest.core.WebDriverEngine;
/**
 * @author 李少涵
 * 登录类
 */
public class Login_Action {
	private WebDriverEngine webtest;
	  public Login_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }
	  
	  public void login(String email,String password) 
	  {
	
		  if(is_login()) {
			  webtest.click("link=退出");
		  }
			webtest.click("link=登录");
			webtest.type("name=username", email);
			webtest.type("name=password", password);
			webtest.click("class=login-btn");
		
	  }
	  
	  public boolean is_login()
	  {
		  return webtest.isElementPresent("class=os-icon-logout");
	  }
	  
	  

}
