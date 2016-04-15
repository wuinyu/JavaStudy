package com.smilingsome.leetcode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMySolution {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLongestCommonPrefixStringArray() {
		MySolution solution = new MySolution();
		assertEquals(solution.longestCommonPrefix(new String[]{}), "");
		assertEquals(solution.longestCommonPrefix(new String[]{"", "", ""}), "");
		assertEquals(solution.longestCommonPrefix(new String[]{"", "a", "b", "c"}), "");
		assertEquals(solution.longestCommonPrefix(new String[]{"aabb", "aad", "aa", "ab"}), "a");
		assertEquals(solution.longestCommonPrefix(new String[]{" aabb", "aad", "aa", "ab"}), "");
		assertEquals(solution.longestCommonPrefix(new String[]{"abcd", "abcde", "abcdef", "abcdefg"}), "abcd");
	}

}
