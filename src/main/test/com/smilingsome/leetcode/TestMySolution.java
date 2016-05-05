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
	@Ignore("Tested")
	public void testmergeTwoLists(){
		MySolution solution = new MySolution();
		solution.printListNode(solution.mergeTwoLists(null, null));
		solution.printListNode(solution.mergeTwoLists(null, new ListNode(0)));
		solution.printListNode(solution.mergeTwoLists(new ListNode(0), null));
		solution.printListNode(solution.mergeTwoLists(solution.buildListNode(new int[]{1, 2, 3}), null));
		solution.printListNode(solution.mergeTwoLists(solution.buildListNode(new int[]{1, 2, 3}), solution.buildListNode(new int[]{1, 2, 3}) ));
		solution.printListNode(solution.mergeTwoLists(solution.buildListNode(new int[]{1, 2, 3}), solution.buildListNode(new int[]{1, 5, 6, 7, 8, 10}) ));
	}
	
	@Test
	public void testlengthOfLongestSubstring(){
		MySolution solution = new MySolution();
		assertEquals(solution.lengthOfLongestSubstring("HelloWorld"), 5);
		assertEquals(solution.lengthOfLongestSubstring(""), 0);
		assertEquals(solution.lengthOfLongestSubstring("abcde"), 5);
		assertEquals(solution.lengthOfLongestSubstring("aaabbccc"), 2);
		assertEquals(solution.lengthOfLongestSubstring("aaabcdef"), 6);
		assertEquals(solution.lengthOfLongestSubstring("bcdefaaa"), 6);
	}
	
	@Test
	public void testlongestPalindrome(){
		MySolution solution = new MySolution();
		assertEquals(solution.longestPalindrome(""), "");
		assertEquals(solution.longestPalindrome(""), "");
		assertEquals(solution.longestPalindrome("aba"), "aba");
		assertEquals(solution.longestPalindrome("abba"), "abba");
		assertEquals(solution.longestPalindrome("abcbdadba"), "bdadb");
	}
	
	@Test
	public void teststrStr(){
		MySolution solution = new MySolution();
		assertEquals(solution.strStr("aa", ""), 0);
		assertEquals(solution.strStr("aa", "a"), 0);
		assertEquals(solution.strStr("abccba", "cc"), 2);
		assertEquals(solution.strStr("abccba", "ba"), 4);
	}
	
	@Test
	public void testmaxSubArray(){
		MySolution solution = new MySolution();
		assertEquals(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), 6);
		assertEquals(solution.maxSubArray(new int[]{}), 0);
		assertEquals(solution.maxSubArray(new int[]{-2, -1, -3}), -1);
	}
	
	@Test
	public void testswapPairs(){
		MySolution solution = new MySolution();
		solution.printListNode(solution.swapPairs(null));
		solution.printListNode(solution.swapPairs(new ListNode(0)));
		solution.printListNode(solution.swapPairs(solution.buildListNode(new int[]{1, 2, 3})));
		solution.printListNode(solution.swapPairs(solution.buildListNode(new int[]{1, 2, 3, 4})));
		solution.printListNode(solution.swapPairs(solution.buildListNode(new int[]{1}) ));
	}
}
