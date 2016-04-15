package com.smilingsome.algorithm.vegenere;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import java.util.Map;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.smilingsome.algorithm.EclidDivision;
import com.smilingsome.util.StringUtil;
import com.smilingsome.util.TextFile;
/**
 * 
 * <p>Vegenere Decryption algorithm</p>
 *
 */
public class Decryption {
	public Decryption(){
		double[] probability = { 
				0.082, 0.015, 0.028, 0.043, 0.127, 0.022, 0.020, 0.061, 0.070,
				0.002, 0.008, 0.040, 0.024, 0.067, 0.075, 0.019, 0.001, 0.060,
				0.063, 0.091, 0.028, 0.010, 0.023, 0.001, 0.020, 0.001};
		mg = new HashMap<>();
		for(int i = 0; i < alphabet.length(); i++)
			mg.put(alphabet.charAt(i), probability[i]);
	}
	public static void main(String[] args) {
		Decryption test = new Decryption();
		String cipherText = TextFile.readText("cypherText.txt");
//		System.out.println(cipherText);
		// 计算密钥长度
		int keyLength = test.kasiski(cipherText);
//		System.out.println(cipherText);
		test.setKeyLength(keyLength);
		test.getKey(cipherText);
		
	}
	
	// Coincidence Index 指数重合法 求解密钥
	// 求解密钥
	private String[] groupStringByKey(String cipherText){
		StringBuilder[] group = new StringBuilder[keyLength];
		for(int i = 0; i < keyLength; i++){
			group[i] = new StringBuilder();
		}
		for(int i = 0; i < cipherText.length(); i++){

			group[i % keyLength].append(cipherText.charAt(i));
		}
		String result[] = new String[keyLength];
		for(int i = 0; i < group.length; i++){
			result[i] =  group[i].toString();
		}
		return result;
	}
	public String getKey(String cipherText){
		// 字符串分组
		String[] groupString = groupStringByKey(cipherText);
// FEEEAOIGHLSIOGPEARCRRIEPNALHPD
		for(int i = 0; i < groupString.length; i++)
			System.out.println("length = " + groupString[i].length() + " : " + groupString[i]);
		
		// 对每个分组求概率分布函数(probability distribution)
		HashMap<String, HashMap<Character, Integer>> probabilityMap = new HashMap<>();
		for(int i = 0; i < groupString.length; i++){
			String text = groupString[i];
			if(probabilityMap.get(text) == null)
				probabilityMap.put(text, new HashMap<Character, Integer>());
			HashMap<Character, Integer> probability = probabilityMap.get(text);
			
			for(int j = 0; j < alphabet.length(); j++)
				probability.put(alphabet.charAt(j), 0);
			
			for(int j = 0; j < text.length(); j++){
				Character letter = text.charAt(j);
				Integer count = probability.get(letter); 
				if( count == null)
					continue;
				probability.put(letter, count + 1);
			}
System.out.println(probability);	
		}
		
		// 计算Mg0 - Mg25
		for(int k = 0; k < groupString.length; k++){// 
			ArrayList<Double> resultArray = new ArrayList<>();
			HashMap<Character, Integer> probability = probabilityMap.get(groupString[k]);
			for(int g = 0; g < 26; g++){
				double result = 0.0;
				for(int i = 0; i < mg.size(); i++){
					result += (mg.get(alphabet.charAt(i)) * probability.get(alphabet.charAt((i+g)%26)))/groupString[k].length();	
				}
				resultArray.add(result);
			}
			System.out.println(resultArray);
		}
		
		return null;
	}
	// kasiski 测试法: 搜索 长度至少为3且最多的 的相同的密文端，记下距离 deta, 猜测密钥长度m为所有deta的最大公约数
	public int kasiski(String cipherText){
		// 获得
		int length = 3; // 搜索子串的长度
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		cipherText = StringUtil.getLetterString(cipherText.toUpperCase());
// System.out.println("length = " + cipherText.length() + " cipherText = " + cipherText.toString());
		
		for(int i = 0; i < cipherText.length() - length; i++){
			// 获得长度为length的子串
			String substr = cipherText.substring(i, i + length);	
			Pattern pattern = Pattern.compile(substr);
			int count = 0; // 子串的个数
			// 用正则表达式 计数
			Matcher matcher = pattern.matcher(cipherText);
			while(matcher.find())	
				count++;
			list.add(count);
		}
// System.out.println("list size = " + list.size() + ",list = " + list);
		int max = Collections.max(list);
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) == max){
				String word = cipherText.substring(i, i + length);
				if(map.get(word) == null)
					map.put(word, new ArrayList<Integer>());
				map.get(word).add(i);
			}
		}
		// 计算相同单词之间的距离
		for(Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()){
			String word = entry.getKey();
			ArrayList<Integer> temp = entry.getValue();
			ArrayList<Integer> distance = new ArrayList<>();
			for(int i = 0; i < temp.size() - 1; i++){
				distance.add(temp.get(i+1) - temp.get(i));
			}
			map.put(word, distance);
		}
		// 计算所有距离的最大公约数
		ArrayList<Long> result = new ArrayList<>();
		for(Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()){
			String word = entry.getKey();
			ArrayList<Integer> distance = entry.getValue();
			long temp = 0;
			for(int i = 0; i < distance.size(); i++){
				temp = EclidDivision.gcd(distance.get(i).longValue(), temp);
			}
			result.add(temp);
//			System.out.println(word + " : " + temp);
		}
// For decades, Americas economic might the dollars claims to reign supreme.
// Fpt gedcget, Cpeskfat gfooqpid olgiv whf frlmcus dndinu wo sglgo uxpsgpe.
// FPT GEDCGET  CPESKFAT GFOOQPID OLGIV WHF FRLMCUS DNDINU WO SGLGO UXPSGPE
// UJH=[263, 464, 530, 662]
// UJK=[269, 473, 541, 673]
//System.out.println(map);
		return Collections.min(result).intValue();
	}
	public void setKey(String key) {
		this.key = key;
	}
	public void setKeyLength(int keyLength) {
		this.keyLength = keyLength;
	}
	private HashMap<Character, Double> mg = null;
	private int keyLength = 0;
	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String key;
}
 