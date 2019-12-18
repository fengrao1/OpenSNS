import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.CookieStore;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.testng.annotations.Test;

import net.sf.json.JSONObject;

/**
 * @author 李少涵
 * 测试删除地址接口
 */
public class Delet {

	@Test
	public void deleteTest() throws IOException, Exception {
		String de_url="/fgadmin/address/delete";
		CookieStore cookie = Common.getCookie( "20000000003", "netease123");
		JSONObject user = new JSONObject();
		user.element("id", "77243286");
		String body = user.toString();
		String result= HttpDriver.cookiePost(de_url, body, cookie);
		JSONObject jsonresult = JSONObject.fromObject(result);
		assertEquals(jsonresult.getString("message"), "success");
		assertEquals(jsonresult.getInt("code"), 200);
	}
}
