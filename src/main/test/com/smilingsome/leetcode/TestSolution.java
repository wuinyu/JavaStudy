package com.smilingsome.leetcode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSolution {

	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void testReverse(){
		Solution solution = new Solution();
		assertEquals(solution.reverse(321), 123);
		assertEquals(solution.reverse(2147483647), 0);
		assertEquals(solution.reverse(1000000007), 0);
	}

}
