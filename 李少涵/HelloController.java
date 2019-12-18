package com.example.demo;

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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 李少涵
 * 
 */
@RestController
public class HelloController {

	/**
	 * @author 李少涵 登录接口
	 */
	public Cookie cookie1;

	@RequestMapping(value = "/common/fgadmin/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public Return test1(@RequestBody Map params, HttpServletResponse response) {
		Return result = new Return();
		String phoneNumber = params.get("phoneNumber").toString();
		String password = params.get("password").toString();
		String phoneArea = params.get("phoneArea").toString();
		if (phoneArea.equals("86") && phoneNumber.equals("20000000003") && password.equals("netease123")) {
			cookie1 = new Cookie("login", "true");
			cookie1.setPath("/");
			response.addCookie(cookie1);
			result.setMessage("success");
			result.setCode(200);
		}

		else {
			if (phoneNumber.equals("")) {
				result.setMessage("用户名为空");
				result.setCode(401);
			} else {
				result.setMessage("用户名或者密码错误");
				result.setCode(400);
			}

		}
		return result;

	}

	/**
	 * @author 李少涵 获取商品信息---获取指定商品-
	 */
	@RequestMapping(value = "/common/skuList2", method = RequestMethod.GET)
	public Return2 getGood1(@RequestParam int goodsId) {
		Return2 result = new Return2();
		Goods goods = new Goods();
		if (goodsId == 1) {
			result.setCode(200);
			result.setMessage("success");
			ArrayList<Map<String, Object>> good1 = goods.getGoods1();
			result.setResult(good1);
		} else if (goodsId == 2) {
			result.setCode(200);
			result.setMessage("success");
			ArrayList<Map<String, Object>> good2 = goods.getGoods2();
			result.setResult(good2);
		} else {
			result.setCode(201);
			result.setMessage("该商品ID不存在");
		}

		return result;
	}

	/**
	 * @author 李少涵 获取商品信息---获取所有商品
	 */
	@RequestMapping(value = "/common/skuList1", method = RequestMethod.GET)
	public Return2 getGood2() {// ---------------------------------如何判断没有goodsID
		Return2 result = new Return2();
		Goods goods = new Goods();
		result.setCode(200);
		result.setMessage("success");
		ArrayList<Map<String, Object>> good = goods.getGoods();
		result.setResult(good);
		return result;
	}

	/**
	 * @author 李少涵 获取商品信息---错误参数
	 */
	@RequestMapping(value = "/common/skuList3", method = RequestMethod.GET)
	public Return2 getGood3(@RequestParam String goodsId) {
		Return2 result = new Return2();
		Goods goods = new Goods();
		result.setCode(400);
		result.setMessage("Failed to convert property value of type 'java.lang.String' to required type"
				+ "'java.lang.Long' for property" + "'goodsId'; nested exception is"
				+ "java.lang.NumberFormatException: For" + "input string: \"aaa\"");
		return result;
	}

	/**
	 * @author 李少涵 获取收货地址
	 */
	@RequestMapping(value = "/fgadmin/address/list", method = RequestMethod.GET)
	public Return4 getList(HttpServletRequest request) {
		Return4 result = new Return4();
		List list = new List();
		Cookie[] cookies = request.getCookies();
		if (Objects.isNull(cookies)) {
			result.setCode(400);
			result.setMessage("错误，必须携带Cookie");
			return result;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
				result.setCode(200);
				result.setMessage("success");
				Map<String, Object> getList = list.getList();
				result.setResult(getList);
				return result;

			}

		}
		return result;
	}

	/**
	 * @author 李少涵 获取运费
	 */
	@RequestMapping(value = "/common/getTransportFee", method = RequestMethod.GET)
	public Return3 getFee(@RequestParam int id, @RequestParam String addressDetail, HttpServletRequest request) {
		Return3 result = new Return3();
		Cookie[] cookies = request.getCookies();
		if (Objects.isNull(cookies)) {
			result.setCode(400);
			result.setMessage("错误，必须携带Cookie");
			return result;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
				if (id == 1 && addressDetail.equals("浙江省_杭州市_滨江区")) {
					result.setCode(200);
					result.setMessage("success");
					result.setResult(6);
					return result;
				}

			}
		}
		result.setCode(400);
		result.setMessage("请求失败");
		return result;
	}

	/**
	 * @author 李少涵 提交订单
	 */
	@RequestMapping(value = "/fgadmin/orders/submit", method = RequestMethod.POST)
	public Return2 submit(@RequestBody Map address, HttpServletRequest request) {
		Map<String, Object> ad = Address.getAdd("2,3", "1,1", "74966312,74966313", "张三", "1栋3单元", "浙江省", "杭州市", "滨江区",
				0);
		Return2 result = new Return2();
		int num = 0;
		Cookie[] cookies = request.getCookies();
		if (Objects.isNull(cookies)) {
			result.setCode(400);
			result.setMessage("错误，必须携带Cookie");
			return result;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
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
				}
			}
		}
		result.setCode(400);
		result.setMessage("请求失败");
		return result;
	}

	/**
	 * @author 李少涵 删除地址
	 */
	@RequestMapping(value = "/fgadmin/address/delete", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public Return delete(@RequestBody Map para, HttpServletRequest request) {
		Return result = new Return();
		Map<String, Object> id = new HashMap<String, Object>();
		id.put("id", "77243286");
		Cookie[] cookies = request.getCookies();
		if (Objects.isNull(cookies)) {
			result.setCode(400);
			result.setMessage("错误，必须携带Cookie");
			return result;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
				for (int i = 0; i < id.size(); i++) {
					if (id.get(i) == para.get(i)) {
						result.setMessage("success");
						result.setCode(200);
						return result;
					}
				}
			}
			result.setMessage("请求失败");
			result.setCode(400);
		}
		return result;
	}

	/**
	 * @author 李少涵 添加收货地址
	 */
	@RequestMapping(value = "/fgadmin/address/new", method = RequestMethod.POST)
	public Return addNew(@RequestBody Map addnew, HttpServletRequest request) {
		Map<String, Object> ad = Address.add("张三", "1栋3单元", "浙江省", "杭州市", "滨江区");
		Return result = new Return();
		String id = "";
		Cookie[] cookies = request.getCookies();
		if (Objects.isNull(cookies)) {
			result.setCode(400);
			result.setMessage("错误，必须携带Cookie");
			return result;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
				if (id.equals("")) {
					result.setCode(200);
					result.setMessage("success");
					return result;
				} else {
					result.setCode(400);
					result.setMessage("必须为 null");
					return result;
				}

			}

		}
		return result;
	}
}