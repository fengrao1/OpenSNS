package xiangmu;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;

@Listeners(com.webtest.core.ApiListener.class)
public class Demo4 extends BaseTest{
	
//��վ��ҳ�Ĳ�������
	
	
//	��������4-1	
	@Test(description="�����Ʒ��ҳ")
	public void test41() throws Exception  {
		webtest.click("link=��ҳ");
		webtest.click("link=��Ʒ��ҳ");
		webtest.getWindow(1);		
		assertTrue(webtest.isTextPresent("��Ʒ"));
		driver.close();
	}
	

//	��������4-2	
	@Test(description="�����Ʒ��ҳ")
	public void test42() throws Exception  {
		webtest.click("link=��ҳ");
		webtest.click("link=��������");
		Thread.sleep(3000);
		webtest.getWindow(1);		
		assertTrue(webtest.isTextPresent("�ҵ���Ⱥ"));
		driver.close();
	}	
	
//	��������4-3	
	@Test(description="����˽�����")
	public void test43() throws Exception  {
		webtest.click("link=��ҳ");
		webtest.click("class=ghost-button");
		Thread.sleep(3000);	
	}

//	��������4-4	
//	@Test(description="����˽�����")
//	public void test44() throws Exception  {
//		webtest.click("link=��ҳ");
//		webtest.mouseoverElement("/html/body/div[5]/div/div/div[1]");
//		webtest.click("xpath=/html/body/div[5]/div/div/div[1]/div/div");
//		Thread.sleep(3000);	
//		webtest.getWindow(1);		
//		assertTrue(webtest.isTextPresent("��������"));
//		driver.close();
//	}
	

	
	

}
