package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

/**
 * @author 杨柳
 * 
 */


@RestController
public class Project {
	
	//登录
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
				result.element("code","200");
			}
			else {
				result.element("message", "fail");
			}
			return result;
		}
	
	
	
	//获取所有商品的 sku 信息或指定商品的 sku 信息
	@RequestMapping(value="/common/skuList", method = RequestMethod.GET)
	    public Map<String, String> getList(@RequestParam Integer goodsId){
			Map<String, String> result=new HashMap<>(); 
			Map<String, String> result1=new HashMap<>(); 
			Map<String, String> good=new HashMap<>(); 
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
			return result; 
        }
	
	
	//计算运费
	@RequestMapping(value = "/common/getTransportFee",method = RequestMethod.GET)
    public Map<String,String> getwithParam(@RequestParam("id") String id,
                                           @RequestParam("addressDetail") String addressDetail){
        if(id.equals("1")&&addressDetail.equals("浙江省_杭州市_滨江区")) {
            Map<String,String> result=new HashMap<>();
            result.put("message","success");
            result.put("result","6");
            result.put("code","200");
            return result;
		}
        
        Map<String,String> resultfail=new HashMap<>();
        resultfail.put("message","请求失败");
        resultfail.put("code","400");
        return resultfail;

    }
	
	//查询用户收货地址
	@RestController
	public class Addresslist_Test {
		 Map<String, Object> address = new HashMap<String, Object>();
		 Map<String, Object> result = new HashMap<String, Object>();
		 JSONObject result1 = new JSONObject();
		 @RequestMapping(value="/fgadmin/address/list",method=RequestMethod.GET)//要求登录前提下
		   public Map<String,Object> addresslist() {
			   Cookie cookie= new Cookie("login","true");
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
	
	// 提交订单
	@RequestMapping(value = "/fgadmin/orders/submit", method = RequestMethod.POST)
	public Return submit(@RequestBody Map address) {
		Map<String, Object> ad = Address.getAdd("2,3", "1,1", "74966312,74966313", "张三", "1栋3单元", "浙江省", "杭州市", "滨江区",0);
		Return result = new Return();
		int num = 0;
		for (int i = 0; i < ad.size(); i++) {
			if (ad.get(i) == address.get(i)) {
				num++;
			} else {
				result.setCode(400);
				result.setMessage("请求失败");
				return result;
			}
		}
		if (num == ad.size()) {
			result.setCode(200);
			result.setMessage("success");
			ArrayList<Map<String, Object>> addre = new ArrayList<Map<String, Object>>();
			addre.add(ad);
			result.setResult(addre);
			return result;
		}else {
			result.setCode(400);
			result.setMessage("请求失败");
			return result;
		}
	}
	
	//添加
	@RestController
	public class newAddress_Test {
		  @RequestMapping(value="/fgadmin/address/new",method=RequestMethod.POST,produces = "application/json;charset=UTF-8")
		  public JSONObject NewAddress(@RequestBody JSONObject jsonparam) {   
			  Cookie cookie= new Cookie("login","true");
			  String id = jsonparam.getString("goodsId");
			  String receiverName = jsonparam.getString("receiverName");
			  String cellPhone = jsonparam.getString("cellPhone");
			  String addressDetail = jsonparam.getString("addressDetail");
			  String province = jsonparam.getString("province");
			  String city = jsonparam.getString("city");
			  String area = jsonparam.getString("area");
			  Map<String,Object> newaddress = new HashMap<String, Object>();
			  JSONObject result = new JSONObject();
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
	
	//删除
	@RequestMapping(value="/fgadmin/address/delete",method=RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public Map<String,String> delete(@RequestParam(name = "id",required =true) String id){
		if(id.equals("77243286")) {
			Map<String,String> result=new HashMap<>();
			result.put("message","success");
			result.put("code","200");
			return result;
		}

		Map<String,String> resultfail=new HashMap<>();
		resultfail.put("message","请求失败");
		resultfail.put("code","400");
		return resultfail;

	}
	
	
	
	
	
	

}

	
	
	
	

