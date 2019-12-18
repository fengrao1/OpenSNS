package com.example.demo.QGtest;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import net.minidev.json.JSONObject;


/**
 * @author 刘美宁
 *     删除收货地址
 */
@RestController
public class Delete_Test {
	Map<String, Object> result = new HashMap<String, Object>();
	@RequestMapping(value="/fgadmin/address/delete",method=RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public Map<String,Object> delete(@RequestBody JSONObject jsonparam,HttpServletRequest request){
		String goodsId= jsonparam.getAsString("goodsId");
		 Cookie [] cookies=request. getCookies() ;
		   if (Objects.isNull(cookies)) {
			     result.put("message","错误， 必须携带Cookie");
		         return result;
		   }
		   for (Cookie cookie:cookies) {
		      if (cookie.getName().equals ("login") &&
		            cookie.getValue().equals ("true")) {
		             if(goodsId.equals("12345679")) {
			         result.put("message","success");
			         result.put("code","200");
			         return result;
		      }else {
		    	  Map<String,Object> resultfail=new HashMap<>();
		  		  resultfail.put("message","请求失败");
		  		  resultfail.put("code","400");
		  		  return resultfail;
		    	  }
		      }

	}
		return result;
}
	}
