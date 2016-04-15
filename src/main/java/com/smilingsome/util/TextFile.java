package com.smilingsome.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 用于读取文本文件，返回文本字符串
public class TextFile {
	public static void main(String args[]){
		String context = readText("test2.txt");
		System.out.println(StringUtil.getLetterString(context));
		writeText("tt.txt", context);
		System.out.println(Character.isLetter('}'));
	}
	public static String readText(String path){
		StringBuilder context = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(path))){
			String line = null;
			while((line = reader.readLine()) != null){
				context.append(line);
				context.append("\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return context.toString();
	}
	
	public static void writeText(String path, String context){
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
			writer.write(context);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
