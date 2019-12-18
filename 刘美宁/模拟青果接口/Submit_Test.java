package com.example.demo.QGtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 李少涵
 *         提交订单
 */

@RestController
public class Submit_Test {
	@ResponseBody
	@RequestMapping(value = "/fgadmin/orders/submit", method = RequestMethod.POST)
	public Return2 submit(HttpServletRequest request) {
		Map<String,Object> address = new HashMap<String,Object>();
		Map<String, Object> ad = Address.getAdd("2,3", "1,1", "74966312,74966313", "张三", "1栋3单元", "浙江省", "杭州市", "滨江区",0);
		Return2 result = new Return2();
		int num = 0;
		Cookie[] cookies = request.getCookies();
		if (Objects.isNull(cookies)) {
			result.setCode(400);
			result.setMessage("错误，必须携带Cookie");
			return result;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
				for (int i = 0; i < ad.size(); i++) {
					if (ad.get(i) == address.get(i)) {
						num++;
					} else {
						result.setCode(400);
						result.setMessage("请求失败");
						return result;
					}
				}
				if (num == ad.size()) {
					result.setCode(200);
					result.setMessage("success");
					ArrayList<Map<String, Object>> addre = new ArrayList<Map<String, Object>>();
					addre.add(ad);
					result.setResult(addre);
					return result;
				}
			}
		}
		result.setCode(400);
		result.setMessage("请求失败");
		return result;
	}
}
