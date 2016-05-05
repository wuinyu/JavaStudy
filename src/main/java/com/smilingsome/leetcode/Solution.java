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
 * Approach #3 Sliding Window Optimized [Accepted]
 * The above solution requires at most 2n steps. In fact, it could be optimized to require only n steps. 
 * Instead of using a set to tell if a character exists or not, we could define a mapping of the characters to its index. 
 * Then we can skip the characters immediately when we found a repeated character.
 * The reason is that if s[j]s[j] have a duplicate in the range [i, j)[i,j) with index j'j
 * ​​ , we don't need to increase ii little by little. We can skip all the elements in the range [i, j'][i,j​′​​ ] and let ii to be j' + 1j​′​​ +1 directly.
 */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
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
    
    public static void main(String[] args){
    	
    }
}
