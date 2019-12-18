package com.example.demo;

import java.util.ArrayList;
import java.util.Map;

import net.sf.json.JSONArray;
/**
 * @author 李少涵
 * 接口返回信息方法2
 */
public class Return2 {
	
	private String message;
	private int code;
	private ArrayList<Map<String, Object>> result;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public ArrayList<Map<String, Object>> getResult() {
		return result;
	}
	public void setResult(ArrayList<Map<String, Object>> result) {
		this.result = result;
	}
}
