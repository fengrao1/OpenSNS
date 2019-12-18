package com.example.demo.QGtest;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import net.sf.json.JSONObject;



/**
 * @author 刘美宁
 *         登录接口
 */

@RestController
//登录接口post
public class QGLogin_Test { 
	public static Cookie cookie;//定义cookie全局变量，供需要携带cookie的接口使用
   @ResponseBody
   @RequestMapping(value="/common/fgadmin/login",method=RequestMethod.POST,produces = "application/json")
   public JSONObject getByJSON(@RequestBody JSONObject jsonParam, HttpServletResponse response) {
		String phoneArea =jsonParam.getString("phoneArea");
		String phoneNumber =jsonParam.getString("phoneNumber");
		String password =jsonParam.getString("password");
		JSONObject result = new JSONObject();
		if(phoneArea.equals("86") && phoneNumber.equals("20000000000") && password.equals("netease123")){
			cookie=new Cookie("login", "true");
			cookie.setPath("/");
			response.addCookie(cookie);
			result.element("message", "success");
		}
		else {
			result.element("message", "fail");
		}
		return result;
	}
	    }

  

