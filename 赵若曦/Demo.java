package opensns;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import static org.testng.Assert.assertTrue;
public class Demo extends BaseTest {
	
	@Test(description="����΢��-����")
	public void publish1() throws InterruptedException {
		webtest.click("link=΢��");
		webtest.click("title=΢��");
		Thread.sleep(2000);
		webtest.click("class=add-weibo");
		Thread.sleep(2000);
		webtest.click("class=icon-zs");
		Thread.sleep(1000);
		webtest.type("id=weibo_content","����һ�����ֶ�̬");
		webtest.click("class=send-right");
		assertTrue(webtest.isTextPresent("�����ɹ���"));
	}
	
	@Test(description="����΢��-����")
	public void publish3() throws InterruptedException {
		webtest.click("link=΢��");
		webtest.click("title=΢��");
		Thread.sleep(2000);
		webtest.click("class=add-weibo");
		Thread.sleep(2000);
		webtest.click("class=icon-zs");
		Thread.sleep(1000);
		webtest.type("id=weibo_content","[deyi]");
		webtest.click("class=send-right");
		assertTrue(webtest.isTextPresent("�����ɹ���"));
	}
	
	@Test(description="����΢��-�հ�����")
	public void publish2() throws InterruptedException {
		webtest.click("link=΢��");
		webtest.click("title=΢��");
		Thread.sleep(2000);
		webtest.click("class=add-weibo");
		Thread.sleep(2000);
		webtest.click("class=icon-zs");
		Thread.sleep(1000);
		webtest.type("id=weibo_content","");
		webtest.click("class=send-right");
		assertTrue(webtest.isTextPresent("����ʧ��"));
	}
	

	@Test(description="����΢��-����")
	public void publish4() throws Exception {
		webtest.click("link=΢��");
		webtest.click("title=΢��");
		Thread.sleep(2000);
		webtest.click("class=add-weibo");
		Thread.sleep(2000);
		webtest.click("class=icon-zs");
		webtest.click("class=iconfont icon-tianjiahuati i-ht");
		Thread.sleep(1000);
//		webtest.type("id=weibo_content","���Ի���");
		webtest.click("class=send-right");
		assertTrue(webtest.isTextPresent("�����ɹ���"));
	}
	
	@Test(description="ȡ������΢��")
	public void publish5() throws InterruptedException {
		webtest.click("link=΢��");
		webtest.click("title=΢��");
		Thread.sleep(2000);
		webtest.click("class=add-weibo");
		Thread.sleep(2000);
		webtest.click("class=icon-zs");
		Thread.sleep(1000);
		webtest.type("id=weibo_content","abcd");
		webtest.click("class=iconfont icon-cuo");
		assertTrue(webtest.isTextPresent("ȡ������"));
	}
	
	@Test(description="����")
	public void DianZan() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("id=support_Weibo_weibo_13");
	}
	
	
	@Test(description="�鿴�ҵĹ�ע")
	public void Follow() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("id=concerned");
		assertTrue(webtest.isTextPresent("�ҵĹ�ע"));
	}
	
	@Test(description="�鿴ȫվ��̬")
	public void AllTrends() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("id=all");
		assertTrue(webtest.isTextPresent("ȫվ��̬"));
	}
	
	
	@Test(description="�鿴���Ŷ�̬")
	public void HotTrends() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("id=hot");
		assertTrue(webtest.isTextPresent("���Ŷ�̬"));
	}
	
	@Test(description="�鿴�ҵ�ϲ��")
	public void MyLike() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("id=fav");
		assertTrue(webtest.isTextPresent("�ҵ�ϲ��"));
	}
	
	@Test(description="����")
	public void Comment() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(3000);
		webtest.click("data-weibo-id=14");
		webtest.type("xpath=//input[@placeholder='���ۣ�Ctrl+Enter��']","������");
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("���۳ɹ�"));
	}
	
	@Test(description="����")
	public void Invite() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("link=��������");
		webtest.click("link=�������б�");
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("���������"));
	}
	
	@Test(description="����������")
	public void Invite2() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("link=��������");
		webtest.click("link=����������");
		Thread.sleep(1000);
		webtest.click("link=�һ�����");
		Thread.sleep(2000);
		webtest.click("link=�һ�");
		Thread.sleep(2000);
		webtest.click("link=����������");
		assertTrue(webtest.isTextPresent("���������"));
	}
	
	@Test(description="�鿴���а�")
	public void Rank() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("link=����");
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("���а�"));
	}
	
	@Test(description="ǩ��")
	public void Register() throws Exception{
		webtest.click("link=΢��");
		Thread.sleep(2000);
		webtest.click("class=c-icon c-icon-checking");
		webtest.click("link=ǩ��");
		Thread.sleep(2000);
		webtest.click("class=btn-sign show-check");
//		assertTrue(webtest.isTextPresent("ǩ���ɹ�"));
	}
	
	
	
	
	
	
	
	
	
}




















