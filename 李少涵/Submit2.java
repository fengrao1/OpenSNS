import java.io.IOException;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;
import com.edu.utils.Common;
import net.sf.json.JSONObject;

/**
 * @author 李少涵
 * 测试提交订单接口
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
		user.element("receiverName", "张三");
		user.element("addressDetail", "浙江大学");
		user.element("province", "浙江省");
		user.element("city", "杭州市");
		user.element("area", "滨江区");
		user.element("transportFee", 0);
		String body=user.toString();
		HttpDriver.cookiePost(submit_url, body, cookieStore);
	}
}
