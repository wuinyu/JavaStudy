package com.smilingsome.leetcode;

import java.math.BigDecimal;
import java.util.HashMap;

public class MySolution {
	/**
	 * <p>Two-sum<p>
	 * 
	 * <p>Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	 * You may assume that each input would have exactly one solution.</p>
	 * <p>Example:
	 * Given nums = [2, 7, 11, 15], target = 9,
	 * Because nums[0] + nums[1] = 2 + 7 = 9,
	 * return [0, 1].</p>
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
	 * <p>Reverse-integer<p>
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
	 * <p>Inverse-sum<p>
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
	 * <p>string-to-integer-atoi<p>
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
	
	public String longestCommonPrefix(String left, String right){
		String prefix = null;
		// swap two string
		if(left.length() > right.length()){
			String temp = left;
			left = right;
			right = left;
		}
		return prefix;
	}
	
    public String longestCommonPrefix(String[] strs) {
//    	if(strs.length == 0)
//    		return "";
    	int index = 0;
    	// 找出最短字符串的长度
    	int minLength = Integer.MAX_VALUE;
    	for(String str : strs){
    		if(str.length() < minLength)
    			minLength = str.length();
    	}
    	// 寻找最长公共前缀
    	outer:
    	for(index = 0; index < minLength; index++){
    		char character = strs[0].charAt(index);
    		for(int j = 1; j < strs.length; j++){
    			if(character != strs[j].charAt(index)){
    				break outer;
    			}
    		}
    	}
        return strs[0].substring(0, index);
    }
    
	public static void main(String[] args) {
		System.out.println(new MySolution().reverse(2147483647));
		System.out.println((2e31 - 1) == 2147483647);
		System.out.println(new MySolution().myAtoi("  -0012a42"));
		System.out.println(new MySolution().myAtoi("2147483648"));
		System.out.println(new MySolution().myAtoi("      -11919730356x"));
		// sum = 12.090146129863335 精度不够
		// System.out.println(new MySolution().inverse_sum(100000));
	}

}
