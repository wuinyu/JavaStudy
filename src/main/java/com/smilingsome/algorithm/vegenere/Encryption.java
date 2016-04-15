package com.smilingsome.algorithm.vegenere;

import com.smilingsome.util.StringUtil;
import com.smilingsome.util.TextFile;
/**
 * 
 * <p>Vegenere Encryption algorithm</p>
 *
 */
public class Encryption {

	public Encryption(String key) {
		this.key = key;
	}
	
	public void encrypt(String plainTextPath, String cypherTextPath){
		StringBuilder cipherText = new StringBuilder(); // 加密结果
		
		String plainText = TextFile.readText(plainTextPath); // 明文内容
System.out.println("plainText = " + plainText.toString()); 
		if(plainText.length() == 0){
			System.err.println("path error:" + plainTextPath);
			return ;
		}
plainText = StringUtil.getLetterString(plainText.toUpperCase()); // 对明文的特殊处理
		int j = 0;
		for(int i = 0; i < plainText.length(); i++){
			// 如果是字母
			char alphabetic = plainText.charAt(i);
			if(Character.isLetter(alphabetic)){
				// 如果是字母，进行替换操作
				int shiftposition = (key.toLowerCase().charAt(j % key.length()) - 'a');
				int temp = alphabetic + shiftposition;
				if(temp > 'Z')// 加密有问题?
					temp -= 26;
				cipherText.append((char)temp); 
				j++; // 计数器加1
			}else{
				cipherText.append(alphabetic);
			}
		}
System.out.println("cipherText = " + cipherText.toString());
		TextFile.writeText(cypherTextPath, cipherText.toString());
	}
	
	public static void main(String[] args){
		Encryption test = new Encryption("dcdad"); // 注意dddd
		test.encrypt("test2.txt", "cypherText.txt");
	}
	
	private String key;
}
