package com.smilingsome.leetcode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
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
	@Test
	@Ignore("Tested")
	public void testIntToRoman()
	{
		MySolution solution = new MySolution();
		for(int i = 0; i < 4000; i++)
			System.out.println(solution.intToRoman(i));
	}
	@Test
	@Ignore("Tested")
	public void testromanToInt(){
		MySolution solution = new MySolution();
		for(int i = 1; i < 4000; i++)
			System.out.println(solution.intToRoman(i) + ":" + solution.romanToInt(solution.intToRoman(i)));
	}

	@Test
	public void testmergeTwoLists(){
		MySolution solution = new MySolution();
		solution.printListNode(solution.mergeTwoLists(null, null));
		solution.printListNode(solution.mergeTwoLists(null, new ListNode(0)));
		solution.printListNode(solution.mergeTwoLists(new ListNode(0), null));
		solution.printListNode(solution.mergeTwoLists(solution.buildListNode(new int[]{1, 2, 3}), null));
		solution.printListNode(solution.mergeTwoLists(solution.buildListNode(new int[]{1, 2, 3}), solution.buildListNode(new int[]{1, 2, 3}) ));
		solution.printListNode(solution.mergeTwoLists(solution.buildListNode(new int[]{1, 2, 3}), solution.buildListNode(new int[]{1, 5, 6, 7, 8, 10}) ));
	}
}
