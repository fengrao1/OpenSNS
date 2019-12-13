package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransFee_Test {
	Map<String,Object> goodfee = new HashMap<String,Object>();
	Map<String,Object> error = new HashMap<String,Object>();
	 @ResponseBody
     @RequestMapping(value="/common/getTransportFee",method=RequestMethod.GET)
     public Map<String,Object> FeeTest(@RequestParam("goodsId") String id,@RequestParam("addressDetail") String address) {
		 if(id.equals("1") && address.equals("浙江省_杭州市_滨江区")) {
    	 goodfee.put("goodId","1");
    	 goodfee.put("addressDetail","浙江省_杭州市_滨江区");
    	 goodfee.put("message","success");
    	 goodfee.put("code","200");
    	 goodfee.put("result","6.0");
		 return goodfee;
		 }else {
			 error.put("code","400");  
			 error.put("message","请求失败");  
			 return error;
		 }
		 
     }
	 
}
