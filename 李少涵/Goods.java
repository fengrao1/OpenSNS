package com.example.demo;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 李少涵
 * 存储商品列表信息
 */
public class Goods {
	public Map<String, Object> setGoods(int id,int stockId,int totalNumber,int colour,String skuName, int idd,String goodsName,int sellChannel,int goodsId,int price,String picUrl ) {
		Map<String, Object> map1=new HashMap<String, Object>();
		Map<String, Object> map1_good=new HashMap<String, Object>();
		map1.put("id", id);
		map1.put("stockId", stockId);
		map1.put("totalNumber", totalNumber);
		map1.put("colour", colour);
		map1.put("skuName", skuName);
		
		map1_good.put("id", idd);
		map1_good.put("goodsName", goodsName);
		map1_good.put("sellChannel", sellChannel);
		
		map1.put("goods", map1_good);
		map1.put("goodsId", goodsId);
		map1.put("price", price);
		map1.put("picUrl", picUrl);
		return map1;		
	}
	
	
	public ArrayList<Map<String, Object>> getGoods() {
		ArrayList<Map<String, Object>> list=new ArrayList< Map<String, Object>>();
		Map<String, Object> map1=setGoods(3, 74966313, 200000, 1, "夜空黑", 1, "青果", 1, 1, 199, "https://nos.163.com/yixinpublic");
		Map<String, Object> map2=setGoods(2, 74966312, 200000, 0, "青果绿", 1, "青果", 1, 1, 199, "https://nos.163.com/yixinpublic");
		Map<String, Object> map3=setGoods(5, 74966313, 200000, 1, "夜空黑", 2, "青果", 2, 2, 199, "https://nos.163.com/yixinpublic5");
		Map<String, Object> map4=setGoods(4, 74966313, 200000, 0, "青果绿", 2, "青果", 2, 2, 199, "https://nos.163.com/yixinpublic");
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		return list;
	}
	public ArrayList<Map<String, Object>> getGoods1() {
		ArrayList<Map<String, Object>> list=new ArrayList< Map<String, Object>>();
		Map<String, Object> map1=setGoods(3, 74966313, 200000, 1, "夜空黑", 1, "青果", 1, 1, 199, "https://nos.163.com/yixinpublic");
		Map<String, Object> map2=setGoods(2, 74966312, 200000, 0, "青果绿", 1, "青果", 1, 1, 199, "https://nos.163.com/yixinpublic");
		list.add(map1);
		list.add(map2);
		return list;
	}
	public ArrayList<Map<String, Object>> getGoods2() {
		ArrayList<Map<String, Object>> list=new ArrayList< Map<String, Object>>();
		Map<String, Object> map3=setGoods(5, 74966313, 200000, 1, "夜空黑", 2, "青果", 2, 2, 199, "https://nos.163.com/yixinpublic5");
		Map<String, Object> map4=setGoods(4, 74966313, 200000, 0, "青果绿", 2, "青果", 2, 2, 199, "https://nos.163.com/yixinpublic");
		list.add(map3);
		list.add(map4);
		return list;
	}
	

	
}
