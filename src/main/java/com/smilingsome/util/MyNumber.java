package com.smilingsome.util;

import java.math.BigInteger;

public class MyNumber {
	// 异或函数
	public static byte[] xor_func(byte[] a, byte[] b) {
		byte[] out = new byte[a.length];
		for (int i = 0; i < a.length; i++) {
			out[i] = (byte) (a[i] ^ b[i]);
		}
		return out;
	}
	
	public static void main(String[] args){
		byte[] in = {0x00, 0x07};
		BigInteger value = new BigInteger(in);
		value = value.clearBit(0);
		System.out.println(value);
	}
}
