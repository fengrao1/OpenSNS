import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.utils.Common;

import net.sf.json.JSONObject;
//可用--goodlist和收货地址list和获取邮费
public class List {

	/**
	 * @author 李少涵
	 * 测试获取指定商品信息列表接口
	 */
	@Test
	public void listTest() throws ClientProtocolException, IOException {
		String result = HttpDriver.doGet("/common/skuList2", "goodsId=1");
		JSONObject jsonresult = JSONObject.fromObject(result);
		assertEquals(jsonresult.getString("message"), "success");
		assertEquals(jsonresult.getInt("code"), 200);
	}
	/**
	 * @author 李少涵
	 * 测试获取所有商品信息列表接口
	 */
	@Test
	public void listTest1() throws ClientProtocolException, IOException {
		String result = HttpDriver.doGet1("/common/skuList1");
		JSONObject jsonresult = JSONObject.fromObject(result);
		assertEquals(jsonresult.getString("message"), "success");
		assertEquals(jsonresult.getInt("code"), 200);
	}
	/**
	 * @author 李少涵
	 * 测试填写错误商品信息接口
	 */
	@Test
	public void listTest2() throws ClientProtocolException, IOException {
		String result = HttpDriver.doGet("/common/skuList3", "goodsId=abc");
		JSONObject jsonresult = JSONObject.fromObject(result);
		assertEquals(jsonresult.getInt("code"), 400);
	}
	/**
	 * @author 李少涵
	 * 测试获取地址信息接口
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
	 * @author 李少涵
	 * 测试获取运费信息接口
	 */
	@Test
	public void getFee() throws Exception {
		CookieStore cookieStore =Common.getCookie("20000000003", "netease123");
		String para="id=1&addressDetail=浙江省_杭州市_滨江区";
		String result = HttpDriver.cookieGet("/common/getTransportFee",para, cookieStore);
		JSONObject jsonresult = JSONObject.fromObject(result);
		assertEquals(jsonresult.getString("message"), "success");
		assertEquals(jsonresult.getInt("code"), 200);
	}
	
}
