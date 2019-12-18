import java.io.IOException;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;
import com.edu.utils.Common;
import net.sf.json.JSONObject;

/**
 * @author ���ٺ�
 * �����ύ�����ӿ�
 */
public class Submit2 {
	String submit_url="/fgadmin/orders/submit";
	String base_url="http://127.0.0.1:9999";
	@Test
	public void submitTest() throws IOException, Exception {
		CookieStore cookieStore =Common.getCookie("20000000003", "netease123");
		JSONObject user=new JSONObject();
		user.element("skuIds", "2,3");
		user.element("skuNumbers", "1,1");
		user.element("stockIds", "74966312,74966313");
		user.element("receiverName", "����");
		user.element("addressDetail", "�㽭��ѧ");
		user.element("province", "�㽭ʡ");
		user.element("city", "������");
		user.element("area", "������");
		user.element("transportFee", 0);
		String body=user.toString();
		HttpDriver.cookiePost(submit_url, body, cookieStore);
	}
}
