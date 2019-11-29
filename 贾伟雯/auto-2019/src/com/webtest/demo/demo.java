package com.webtest.demo;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.jiaweiwen.ApiListener;
@Listeners(ApiListener.class)
public class demo {
	@Test
	public void t1() {
		System.out.println("hello");
	}

}
