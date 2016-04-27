package com.smilingsome.leetcode;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MySolution {
	/**
	 * <p>
	 * Two-sum
	 * <p>
	 * 
	 * <p>
	 * Given an array of integers, return indices of the two numbers such that
	 * they add up to a specific target. You may assume that each input would
	 * have exactly one solution.
	 * </p>
	 * <p>
	 * Example: Given nums = [2, 7, 11, 15], target = 9, Because nums[0] +
	 * nums[1] = 2 + 7 = 9, return [0, 1].
	 * </p>
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		/*
		 * 思路：从数据结构入手，Java中采用HashMap Key = 数值, value = 序号
		 */
		// 利用数组构造HashMap
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		// 求解答案
		for (int i = 0; i < nums.length; i++) {
			Integer index = map.get(target - nums[i]);
			if (index != null && index != i)
				return new int[] { i, index };
		}
		return null;
	}

	/**
	 * <p>
	 * Reverse-integer
	 * <p>
	 * 
	 * Reverse digits of an integer. Example1: x = 123, return 321 Example2: x =
	 * -123, return -321
	 * 
	 * @param x
	 * @return result
	 */
	public int reverse(int x) {
		String num = x + "";
		// 针对负数的问题
		if (num.charAt(0) == '-') {
			num = num.substring(1) + "-";
		}
		StringBuffer number = new StringBuffer(num);
		int result = 0;
		// 考虑反转后溢出的情况
		try {
			result = Integer.parseInt(number.reverse().toString());
		} catch (NumberFormatException e) {
		}
		return result;
	}

	/**
	 * <p>
	 * Inverse-sum
	 * <p>
	 * 
	 * calculate 1/1 + 1/2 + 1/3 + ... + 1/n should guaranteed precision
	 * 
	 * @param n
	 * @return
	 */
	public double inverse_sum(int n) {
		// BigDecimal 用来做高精度的浮点数四则运算
		BigDecimal sum = BigDecimal.ZERO;
		for (int i = n; i > 0; i--) {
			// BigDecimal.divide(BigDecimal divisor, int scale, int
			// roundingMode)
			// divisor 为除数, scale为小数点后精确位数, roudingMode为四舍五入模式 - 这里采用最近舍入模式
			sum = sum.add(BigDecimal.ONE.divide(BigDecimal.valueOf(i), 30, BigDecimal.ROUND_HALF_UP));
		}
		System.out.println(sum);
		return sum.doubleValue();
	}

	/**
	 * <p>
	 * string-to-integer-atoi
	 * <p>
	 * 
	 * Implement atoi to convert a string to an integer.(实现C++的atoi函数)
	 * 将一个合法的数字(默认10进制)字符串转换为整数，如果不合法则报错 atoi 函数介绍
	 * 
	 * 举例: Input: "  -0012a42" Expected Output: -12
	 * <p>
	 * The function first discards as many whitespace characters as necessary
	 * until the first non-whitespace character is found. Then, starting from
	 * this character, takes an optional initial plus or minus sign followed by
	 * as many numerical digits as possible, and interprets them as a numerical
	 * value.
	 * </p>
	 * 
	 * <p>
	 * The string can contain additional characters after those that form the
	 * integral number, which are ignored and have no effect on the behavior of
	 * this function.
	 * </p>
	 * 
	 * <p>
	 * If the first sequence of non-whitespace characters in str is not a valid
	 * integral number, or if no such sequence exists because either str is
	 * empty or it contains only whitespace characters, no conversion is
	 * performed.
	 * </p>
	 * 
	 * <p>
	 * If no valid conversion could be performed, a zero value is
	 * returned[不合法输入返回0]. If the correct value is out of the range of
	 * representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is
	 * returned.[溢出返回INT_MAX或INT_MIN]
	 * </p>
	 * 
	 * 
	 * @param str
	 * @return result;
	 */
	public int myAtoi(String s) throws NumberFormatException {
		// 去除两端空白字符
		s = s.trim();
		if (s == "" || s == null) {
			return 0;
		}
		int radix = 10;
		int result = 0;
		boolean negative = false;
		int i = 0, len = s.length();
		int limit = -Integer.MAX_VALUE;
		int multmin;
		int digit;

		if (len > 0) {
			char firstChar = s.charAt(0);
			if (firstChar < '0') { // Possible leading "+" or "-"
				if (firstChar == '-') {
					negative = true;
					limit = Integer.MIN_VALUE;
				} else if (firstChar != '+')
					return 0;
				if (len == 1) // Cannot have lone "+" or "-"
					return 0;
				i++;
			}
			multmin = limit / radix;
			while (i < len) {
				// Accumulating negatively avoids surprises near MAX_VALUE
				digit = Character.digit(s.charAt(i++), radix);
				if (digit < 0) {
					break;
				}
				if (result < multmin) {
					return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				}
				result *= radix;
				if (result < limit + digit) {
					return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				}
				result -= digit;
			}
		} else {
			return 0;
		}
		return negative ? result : -result;
	}

	public String longestCommonPrefix(String left, String right) {
		String prefix = null;
		// swap two string
		if (left.length() > right.length()) {
			String temp = left;
			left = right;
			right = left;
		}
		return prefix;
	}

	/**
	 * 
	 * <p>
	 * 寻找一个字符串数组的最长公共前缀
	 * </p>
	 * 
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		int index = 0;
		// 找出最短字符串的长度
		int minLength = Integer.MAX_VALUE;
		for (String str : strs) {
			if (str.length() < minLength)
				minLength = str.length();
		}
		// 寻找最长公共前缀
		outer: for (index = 0; index < minLength; index++) {
			char character = strs[0].charAt(index);
			for (int j = 1; j < strs.length; j++) {
				if (character != strs[j].charAt(index)) {
					break outer;
				}
			}
		}
		return strs[0].substring(0, index);
	}

	/**
	 * 
	 * <p>
	 * Description: TODO(这里用一句话描述这个方法的作用)
	 * </p>
	 * 
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
		int result = 0;
		Map<Character, Integer> romanMap = new HashMap<>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);

		for (int i = 0; i < s.length() - 1; i++) {
			int left = romanMap.get(s.charAt(i));
			int right = romanMap.get(s.charAt(i + 1));
			if (left >= right)
				result += left;
			else
				result -= left;
		}
		result += romanMap.get(s.charAt(s.length() - 1));
		return result;
	}

	/**
	 * 
	 * <p>
	 * 十进制数转换成罗马数字
	 * </p>
	 * <p>
	 * </p>
	 * 
	 * @param num
	 * @return romanString
	 */
	public String intToRoman(int num) {

		StringBuilder roman = new StringBuilder();
		roman.append(c[3][num / 1000 % 10]);
		roman.append(c[2][num / 100 % 10]);
		roman.append(c[1][num / 10 % 10]);
		roman.append(c[0][num % 10]);
		return roman.toString();
	}

	/**
	 * 
	 * You are given two linked lists representing two non-negative numbers. The
	 * digits are stored in reverse order and each of their nodes contain a
	 * single digit. Add the two numbers and return it as a linked list. Input:
	 * (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 含义: 342 + 465 = 807
	 * ListNode 是单链表数据结构
	 * 
	 * @param l1
	 * @param l2
	 * @return newHead.next
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;

		ListNode newHead = new ListNode(0);
		ListNode p1 = l1, p2 = l2, p3 = newHead;

		while (p1 != null || p2 != null) {
			if (p1 != null) {
				carry += p1.val;
				p1 = p1.next;
			}

			if (p2 != null) {
				carry += p2.val;
				p2 = p2.next;
			}

			p3.next = new ListNode(carry % 10);
			p3 = p3.next;
			carry /= 10;
		}

		if (carry == 1)
			p3.next = new ListNode(1);

		return newHead.next;
	}

	/**
	 * 
	 * <p>
	 * Merge two sorted linked lists and return it as a new list. The new list
	 * should be made by splicing together the nodes of the first two lists.a
	 * </p>
	 * 
	 * @param l1
	 * @param l2
	 * @return l
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode l = new ListNode(0);
		ListNode p1 = l1, p2 = l2, p = l;
		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}
		if (p1 != null)
			p.next = p1;
		if (p2 != null)
			p.next = p2;
		return l.next;
	}

	public void printListNode(ListNode l) {
		ListNode p = l;
		while (p != null) {
			if (p == l)
				System.out.print(p.val);
			else
				System.out.print(" -> " + p.val);
			p = p.next;
		}
		System.out.println();
	}

	public ListNode buildListNode(int[] source) {
		if (source.length == 0)
			return null;
		ListNode l = new ListNode(0);
		ListNode p = l;
		for (int val : source) {
			ListNode node = new ListNode(val);
			p.next = node;
			p = p.next;
		}
		return l.next;
	}

	/**
	 * Given a string, find the length of the longest substring without
	 * repeating characters.
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		int length = 0;
		int min = 0, max = 0;
		// 滑动窗口 HashMap HashSet
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character character = s.charAt(i);
			if (map.containsKey(character)) {
				int pos = map.get(character) + 1;
				// 计算窗口长度
				if (length < max - min)
					length = max - min;
				// 窗口移动，删除失效元素
				for (int index = min; index < pos; index++) {
					map.remove(s.charAt(index));
				}
				map.put(character, i);
				min = pos;
			} else {
				map.put(s.charAt(i), i);
			}
			max++;
		}
		if (length < max - min)
			length = max - min;
		return length;
	}

	public int lengthOfLongestSubstring_1(String s) {
		int res = 0, left = 0;
		int prev[] = new int[300];

		// init prev array
		for (int i = 0; i < 300; ++i)
			prev[i] = -1;

		for (int i = 0; i < s.length(); ++i) {
			if (prev[s.charAt(i)] >= left)
				left = prev[s.charAt(i)] + 1;
			prev[s.charAt(i)] = i;
			if (res < i - left + 1)
				res = i - left + 1;
		}
		return res;
	}

	/**
	 * <p>最长回文字符串</p> 
	 * Given a string S, find the longest palindromic substring in S.
	 * You may assume that the maximum length of S is 1000, and there exists one
	 * unique longest palindromic substring. 
	 * <p>动态规划实现算法:</p>
	 * 用flag[i][j]来记录从s的i位置到j位置是不是回文串 1. 初始化: (i >= j) flag[i][j] = true; 2. 计算:
	 * if s[i] == s[j] then flag[i][j] = flag[i+1][j-1] else flag[i][j] = false;
	 * 
	 * @param s
	 * @return substring
	 * 
	 */
	public String longestPalindrome(String s) {
		int start = 0, end = 0, max = 1;
		boolean flag[][] = new boolean[s.length()][s.length()];
		// 初始化flag数组
		for (int i = 0; i < s.length(); i++)
			for (int j = 0; j < s.length(); j++)
				if (i >= j)
					flag[i][j] = true;
				else
					flag[i][j] = false;

		// 计算flag数组
		for (int j = 1; j < s.length(); j++)
			for (int i = 0; i < j; i++)
				if (s.charAt(i) == s.charAt(j)) {
					flag[i][j] = flag[i + 1][j - 1];
					if (flag[i][j] == true && max < j - i + 1) {
						max = j - i + 1;
						start = i;
						end = j;
					}
				} else {
					flag[i][j] = false;
				}
		// 求最长回文串

		return s.substring(start, end + 1 > s.length() ? s.length() : end + 1);
	}
	/**
	 * 
	 * Implement strStr().
	 * 	Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
	 * @param haystack
	 * @param needle
	 * @return
	 */
    public int strStr(String haystack, String needle) {
    	// Java的indexOf方法 相当于C++的strStr方法
        return haystack.indexOf(needle); 
    }
    /**
     * <p>Maximum Subarray</p>
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
     * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
     * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
     * <p>More practice:</p>
     * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
    	if(nums.length == 0)
    		return 0;
    	// flag标记是否数组全部为负数
    	boolean flag = true;
    	
    	int maxSum = 0; 
    	int tempSum = 0;
    	// 记下最大值
    	int maxNum = Integer.MIN_VALUE; 
    	for(int i = 0; i < nums.length; i++){
    		if(maxNum < nums[i])
    			maxNum = nums[i];
    		tempSum += nums[i];
    		if(tempSum < 0)
    			tempSum = 0;
    		else if(maxSum < tempSum){
    			flag = false;
    			maxSum = tempSum;
    		}
    	}
    	if(flag)
    		return maxNum;
    	else
    		return maxSum;
    }
    
	public static void main(String[] args) {
		System.out.println(new MySolution().reverse(2147483647));
		System.out.println((2e31 - 1) == 2147483647);
		System.out.println(new MySolution().myAtoi("  -0012a42"));
		System.out.println(new MySolution().myAtoi("2147483648"));
		System.out.println(new MySolution().myAtoi("      -11919730356x"));
		new MySolution().lengthOfLongestSubstring_1("HelloWorld");
		// sum = 12.090146129863335 精度不够
		// System.out.println(new MySolution().inverse_sum(100000));
	}

	private String c[][] = { { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
			{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
			{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" }, { "", "M", "MM", "MMM" },

	};
}
