package com.example.demo.test;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;
@RestController
public class TransportFee {
	@ResponseBody
	@RequestMapping(value = "/common/getTransportFee", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public JSONObject getFee(@RequestParam int id, @RequestParam String addressDetail) {
		JSONObject result = new JSONObject();
		if (id == 1 && addressDetail.equals("浙江省_杭州市_滨江区")) {
			result.element("message", "success");
			result.element("result", 6);
			result.element("code", "200");
		} else {
			result.element("code", 400);
			result.element("message", "请求失败");

		}
		return result;
	}
}
