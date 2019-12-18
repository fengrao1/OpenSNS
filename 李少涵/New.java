import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import net.sf.json.JSONObject;

/**
 * @author ���ٺ�
 * ������ӵ�ַ��Ϣ�ӿ�
 */
public class New {
	
	@Test
	public void addNew() throws IOException, Exception {
		CookieStore cookie = Common.getCookie("20000000003", "netease123");
		JSONObject user = new JSONObject();
		user.element("receiverName", "����");
		user.element("addressDetail", "1��3��Ԫ");
		user.element("province", "�㽭ʡ");
		user.element("city", "������");
		user.element("area", "������");
		String body = user.toString();
		String result = HttpDriver.cookiePost("/fgadmin/address/new", body, cookie);
		JSONObject jsonresult = JSONObject.fromObject(result);
		assertEquals(jsonresult.getString("message"), "success");
		assertEquals(jsonresult.getInt("code"), 200);
	}
}
