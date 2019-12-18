package com.example.demo.QGtest;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author 刘美宁
  *       获取商品的sku信息  带参数 &不带参数
 */
@RestController
public class Skulist_Test {//不需要登录状态
	//商品信息  无参数
	    Map<String, Object> result=new HashMap<>(); //模拟商品
		Map<String, Object> result1=new HashMap<>(); //模拟商品
		Map<String, Object> good=new HashMap<>(); //模拟商品
	   @RequestMapping(value="/common/skuList",method=RequestMethod.GET)
	   public Map<String, Object> skulist() {
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
			Map<String, Object> result2=new HashMap<>(); //模拟商品
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
	   //有参数
	   @RequestMapping(value="/common/skulistbypara",method=RequestMethod.GET)
	   public Map<String,Object> skulistBypara(
	           @RequestParam("goodsId") String id) {
		   if(id.equals("1")|id.equals("2")|id.equals("3")) {
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
				Map<String, Object> result2=new HashMap<>(); //模拟商品
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
		   }else {
			   Map<String,Object> result = new HashMap<String,Object>();
			   result.put("message","Failed to convert property value of type 'java.lang.String' to required type 'java.lang.Long' for property 'goodsId'; nested exception is java.lang.NumberFormatException: For input string: \"aaa\"\" ");
		       result.put("code","400");
		       return result;
		   }
		   
		  
		   
	   }
}
