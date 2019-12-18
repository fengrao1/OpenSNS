package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;



@RestController
//@RequestMapping("post") //在地址前面要加上post  http://localhost:9999/post/fgadmin/address/new
public class NewAddress {
 	  @ResponseBody
	  @RequestMapping(value="/new",method=RequestMethod.POST,produces = "application/json;charset=UTF-8")
	  public JSONObject NewAddress(@RequestBody JSONObject jsonparam,HttpServletRequest request) {  
		  String id = jsonparam.getString("id");
		  String receiverName = jsonparam.getString("receiverName");
		  String cellPhone = jsonparam.getString("cellPhone");
		  String addressDetail = jsonparam.getString("addressDetail");
		  String province = jsonparam.getString("province");
		  String city = jsonparam.getString("city");
		  String area = jsonparam.getString("area");
		  Map<String,Object> newaddress = new HashMap<String, Object>();
		  JSONObject result = new JSONObject();
		  //判断是否携带cookie
		  Cookie [] cookies=request. getCookies() ;
		   if (Objects.isNull(cookies)) {
			   result.put("message","错误， 必须携带Cookie");
		       return result;
		   }
		   for (Cookie cookie:cookies) {
		      if (cookie.getName().equals ("login") &&
		            cookie.getValue().equals ("true")) {
		    	  if(id.equals("") && receiverName.equals("")) {
				         result.put("message","收货人姓名不能为null");
				         result.put("code","400");
					     return result;
				     }else if(id.equals("1")|id.equals("2")|id.equals("3")|id.equals("4")|id.equals("5")|id.equals("6")|id.equals("7")|id.equals("8")|id.equals("9")|id.equals("0")) {
					    result.put("message","id必须为null");
				        result.put("code","400");
					    return result;
				     }else if(newaddress.size()>6){
					     result.put("message","最多只能添加 6 个地址");
				         result.put("code","400");
					     return result;
				     }
				     else if(id.equals("") && cellPhone.equals("")) {
					     result.put("message","cellPhone不能为null");
					     result.put("code","400");
				         return result;
				      }
				      else if(id.equals("") && addressDetail.equals("")) {
					     result.put("message","addressDetail不能为null");
					     result.put("code","400");
				         return result;
				      }
				     else if(id.equals("") && province.equals("")) {
					     result.put("message","province不能为null");
					     result.put("code","400");
				         return result;
				     }
				     else if(id.equals("") && city.equals("")) {
					     result.put("message","city不能为null");
					     result.put("code","400");
				         return result;
				     }
				     else if(id.equals("") && area.equals("")) {
					      result.put("message","area不能为null");
					      result.put("code","400");
				          return result;
				    }else if(id.equals("") && receiverName!=null && cellPhone!=null && addressDetail!=null && province!=null && city!=null && area!=null) {
				          result.put("message","success");
				          result.put("code","200");
				         return result;
				    }
				  
				  return result;
			    }
		      }
		   result.put("message","错误， 必须携带Cookie");
	       return result;
	  }
}

