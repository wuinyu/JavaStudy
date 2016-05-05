package com.smilingsome.util;

import java.math.BigInteger;

public class StringUtil {
	public static void main(String[] args){
		
	}
	
	public static String byteToHexString(byte[] b){
		String result = "";
		for (int i = 0; i < b.length; i++){
			int v = b[i] & 0xFF;
			if(v < 16) 
				result += "0";
			result += Integer.toString(v, 16).toUpperCase() + "";
			
		}
		return result;
	}
	
	public static byte[] hexToBytes(String str) {
		if (str == null) {
			return null;
		} else if (str.length() < 2) {
			return null;
		} else {
			int len = str.length() / 2;
			byte[] buffer = new byte[len];
			for (int i = 0; i < len; i++) {
				buffer[i] = (byte) Integer.parseInt(
						str.substring(i * 2, i * 2 + 2), 16);
			}
			return buffer;
		}

	}

	// 根据url获取文件名,举例 http://hstore.cs.brown.edu/slides/hstore-hpts-oct2011.pdf
	private static String getName(String url){
		int indexname = url.lastIndexOf("/");
		if (indexname == url.length()) 
			url = url.substring(1, indexname);
		indexname = url.lastIndexOf("/");
		final String name = url.substring(indexname, url.length());
		System.out.println(name);
		return name;
	}
	
	public static String bytesToHex(byte[] data) {
		if (data == null) {
			return null;
		} else {
			int len = data.length;
			String str = "";
			for (int i = 0; i < len; i++) {
				if ((data[i] & 0xFF) < 16)
					str = str + "0"
							+ java.lang.Integer.toHexString(data[i] & 0xFF);
				else
					str = str + java.lang.Integer.toHexString(data[i] & 0xFF);
			}
			return str.toUpperCase();
		}
	}
	
    public static void pArray(short[] a, int index, int len)
    {
    	for (int i=index; i<index+len; i++){
	    if (a[i] < 16)
	    	System.out.print("0");
	    System.out.print(Integer.toHexString(a[i]));
	    if(i % 4 == 0)
	    	System.out.print(" ");
	}
    	System.out.println();
    }
	
    public BigInteger get_bn(short[] a, int index, int len) // 送short[]数组中 get BigInteger
    {
    	BigInteger tmp;

    	tmp = new BigInteger("0");

    	for (int i=index; i<len+index; i++){
	    tmp = tmp.shiftLeft(8);
	    tmp = tmp.add(BigInteger.valueOf(a[i]));
	}
    	System.out.println(tmp.toString(16));

    	return tmp;
    }
    
    public static String getLetterString(String text){
    	StringBuilder result = new StringBuilder();
    	
    	for(int i = 0; i < text.length(); i++){
    		char letter = text.charAt(i);
    		if(Character.isLetter(letter))
    			result.append(letter);
    	}
    	return result.toString();
    }

}
