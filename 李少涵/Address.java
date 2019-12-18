package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Address {
	/**
	 * @author 李少涵
	 * 将收获地址信息存入map
	 */
	public static Map<String, Object> getAdd(String skuIds,String skuNumbers,String stockIds,String receiverName,String addressDetail,String province,String city,String area,int transportFee ){
		Map<String, Object> ad =new HashMap<String, Object>();
		ad.put("skuIds", skuIds);
		ad.put("skuNumbers", skuNumbers);
		ad.put("stockIds", stockIds);
		ad.put("receiverName", receiverName);
		ad.put("addressDetail", addressDetail);
		ad.put("province",province);
		ad.put("city", city);
		ad.put("area",area);
		ad.put("transportFee",transportFee);
		return ad;
	}
	
	/**
	 * @author 李少涵
	 * 将要添加的地址信息存入map
	 */
	public static Map<String, Object> add(String receiverName,String addressDetail,String province,String city,String area){
		Map<String, Object> add =new HashMap<String, Object>();
		add.put("receiverName", receiverName);
		add.put("addressDetail", addressDetail);
		add.put("province",province);
		add.put("city", city);
		add.put("area",area);
		return add;
	}
}
