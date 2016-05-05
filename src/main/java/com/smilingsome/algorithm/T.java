package com.smilingsome.algorithm;

import java.util.LinkedList;

public class T {
	static long count = 0;
	  static LinkedList<Integer> list = new LinkedList<Integer>();
	  public static void main(String[] args) {
	    split(10, 0);
	    System.out.println(count);
	  }



	  public static void split(int n, int base) {
	    if (n == 0) {
	    	count ++;
	    	System.out.println(list);
	      return;
	    }
	    for (int i = base + 1; i <= n; i++) {
	      list.addLast(i);
	      split(n - i, i - 1);
	      list.removeLast();
	    }
	  }

	}