package com.edu.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.core.ApiListener;
import com.edu.core.NewListener;

@Listeners(ApiListener.class)
public class Dome2 {
	@Test
	public void t2() {
		System.out.println("hello");
		
	}
}
