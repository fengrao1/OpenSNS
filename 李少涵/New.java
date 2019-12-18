import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import net.sf.json.JSONObject;

/**
 * @author 李少涵
 * 测试添加地址信息接口
 */
public class New {
	
	@Test
	public void addNew() throws IOException, Exception {
		CookieStore cookie = Common.getCookie("20000000003", "netease123");
		JSONObject user = new JSONObject();
		user.element("receiverName", "张三");
		user.element("addressDetail", "1栋3单元");
		user.element("province", "浙江省");
		user.element("city", "杭州市");
		user.element("area", "滨江区");
		String body = user.toString();
		String result = HttpDriver.cookiePost("/fgadmin/address/new", body, cookie);
		JSONObject jsonresult = JSONObject.fromObject(result);
		assertEquals(jsonresult.getString("message"), "success");
		assertEquals(jsonresult.getInt("code"), 200);
	}
}
