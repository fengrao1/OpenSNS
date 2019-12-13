package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Submit_Test {
	@ResponseBody
    @RequestMapping(value="/fgadmin/orders/submit",method=RequestMethod.POST,produces = "application/json")
    public String submitTest() {
		
	      return null;
      }
}
