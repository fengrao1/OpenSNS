package com;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.webtest.core.ApiListener.class)
public class Dome1 {
	@Test
	public void test1() {
		assertEquals(1, 2);
	}
	@Test
	public void test2() {
		assertEquals(1, 3);
	}

	@Test
	public void test3() {
		assertEquals(1, 1);

	}
	

}