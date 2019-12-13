package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.netty.handler.codec.http.HttpResponse;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;


@RestController
@RequestMapping("post")
//登录接口post
public class QGLogin_Test { 
	public static Cookie cookie;//定义cookie全局变量，供需要携带cookie的接口使用
   @ResponseBody
   @RequestMapping(value="/common/fgadmin/login",method=RequestMethod.POST,produces = "application/json")
   public String loginTest(HttpServletResponse response,
	                        @RequestParam(value="number",required=true) String number,
	                        @RequestParam(value="password",required=true) String password, @RequestParam(value="area",required=true) String phoneArea){
	        
	        //如果用户名和密码成功，就添加cookie信息，然后添加到response中，然后成功信息
	        if(phoneArea.equals("86") && number.equals("20000000000") && password.equals("netease123")){
	            cookie=new Cookie("login","true");
	            response.addCookie(cookie);
	            System.out.println("{\"phoneArea\":\"86\",\"phoneNumber\":\"20000000000 \",\"password\":\"netease123\"}");
	            //return "返回cookie，登录成功";
	            return  "{'message':'success','code':200 }";
	        }
	        return "登录失败";
	    }

  @RequestMapping (value="/getwithCookie" , method=RequestMethod.GET)
  public String getWithCookies (HttpServletRequest request) {
	   Cookie [] cookies=request. getCookies() ;
	   if (Objects.isNull(cookies)) {
	       return "错误， 必须携带Cookie" ;
	   }
	   for (Cookie cookie:cookies) {
	      if (cookie.getName().equals ("login") &&
	            cookie.getValue().equals ("true")) {
	            return "访问成功" ;
	         }
	   }
	         return "错误， 必须携带Cookie";

	   
   }
  
  

	
   }

