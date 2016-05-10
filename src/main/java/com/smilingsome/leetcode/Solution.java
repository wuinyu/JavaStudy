package com.smilingsome.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
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

	/*
	 * Approach #3 Sliding Window Optimized [Accepted] The above solution
	 * requires at most 2n steps. In fact, it could be optimized to require only
	 * n steps. Instead of using a set to tell if a character exists or not, we
	 * could define a mapping of the characters to its index. Then we can skip
	 * the characters immediately when we found a repeated character. The reason
	 * is that if s[j]s[j] have a duplicate in the range [i, j)[i,j) with index
	 * j'j ​​ , we don't need to increase ii little by little. We can skip all
	 * the elements in the range [i, j'][i,j​′​​ ] and let ii to be j' + 1j​′​​
	 * +1 directly.
	 */
	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>(); // current index of
														// character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; ++j) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}

	/**
	 * Given a linked list, remove the nth node from the end of list and return
	 * its head.
	 * 
	 * For example,
	 * 
	 * Given linked list: 1->2->3->4->5, and n = 2.
	 * 
	 * After removing the second node from the end, the linked list becomes
	 * 1->2->3->5. Note: Given n will always be valid. 一次遍历， 假设给定的参数n永远合法
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;

		ListNode fast = head;
		ListNode slow = head;

		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}

		// if remove the first node
		if (fast == null) {
			head = head.next;
			return head;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		return head;
	}

	/**
	 * Reverse digits of an integer.
	 * 
	 * Example1: x = 123, return 321 Example2: x = -123, return -321
	 * 
	 * 
	 * Have you thought about this? Here are some good questions to ask before
	 * coding. Bonus points for you if you have already thought through this!
	 * 
	 * If the integer's last digit is 0, what should the output be? ie, cases
	 * such as 10, 100.
	 * 
	 * Did you notice that the reversed integer might overflow? Assume the input
	 * is a 32-bit integer, then the reverse of 1000000003 overflows. How should
	 * you handle such cases?
	 * 
	 * For the purpose of this problem, assume that your function returns 0 when
	 * the reversed integer overflows.
	 * 
	 * @param x
	 * @return result
	 */
	public int reverse(int x) {
		int result = 0;

		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			if ((newResult - tail) / 10 != result) {
				return 0;
			}
			result = newResult;
			x = x / 10;
		}

		return result;
	}

	/**
	 * Determine whether an integer is a palindrome. Do this without extra
	 * space. 判断一个整数是否为回文数，不能占用额外的空间 click to show spoilers.
	 * 
	 * Some hints: Could negative integers be palindromes? (ie, -1) 负数显然不是回文数 If
	 * you are thinking of converting the integer to string, note the
	 * restriction of using extra space.
	 * 
	 * You could also try reversing an integer. However, if you have solved the
	 * problem "Reverse Integer", you know that the reversed integer might
	 * overflow. How would you handle such case?
	 * 
	 * There is a more generic way of solving this problem. 没有解决
	 * 
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		// negative numbers are not palindrome
		if (x < 0)
			return false;

		// initialize how many zeros
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}

		while (x != 0) {
			int left = x / div;
			int right = x % 10;

			if (left != right)
				return false;

			x = (x % div) / 10;
			div /= 100;
		}
		return true;
	}

	/**
	 * Divide two integers without using multiplication, division and mod
	 * operator.
	 * 
	 * If it is overflow, return MAX_INT.
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public int divide(int dividend, int divisor) {
		return 0;
	}

	public static void main(String[] args) {

	}
}
