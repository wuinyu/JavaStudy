package com.smilingsome.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 * 001 Junit 入门
 * 第一个Junit case类 TestJunit
 *
 */
public class TestJunit {
	@Test
	public void testAdd(){
		String str = "Hello Junit";
		assertEquals("Hello Junit", str);
	}

}
