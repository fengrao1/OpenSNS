package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Addresslist_Test {
	 Map<String, Object> address = new HashMap<String, Object>();
	 Map<String, Object> error = new HashMap<String, Object>();
	@RequestMapping(value="/fgadmin/address/list",method=RequestMethod.GET)//要求登录前提下
	   public Map<String, Object> addresslist(HttpServletResponse response, @RequestParam("goodsId") String id) {
		   Cookie cookie= new Cookie("login","true");
		   response.addCookie(cookie);
		   if(id.equals("1")) {
		   address.put("id", "77479641");
		   address.put("sort", "99");
		   address.put("province", "浙江省");
		   address.put("city", "杭州市");
		   address.put("area", "滨江区");
		   address.put("receiverName", "张三");
		   address.put("cellPhone", "12345678900");
		   address.put("addressDetail", "浙江大学");
		   address.put("fgUserId", "74966314");
		   return address;
		   }else {
			   error.put("message","收货地址为空");
			   error.put("code","201");
			   return error;
		   }
		   
	   }
}
