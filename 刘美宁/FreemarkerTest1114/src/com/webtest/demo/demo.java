package com.webtest.demo;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.freemarker.ApiListener.class})
public class demo extends BaseTest{
	@Test()
	public void demo1() {
		System.out.println("hello");
	}
	@Test()
	public void demo2() {
		System.out.println("=================test1=============");
	}
	@Test()
	public void demo3() {
		System.out.println("=================test2=============");
	}
	@Test()
	public void demo4() {
		System.out.println("=================test3=============");
	}
}
