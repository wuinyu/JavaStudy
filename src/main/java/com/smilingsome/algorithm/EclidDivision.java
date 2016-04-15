package com.smilingsome.algorithm;

import java.util.ArrayList;
import java.util.Scanner;
/* 辗转相除法：两个数的最大公约数，附带求乘法逆元 */
public class EclidDivision {
	/**
	 * Used to calculate two number's great common divisor(gcd)
	 * @param a
	 * @param b
	 * @param qlist
	 * @return gcd(a,b)
	 * @
	 */
/* 辗转相除法：两个数的最大公约数，附带求乘法逆元 */
	public static Long gcd(Long a, Long b){
		ArrayList<Long> qlist = new ArrayList<>();
	/*  如果 a 比 b 小, 交换 a 和 b 的顺序*/
		if(Math.abs(a) < Math.abs(b)){
			long temp = a;
			a = b;
			b = temp;
		}
//System.out.println("a = " + a + ", b = " + b);
	/* leftnum 存a, rightnum 存b*/
		long leftnum = a; 
		long rightnum = b;
	/* 辗转相除算法 直到b = 0， 此时 a 为a和b的最大公约数*/	
	/* 辗转相除 适用于 整数范围，不仅仅局限于 求正整数的最大公约数 */
		while(b != 0){
			long temp = a;
			a = b;
			qlist.add(temp/b); /* Q列表 */
			b = temp % b;
		}
	/* S列表： 
		Sj = Sj-2 + Qj-1 * Sj-1
		S0 = 1;
		S1 = 0;
		*/
		ArrayList<Long> slist = new ArrayList<>();
		slist.add(1L);
		slist.add(0L);
		/* T列表： 
		Tj = Tj-2 + Qj-1 * Tj-1
		S0 = 0;
		S1 = 1;
		*/		
		ArrayList<Long> tlist = new ArrayList<>();
		tlist.add(0L);
		tlist.add(1L);
		
		for(int i = 0; i < qlist.size() - 1; i++){
			Long q = qlist.get(i);
			slist.add(slist.get(slist.size()-2) - q *slist.get(slist.size()-1));
			tlist.add(tlist.get(tlist.size()-2) - q *tlist.get(tlist.size()-1));
		}
/* 输出结果:  s * a + t * b = (a, b) */	
//System.out.println("(" + slist.get(slist.size() - 1) + ") * " + leftnum	+ " + (" + 
//										tlist.get(tlist.size() - 1) + ") * " + rightnum +
//										" = " + a);
		return a;
	}
	public static void main(String[] args) {
		long r0 = 0, r1 = 0; 
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入第一个数：");
		r0 = scan.nextLong();
		System.out.println("请输入第二个数：");
		r1 = scan.nextLong();
		System.out.println(gcd(r0, r1));
	}

}
