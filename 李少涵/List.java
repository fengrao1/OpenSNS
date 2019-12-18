package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李少涵
 * 存储用户地址信息
 */
public class List {

	public Map<String, Object> getList(){
		Map<String, Object> li=new HashMap<String, Object>();
		li.put("searchParamList", getParamList());
		li.put("limit", 50);
		li.put("total", 2);
		li.put("list", list());
		li.put("perfix", "A.");
		li.put("fgUserId", 74966314);
		return li;
	}
	public ArrayList<Integer> getParamList(){
		ArrayList<Integer> paramList=new ArrayList<Integer>();
		paramList.add(74966314);
		paramList.add(50);
		paramList.add(0);
		return paramList;
	}
	
	public ArrayList<Object> list(){
		ArrayList<Object> list=new ArrayList<Object> ();
		Map<String, Object> list1=new HashMap<String, Object>();
		Map<String, Object> list2=new HashMap<String, Object>();
		Map<String, Object> fgUser1=getFgUser(74966314,"86","20000000000","1454057846653","86/20000000000","测试用户20","2016-01-29 16:57:26","手机");
		Map<String, Object> fgUser2=getFgUser(74966314,"86","20000000000","1454057846653","86/20000000000","测试用户20","2016-01-29 16:57:26","手机");
		list1=getGetList(77479641,99,"浙江省","杭州市","滨江区","张三","12345678901","浙江大学",74966314,fgUser1);
		list2=getGetList(77479640,99,"浙江省","杭州市","滨江区","张三","12345678901","浙江大学",74966314,fgUser2);
		list.add(list1);
		list.add(list2);
		return list;
	}
	public Map<String, Object> getGetList(int id,int sort,String province,String city,String area,String receiverName,String cellPhone,String addressDetail,int fgUserId,Map<String, Object> fgUser ){
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------fguser,需要再写一个方法
		Map<String, Object>listMap=new HashMap<String, Object>();
		listMap.put("id", id);
		listMap.put("sort", sort);
		listMap.put("province", province);
		listMap.put("city", city);
		
		listMap.put("area", area);
		listMap.put("receiverName", receiverName);
		listMap.put("cellPhone", cellPhone);
		listMap.put("addressDetail", addressDetail);
		listMap.put("fgUserId", fgUserId);
		listMap.put("fgUser", fgUser);
		return listMap;
	
	
	}
	
	public Map<String, Object> getFgUser(int id,String phoneArea,String phoneNumber,String createTime,String userAccount,String userName,String createTimeStr,String platformDescribe){
		Map<String, Object>userMap=new HashMap<String, Object>();
		userMap.put("id", id);
		userMap.put("phoneArea", phoneArea);
		userMap.put("phoneNumber", phoneNumber);
		userMap.put("createTime", createTime);
		userMap.put("userAccount", userAccount);
		userMap.put("userName", userName);
		userMap.put("createTimeStr", createTimeStr);
		userMap.put("platformDescribe", platformDescribe);
		return userMap;
		
	}
}
