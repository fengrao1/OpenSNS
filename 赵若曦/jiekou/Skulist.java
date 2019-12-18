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
public class Skulist {
	//goodsId=1 的响应示例
	@RequestMapping(value="/skulist", method = RequestMethod.GET)
	    public Map<String, String> getList(@RequestParam Integer goodsId){
			Map<String, String> result=new HashMap<>(); //模拟商品
			Map<String, String> result1=new HashMap<>(); //模拟商品
			Map<String, String> good=new HashMap<>(); //模拟商品
			good.put("id","1");
			good.put("searchParamList","[]");
			good.put("goodsName","青果");
			good.put("sellChannel","1");
			String goods=good.toString();
			result1.put("id","3");
			result1.put("searchParamList","[]");
			result1.put("stockId","74966312");
			result1.put("totalNumber","200000");
			result1.put("colour","2");
			result1.put("skuName","夜空黑");
			result1.put("goods",goods);
			result1.put("goodsId","1");
			result1.put("price","199");
			result1.put("picUrl","https://nos.163.com/yixinpublic");
			Map<String, String> result2=new HashMap<>(); //模拟商品
			result2.put("id","2");
			result2.put("searchParamList","[]");
			result2.put("stockId","74966312");
			result2.put("totalNumber","200000");
			result2.put("colour","0");
			result2.put("skuName","青果绿");
			result2.put("goods",goods);
			result2.put("goodsId","1");
			result2.put("price","199");
			result2.put("picUrl","https://nos.163.com/yixinpublic");
			String res=result1.toString()+result2.toString();
			result.put("message","success");
			result.put("result",res);
			result.put("code","200");
			return result; //判断返回的数组cookies是不是为空
        }

	
}
