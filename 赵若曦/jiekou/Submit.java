package com.example.demo;

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
public class Submit{
	@ResponseBody
	@RequestMapping(value = "/submit", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public JSONObject doPostSubmit(@RequestBody JSONObject json,HttpServletResponse response,HttpServletRequest request) {
		//打印json信息
		System.out.println(json.toString());
		String skuIds = json.getString("skuIds");
		String skuNumbers = json.getString("skuNumbers");
		String stockIds = json.getString("stockIds");
		String receiverName = json.getString("receiverName");
		String cellPhone = json.getString("cellPhone");
		String addressDetail = json.getString("addressDetail");
		String province = json.getString("province");
		String city = json.getString("city");
		String area = json.getString("area");
		JSONObject result = new JSONObject();
		Cookie [] cookies=request. getCookies() ;
			if (Objects.isNull(cookies)) {
			   result.put("message","错误， 必须携带Cookie");
		       return result;
		   }
		   for (Cookie cookie:cookies) {
		      if (cookie.getName().equals ("login") &&
		            cookie.getValue().equals ("true")) {
					if (skuIds.equals("2,3") && skuNumbers.equals("1,1") && stockIds.equals("74966312,74966313") && 
						receiverName.equals("zrx") && cellPhone.equals("15100044911") && addressDetail.equals("aaa") && 
						province.equals("河北省") && city.equals("石家庄市") && area.equals("长安区") ){
						result.element("message","success");
						result.element("code", 200);
		         }
		   }
	
		   }
		return result;
		   
	}

	
}
