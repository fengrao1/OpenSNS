package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class Delete {
	
	//删除
		@RequestMapping(value="/address/delete",method=RequestMethod.POST,produces = "application/json;charset=UTF-8")
		public Map<String,String> delete(@RequestParam(name = "id",required =true) String id){
			if(id.equals("77479641")) {
				Map<String,String> result=new HashMap<>();
				result.put("message","success");
				result.put("code","200");
				return result;
			}

			Map<String,String> resultfail=new HashMap<>();
			resultfail.put("message","请求失败");
			resultfail.put("code","400");
			return resultfail;

		}

}
