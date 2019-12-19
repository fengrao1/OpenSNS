package com.example.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 杨柳
 * 
 */

public class Address {
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
}
