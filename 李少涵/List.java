import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.utils.Common;

import net.sf.json.JSONObject;
//����--goodlist���ջ���ַlist�ͻ�ȡ�ʷ�
public class List {

	/**
	 * @author ���ٺ�
	 * ���Ի�ȡָ����Ʒ��Ϣ�б�ӿ�
	 */
	@Test
	public void listTest() throws ClientProtocolException, IOException {
		String result = HttpDriver.doGet("/common/skuList2", "goodsId=1");
		JSONObject jsonresult = JSONObject.fromObject(result);
		assertEquals(jsonresult.getString("message"), "success");
		assertEquals(jsonresult.getInt("code"), 200);
	}
	/**
	 * @author ���ٺ�
	 * ���Ի�ȡ������Ʒ��Ϣ�б�ӿ�
	 */
	@Test
	public void listTest1() throws ClientProtocolException, IOException {
		String result = HttpDriver.doGet1("/common/skuList1");
		JSONObject jsonresult = JSONObject.fromObject(result);
		assertEquals(jsonresult.getString("message"), "success");
		assertEquals(jsonresult.getInt("code"), 200);
	}
	/**
	 * @author ���ٺ�
	 * ������д������Ʒ��Ϣ�ӿ�
	 */
	@Test
	public void listTest2() throws ClientProtocolException, IOException {
		String result = HttpDriver.doGet("/common/skuList3", "goodsId=abc");
		JSONObject jsonresult = JSONObject.fromObject(result);
		assertEquals(jsonresult.getInt("code"), 400);
	}
	/**
	 * @author ���ٺ�
	 * ���Ի�ȡ��ַ��Ϣ�ӿ�
	 */
	@Test
	public void addressList() throws Exception {
		CookieStore cookieStore =Common.getCookie("20000000003", "netease123");
		String result = HttpDriver.cookieGet1("/fgadmin/address/list", cookieStore);
		JSONObject jsonresult = JSONObject.fromObject(result);
		assertEquals(jsonresult.getString("message"), "success");
		assertEquals(jsonresult.getInt("code"), 200);
	}
	/**
	 * @author ���ٺ�
	 * ���Ի�ȡ�˷���Ϣ�ӿ�
	 */
	@Test
	public void getFee() throws Exception {
		CookieStore cookieStore =Common.getCookie("20000000003", "netease123");
		String para="id=1&addressDetail=�㽭ʡ_������_������";
		String result = HttpDriver.cookieGet("/common/getTransportFee",para, cookieStore);
		JSONObject jsonresult = JSONObject.fromObject(result);
		assertEquals(jsonresult.getString("message"), "success");
		assertEquals(jsonresult.getInt("code"), 200);
	}
	
}
