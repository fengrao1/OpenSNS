package lishaohan;

import com.webtest.core.WebDriverEngine;

public class Login_Action {
	private WebDriverEngine webtest;
	  public Login_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }
	  
	  public void login(String email,String password) 
	  {
	
		  if(is_login()) {
			  webtest.click("link=ÍË³ö");
		  }
			webtest.click("link=µÇÂ¼");
			webtest.type("name=username", email);
			webtest.type("name=password", password);
			webtest.click("class=login-btn");
		
	  }
	  
	  public boolean is_login()
	  {
		  return webtest.isElementPresent("class=os-icon-logout");
	  }
	  
	  

}
