package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

@RestController
public class Addresslist {
	 Map<String, Object> address = new HashMap<String, Object>();
	 Map<String, Object> result = new HashMap<String, Object>();
	 JSONObject result1 = new JSONObject();
	 @RequestMapping(value="/address/list",method=RequestMethod.GET)//要求登录前提下
	 public Map<String,Object> addresslist(HttpServletRequest request) { 
		 Cookie [] cookies=request. getCookies() ;
		   if (Objects.isNull(cookies)) {
			   result.put("message","错误， 必须携带Cookie");
		         return result;
		   }
		   for (Cookie cookie:cookies) {
		      if (cookie.getName().equals ("login") &&
		            cookie.getValue().equals ("true")) {
		    	  if(address!=null) {
					   address.put("id","77479641");
					   address.put("searchParamList","[]");
					   address.put("sort","99");
					   address.put("province","浙江省");
					   address.put("city","杭州市");
					   address.put("receiverName","张三");
					   address.put("cellPhone","12345678901");
					   address.put("addressDetail","浙江大学");
					   address.put("fgUserId","74966314");
					   result1.put( "id","74966314");
					   result1.put( "searchParamList","[ ]");
					   result1.put( "phoneArea","86");
					   result1.put( "phoneNumber","20000000000");
					   result1.put( "createTime","1454057846653");
					   result1.put( "userAccount","86/20000000000");
					   result1.put( "userName","测试用户20");
					   result1.put( "platform","0");
					   result1.put( "next1","0");
					   result1.put( "next2","0");
					   result1.put( "createTimeStr","2016-01-29 16:57:26");
					   result1.put("platformDescribe","手机" );
					   String fguser=result1.toString();
					   address.put("fgUser",fguser);
					   String res= address.toString();
					   result.put("message","success");
					   result.put("result",res);
					   result.put("code","200");
				       return result;
				   }else {
					   result.put("message","收货地址为空");
					   result.put("code","201");
				       return result;
				   }
		           
		         }
		   }
		         result.put("message","错误， 必须携带Cookie");
		         return result;   
	   }
}


