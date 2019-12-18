package com.example.demo;

/**
 * @author 李少涵
 * 接口返回信息方法1
 */
public class Return {

	private String message;
	private int code;
	
//	public Return(String message,int code) {
//		super();
//		this.message=message;
//		this.code=code;
//	}

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
	
	
}
