package com.example.demo;

import java.util.ArrayList;
import java.util.Map;


/**
 * @author 杨柳
 * 
 */
public class Return {
		
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
