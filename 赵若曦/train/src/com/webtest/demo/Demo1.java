package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.WebTestListener;
@Listeners(WebTestListener.class)
public class Demo1 {
	
	@Test(description="≤‚ ‘1")
	public void test1() {
		assertEquals(1, 2);
	}
	@Test(description="≤‚ ‘2")
	public void test2() {
		assertEquals(1, 1);
	}
	@Test(description="≤‚ ‘3")
	public void test3() {
		assertEquals(1, 3);
	}
	@Test(description="≤‚ ‘4")
	public void test4() {
		assertEquals(2, 2);
	}
}
