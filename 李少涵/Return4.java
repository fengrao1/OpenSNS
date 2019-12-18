package com.example.demo;

import java.util.Map;
import java.util.Objects;
/**
 * @author 李少涵
 * 接口返回信息方法4
 */
public class Return4 {
	private String message;
	private Map<String, Object> result;
	int code;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
}
