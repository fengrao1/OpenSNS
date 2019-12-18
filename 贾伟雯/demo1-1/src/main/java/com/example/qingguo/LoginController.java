package com.example.qingguo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

@RestController
public class LoginController {
	@RequestMapping("/helloworld")
	public String show() {
		return "Hello world";
	}
	
	/**
	 * @author 贾伟雯
	 * 登录接口
	 */

	//登录接口
	@ResponseBody
	@RequestMapping(value="/common/fgadmin/login",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	//required=true
//	public JSONObject getByJSON( @RequestParam(value = "phoneArea",required = false) String phoneArea,
//			@RequestParam(value = "phoneNumber",required = false) String phoneNumber,
//			@RequestParam(value = "password",required = false) String password,HttpServletResponse response) {
	public JSONObject getByJSON( @RequestBody JSONObject jsonparam,HttpServletResponse response) {
		String phoneArea=jsonparam.getString("phoneArea");
		String phoneNumber=jsonparam.getString("phoneNumber");
		String password=jsonparam.getString("password");
		
		JSONObject result=new JSONObject();
		
		if(phoneArea.equals("86")&&phoneNumber.equals("20000000000")&&password.equals("netease123")) {
			Cookie cookie = new Cookie("login","true");
			cookie.setPath("/");
			response.addCookie(cookie);
			result.element("message","success");
			result.element("code","200");
		}
		else {
			result.element("message","fail");
			result.element("code","400");
		}
		return result;
	}
	
	/**
	 * @author 贾伟雯
	 * 获取所有商品的 sku 信息或指定商品的 sku 信息。
	 */
	//获取所有商品的 sku 信息或指定商品的 sku 信息。
	//common/skuList?goodsId=1
	//goodsId=1 的响应示例
	@RequestMapping(value="/common/skuList", method = RequestMethod.GET)
	    public Map<String, String> getList(@RequestParam Integer goodsId){
			Map<String, String> result=new HashMap<>();
			if(goodsId==1) {
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
				Map<String, String> result2=new HashMap<>();
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
			}else {
				result.put("code","400");
				result.put("message","Failed to convert property value of type 'java.lang.String' to required type" + 
						"'java.lang.Long' for property" + 
						"'goodsId'; nested exception is" + 
						"java.lang.NumberFormatException: For" + 
						"input string: \"aaa\"");
			}
			return result;
        }
	
	/**
	 * @author 贾伟雯
	 * 
	 */
	//获取所有商品的 sku 信息或指定商品的 sku 信息。
	//common/skuList
	//不带goodsId
	@RequestMapping(value="/common/skuList1", method = RequestMethod.GET)
	public Map<String, String> getList0(HttpServletRequest request){
		Map<String, String> result=new HashMap<>(); //模拟商品
		Map<String, String> result1=new HashMap<>();
		Map<String, String> good=new HashMap<>(); 
		good.put("id","2");
		good.put("searchParamList","[]");
		good.put("goodsName","青果");
		good.put("sellChannel","2");
		Map<String, String> good1=new HashMap<>(); 
		good1.put("id","1");
		good1.put("searchParamList","[]");
		good1.put("goodsName","青果");
		good1.put("sellChannel","1");
		String goods=good.toString();
		String goods1=good1.toString();
		result1.put("id","5");
		result1.put("searchParamList","[]");
		result1.put("totalNumber","200000");
		result1.put("colour","1");
		result1.put("skuName","夜空黑");
		result1.put("goods",goods);
		result1.put("goodsId","2");
		result1.put("price","199");
		result1.put("picUrl","https://nos.163.com/yixinpublic5");
		Map<String, String> result2=new HashMap<>();
		result2.put("id","4");
		result2.put("searchParamList","[]");
		result2.put("totalNumber","200000");
		result2.put("colour","0");
		result2.put("skuName","青果绿");
		result2.put("goods",goods);
		result2.put("goodsId","2");
		result2.put("price","199");
		result2.put("picUrl","https://nos.163.com/yixinpublic");
		Map<String, String> result3=new HashMap<>();
		result3.put("id","3");
		result3.put("searchParamList","[]");
		result3.put("stockId","74966313");
		result3.put("totalNumber","200000");
		result3.put("colour","0");
		result3.put("skuName","青果绿");
		result3.put("goods",goods1);
		result3.put("goodsId","1");
		result3.put("price","199");
		result3.put("picUrl","https://nos.163.com/yixinpublic");
		Map<String, String> result4=new HashMap<>();
		result4.put("id","2");
		result4.put("searchParamList","[]");
		result4.put("stockId","74966312");
		result4.put("totalNumber","200000");
		result4.put("colour","0");
		result4.put("skuName","青果绿");
		result4.put("goods",goods1);
		result4.put("goodsId","1");
		result4.put("price","199");
		result4.put("picUrl","https://nos.163.com/yixinpublic");
		String res=result1.toString()+result2.toString()+result3.toString()+result4.toString();
		result.put("message","success");
		result.put("result",res);
		result.put("code","200");
		return result; //判断返回的数组cookies是不是为空
	}
	
	/**
	 * @author 贾伟雯
	 * 查询用户收货地址
	 */
	//查询用户收货地址。
	@RequestMapping(value="/fgadmin/address/list", method = RequestMethod.GET)
    public Map<String, Object> getAddress(){
		Map<String, Object> result=new HashMap<>(); //模拟商品
		Map<String, Object> list=new HashMap<>();
		Map<String, Object> fgUser=new HashMap<>(); 
		fgUser.put("id","74966314");
		fgUser.put("searchParamList","[]");
		fgUser.put("phoneArea","86");
		fgUser.put("phoneNumber","20000000000");
		fgUser.put("createTime","1454057846653");
		fgUser.put("userAccount","86/20000000000");
		fgUser.put("userName","测试用户20");
		fgUser.put("platform","0");
		fgUser.put("next1","0");
		fgUser.put("next2","0");
		fgUser.put("createTimeStr","2016-01-29 16:57:26");
		fgUser.put("platformDescribe","手机");
		list.put("id","77479641");
		list.put("searchParamList","[]");
		list.put("sort","99");
		list.put("province","浙江省");
		list.put("city","杭州市");
		list.put("area","滨江区");
		list.put("receiverName","张三");
		list.put("cellPhone","12345678901");
		list.put("addressDetail","浙江大学");
		list.put("fgUserId","74966314");
		list.put("fgUser",fgUser);
		Map<String, Object> list1=new HashMap<>();
		list1.put("id","77479640");
		list1.put("searchParamList","[]");
		list1.put("sort","99");
		list1.put("province","123");
		list1.put("city","杭州市");
		list1.put("area","滨江区");
		list1.put("receiverName","张三");
		list1.put("cellPhone","12345678901");
		list1.put("addressDetail","浙江大学");
		list1.put("fgUserId","74966314");
		list1.put("fgUser",fgUser);
		Map<String, Object> result1=new HashMap<>();
		result1.put("searchParamList","[\r\n" + 
				"74966314,\r\n" + 
				"50, 0\r\n" + 
				"]");
		result1.put("limit","50");
		result1.put("offset","0");
		result1.put("total","2");
		result1.put("list",list);
		result1.put("list",list1);
		result1.put("prefix","A.");
		result1.put("fgUserId","74966314");
		result.put("message","success");
		result.put("result",result1);
		result.put("code","200");
		return result; //判断返回的数组cookies是不是为空
    }
	
	/**
	 * @author 贾伟雯
	 * 计算运费。
	 */
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
	
	/**
	 * @author 贾伟雯
	 * 提交订单。
	 */
	// 提交订单
	@RequestMapping(value = "/fgadmin/orders/submit", method = RequestMethod.POST)
//	public JSONObject submit( @RequestParam(value = "skuIds",required = true) String skuIds,
//			@RequestParam(value = "skuNumbers",required = true) String skuNumbers,
//			@RequestParam(value = "stockIds",required = true) String stockIds,
//			@RequestParam(value = "receiverName",required = true) String receiverName,
//			@RequestParam(value = "cellPhone",required = true) String cellPhone,
//			@RequestParam(value = "addressDetail",required = true) String addressDetail,
//			@RequestParam(value = "province",required = true) String province,
//			@RequestParam(value = "city",required = true) String city,
//			@RequestParam(value = "area",required = true) String area,
//			@RequestParam(value = "voiceStatus",required = true) String voiceStatus,
//			@RequestParam(value = "needInvoice",required = true) int needInvoice,
//			@RequestParam(value = "invoiceHead",required = true) String invoiceHead,
//			@RequestParam(value = "transportFee",required = true) int transportFee,
//			@RequestParam(value = "logisticsCompanyId",required = true) int logisticsCompanyId,
//			@RequestParam(value = "accessSource",required = true) String accessSource,
//			@RequestParam(value = "accessDevice",required = true) int accessDevice,HttpServletResponse response) {
	public JSONObject submit( @RequestBody JSONObject jsonparam,HttpServletResponse response) {
		String skuIds=jsonparam.getString("skuIds");
		String skuNumbers=jsonparam.getString("skuNumbers");
		String stockIds=jsonparam.getString("stockIds");
		String receiverName=jsonparam.getString("receiverName");
		String cellPhone=jsonparam.getString("cellPhone");
		String addressDetail=jsonparam.getString("addressDetail");
		String province=jsonparam.getString("province");
		String city=jsonparam.getString("city");
		String area=jsonparam.getString("area");
		String voiceStatus=jsonparam.getString("voiceStatus");
		String needInvoice=jsonparam.getString("needInvoice");
		String invoiceHead=jsonparam.getString("invoiceHead");
		String transportFee=jsonparam.getString("transportFee");
		String logisticsCompanyId=jsonparam.getString("logisticsCompanyId");
		String accessSource=jsonparam.getString("accessSource");
		String accessDevice=jsonparam.getString("accessDevice");
		Map<String,Object> res=new HashMap<>();
		res.put("skuIds", skuIds);
		res.put("skuNumbers", skuNumbers);
		res.put("stockIds", stockIds);
		res.put("receiverName", receiverName);
		res.put("cellPhone", cellPhone);
		res.put("addressDetail", addressDetail);
		res.put("province", province);
		res.put("city", city);
		res.put("area", area);
		res.put("voiceStatus", voiceStatus);
		res.put("needInvoice", needInvoice);
		res.put("invoiceHead", invoiceHead);
		res.put("transportFee", transportFee);
		res.put("logisticsCompanyId", logisticsCompanyId);
		res.put("accessSource", accessSource);
		res.put("accessDevice", accessDevice);
		JSONObject result=new JSONObject();
		if(receiverName.equals("张三")) {
			Cookie cookie = new Cookie("login","true");
			response.addCookie(cookie);
			result.element("message","success");
			result.element("result", res);
			result.element("code","200");
		}
		else {
			result.element("message","fail");
			result.element("code","400");
		}
		return result;
	}
	
	/**
	 * @author 贾伟雯
	 * 添加收货地址。
	 */
	//添加收货地址
	@ResponseBody
	@RequestMapping(value="/fgadmin/address/new",method=RequestMethod.POST,produces = "application/json;charset=UTF-8")
//	public JSONObject newaddress( @RequestParam(value = "id",required = true) String id,
//			@RequestParam(value = "receiverName",required = true) String receiverName,
//			@RequestParam(value = "cellPhone",required = true) String cellPhone,
//			@RequestParam(value = "addressDetail",required = true) String addressDetail,
//			@RequestParam(value = "province",required = true) String province,
//			@RequestParam(value = "city",required = true) String city,
//			@RequestParam(value = "area",required = true) String area,HttpServletResponse response) {
	public JSONObject newaddress( @RequestBody JSONObject jsonparam,HttpServletResponse response) {
		String id=jsonparam.getString("id");
		String receiverName=jsonparam.getString("receiverName");
		String cellPhone=jsonparam.getString("cellPhone");
		String addressDetail=jsonparam.getString("addressDetail");
		String province=jsonparam.getString("province");
		String city=jsonparam.getString("city");
		String area=jsonparam.getString("area");
		Map<String,Object> res=new HashMap<>();
		res.put("id", id);
		res.put("receiverName", receiverName);
		res.put("cellPhone", cellPhone);
		res.put("addressDetail", addressDetail);
		res.put("province", province);
		res.put("city", city);
		res.put("area", area);
		JSONObject result=new JSONObject();
		if(id.equals("") && receiverName.equals("")) {
			result.put("message","收货人姓名不能为null");
			result.put("code","400");
		}else if(id.equals("1")|id.equals("2")|id.equals("3")|id.equals("4")|id.equals("5")|id.equals("6")|id.equals("7")|id.equals("8")|id.equals("9")|id.equals("0")) {
			result.put("message","id必须为null");
			result.put("code","400");
		}
		 else if(id.equals("") && cellPhone.equals("")) {
			result.put("message","cellPhone不能为null");
			result.put("code","400");
		 }
		 else if(id.equals("") && addressDetail.equals("")) {
			result.put("message","addressDetail不能为null");
			result.put("code","400");
		 }
		 else if(id.equals("") && province.equals("")) {
			result.put("message","province不能为null");
			result.put("code","400");
		 }
		 else if(id.equals("") && city.equals("")) {
			result.put("message","city不能为null");
			result.put("code","400");
		 }
		 else if(id.equals("") && area.equals("")) {
			result.put("message","area不能为null");
			result.put("code","400");
		 }else if(id.equals("") && receiverName!=null && cellPhone!=null && addressDetail!=null && province!=null && city!=null && area!=null) {
			result.put("message","success");
			result.put("result",res);
			result.put("code","200");
		 }
		  
		return result;
	  }

	/**
	 * @author 贾伟雯
	 * 删除收货地址。
	 */
	//删除收货地址
	@ResponseBody
	@RequestMapping(value="/fgadmin/address/delete",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public JSONObject getByJSON( @RequestParam(value = "id",required = true) String id,HttpServletResponse response) {
		JSONObject result=new JSONObject();
		
		if(id.equals("77243286")) {
			Cookie cookie = new Cookie("delete","true");
			response.addCookie(cookie);
			result.element("message","success");
			result.element("code","200");
		}
		else {
			result.element("message","fail");
			result.element("code","400");
		}
		return result;
	}
}
