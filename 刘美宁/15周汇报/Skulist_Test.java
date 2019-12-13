package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Skulist_Test {
	//商品信息  无参数
	   @RequestMapping(value="/common/skuList",method=RequestMethod.GET)
	   public Map<String, Object> skulist() {
		   Map<String, Object> goods = new HashMap<String, Object>();//注意只能输出一个，有问题
		   goods.put("goodsId","1");
		   goods.put("skuName","夜空黑");
		   goods.put("goodsName","青果");
		   goods.put("price","100");
		   goods.put("totalNumber","2000");
		   goods.put("stockId","74966313");
		   goods.put("sellChannel","1");
		   goods.put("message","success");
		   goods.put("code","200");
		   goods.put("goodsId","2");
		   goods.put("skuName","青果绿");
		   goods.put("goodsName","青果");
		   goods.put("price","199");
		   goods.put("totalNumber","20000");
		   goods.put("stockId","74966314");
		   goods.put("sellChannel","2");
		   goods.put("message","success");
		   goods.put("code","200");
		   return goods;
		   
	   }
	   //有参数
	   @RequestMapping(value="/common/skulistbypara",method=RequestMethod.GET)
	   public Map<String, Object>  skulistBypara(
	           @RequestParam("goodsId") String id) {
		   Map<String, Object> goods = new HashMap<String, Object>();
		   if(id.equals("1")) {
			   goods.put("goodsId","1");
			   goods.put("skuName","夜空黑");
			   goods.put("goodsName","青果");
			   goods.put("price","299");
			   goods.put("totalNumber","2000");
			   goods.put("stockId","74966313");
			   goods.put("sellChannel","1");
			   goods.put("message","success");
			   goods.put("code","200");
			   return goods;
		   }else {
			   goods.put("goodsId","2");
			   goods.put("skuName","青果绿");
			   goods.put("goodsName","青果");
			   goods.put("price","199");
			   goods.put("totalNumber","20000");
			   goods.put("stockId","74966314");
			   goods.put("sellChannel","2");
			   goods.put("message","success");
			   goods.put("code","200");
			   return goods;
		   }   
	   }
}
