package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

@RestController
public class SkuList {
	// 获取商品信息---获取指定商品-
	@RequestMapping(value = "/common/skuList", method = RequestMethod.GET)
	public JSONObject getGood1(@RequestParam int goodsId) {
		JSONObject result = new JSONObject();
		Map<String, Object> goods1 = new HashMap<>();
		Map<String, Object> goods2 = new HashMap<>();
		if (goodsId == 1) {
			goods1.put("id", "3");
			goods1.put("searchParamList", "[]");
			goods1.put("stockId", "74966313");
			goods1.put("totalNumber", "200000");
			goods1.put("colour", "1");
			goods1.put("skuName", "夜空黑");
			goods1.put("goodsId", goodsId);
			goods1.put("price", "199");
			goods1.put("picUrl", "https://nos.163.com/yixinpublic");
			ArrayList<Map<String, Object>> all = new ArrayList<Map<String, Object>>();
			all.add(goods1);
			result.element("message", "success");
			result.element("code", 200);
			result.element("result", all);
		} else if (goodsId == 2) {
			goods2.put("id", "5");
			goods2.put("searchParamList", "[]");
			goods2.put("stockId", "74966313");
			goods2.put("totalNumber", "200000");
			goods2.put("colour", "1");
			goods2.put("skuName", "夜空黑");
			goods2.put("goodsId", goodsId);
			goods2.put("price", "199");
			goods2.put("picUrl", "https://nos.163.com/yixinpublic");
			ArrayList<Map<String, Object>> all = new ArrayList<Map<String, Object>>();
			all.add(goods2);
			result.element("message", "success");
			result.element("code", 200);
			result.element("result", all);
		} else {
			result.element("code", 201);
			result.element("message", "商品ID不存在");
		}
		return result;
	}

	// 获取所有
	@RequestMapping(value = "/common/skuListAll", method = RequestMethod.GET)
	public Map<String, Object> getGood2() {
		JSONObject result = new JSONObject();
		Map<String, Object> goods1 = new HashMap<>();
		Map<String, Object> goods2 = new HashMap<>();
		goods1.put("id", "3");
		goods1.put("searchParamList", "[]");
		goods1.put("stockId", "74966313");
		goods1.put("totalNumber", "200000");
		goods1.put("colour", "1");
		goods1.put("skuName", "夜空黑");
		goods1.put("goodsId", 1);
		goods1.put("price", "199");
		goods1.put("picUrl", "https://nos.163.com/yixinpublic");
		goods2.put("id", "5");
		goods2.put("searchParamList", "[]");
		goods2.put("stockId", "74966313");
		goods2.put("totalNumber", "200000");
		goods2.put("colour", "1");
		goods2.put("skuName", "青果绿");
		goods2.put("goodsId", 2);
		goods2.put("price", "199");
		goods2.put("picUrl", "https://nos.163.com/yixinpublic");
		ArrayList<Map<String, Object>> all = new ArrayList<Map<String, Object>>();
		all.add(goods1);
		all.add(goods2);
		result.element("message", "success");
		result.element("code", 200);
		result.element("result", all);
		return result;
	}
}
