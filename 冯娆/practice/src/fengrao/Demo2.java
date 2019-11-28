package fengrao;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import com.webtest.core.BaseTest;
@Listeners(com.webtest.core.ApiListener.class)
public class Demo2 extends BaseTest {
	/**
	 * 根据标题或摘要关键字查找资讯
	 **/
	@Test(description="根据不存在的内容查找")
	public void FindBytitle1() throws Exception  {	

		webtest.click("link=资讯");
		webtest.type("xpath=//input[@placeholder='输入标题/摘要关键字']","0");	
		webtest.tapClickEnter();//回车键
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("该类型下没有资讯~"));
	}
	@Test(description="根据标题查找")
	public void FindBytitle2() throws Exception  {		
		webtest.click("link=资讯");
		webtest.type("xpath=//input[@placeholder='输入标题/摘要关键字']","娱乐");	
		webtest.tapClickEnter();//回车键
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("娱乐"));
		assertTrue(!webtest.isTextPresent("该类型下没有资讯~"));
	}
	@Test(description="根据摘要关键字查找")
	public void FindByContent() throws Exception  {		
		webtest.click("link=资讯");
		webtest.type("xpath=//input[@placeholder='输入标题/摘要关键字']","这篇资讯主要");	
		webtest.tapClickEnter();//回车键
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("这篇资讯主要"));
		assertTrue(!webtest.isTextPresent("该类型下没有资讯~"));
	}
}
