import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.ParseException;
import org.testng.annotations.Test;

import net.sf.json.JSONObject;
/**
 * @author 李少涵
 * 测试登录接口
 */
public class Login {

	@Test
	public void logintest() throws ParseException, IOException {
		JSONObject user = new JSONObject();
		user.element("phoneArea", "86");
		user.element("phoneNumber", "20000000003");
		user.element("password", "netease123");
		String body = user.toString();
		String result = HttpDriver.doPost(body, "/common/fgadmin/login");
		JSONObject jsonResult = JSONObject.fromObject(result);
		assertEquals(jsonResult.getString("message"), "success");
		assertEquals(jsonResult.getInt("code"), 200);
	}
}
