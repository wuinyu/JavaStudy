package com.smilingsome.algorithm;

public class MerkleDamgard {
/**
 * Merkle–Damgård 结构：碰撞稳固的 Hash函数 
 * compress: {0, 1}m+t -> {0, 1}m 
 * @param args
 */
/**
 *  compress : {0, 1}m+t  --> {0, 1}m
 *  n <-- |x|
 *  k <-- [n/(t-1)]
 *  d <-- n - k * (t - 1)
 *  
 * @param args
 */
	public static void merkleDamgard(byte[] message, int m, int t){
		int n = message.length;
		int k = n/(t-1);
		int d = n - k * ( t - 1);
		for(int i = 0; i < k - 1; i++){
			
		}
	}
	public static void main(String[] args) {


	}

}
