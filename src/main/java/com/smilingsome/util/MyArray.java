package com.smilingsome.util;

import java.math.BigInteger;

public class MyArray {
	public static byte[] shitRightByteArray(byte[] in, int n){
		BigInteger bigInt = new BigInteger(in);
		BigInteger shiftInt = bigInt.shiftRight(n);
		return shiftInt.toByteArray();
	}
	
	public static byte[] shitLeftByteArray(byte[] in, int n){
		BigInteger bigInt = new BigInteger(in);
		BigInteger shiftInt = bigInt.shiftLeft(n);
		return shiftInt.toByteArray();
	}
	
	public static void setBit(byte[] input, int position) {
	    int byteLocation = position / 8;
	    int bitLocation = position % 8;
	    input[byteLocation] = (byte) (input[byteLocation] ^ (byte) (1 << bitLocation));
	}
	
	public static void main(String[] args){
		byte [] array = new byte[]{0x7F,0x11,0x22,0x33,0x44,0x55,0x66,0x77};

		// create from array
		BigInteger bigInt = new BigInteger(array);

		// shift
//		BigInteger shiftInt = bigInt.shiftRight(4);
		BigInteger shiftInt = bigInt.shiftLeft(4);

		// back to array
		byte [] shifted = shiftInt.toByteArray();

		// print it as hex
		for (byte b : shifted) {
		    System.out.print(String.format("%X ", b));
		}
	}
}
