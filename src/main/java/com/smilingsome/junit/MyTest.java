package com.smilingsome.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
	String message = "Hello World";
	MessageUtil messageUtil = new MessageUtil(message);
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPrintMessage() {
		assertEquals(message, messageUtil.printMessage());
	}

}
