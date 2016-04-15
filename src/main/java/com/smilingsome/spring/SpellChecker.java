package com.smilingsome.spring;
/**
 * 
 * <p>Inner Bean测试</p>
 * <p>TextEditor类持有一个SpellChecker类</p>
 * <p>在bean文件中, TextEditor的bean会内嵌一个SpellChecker的bean</p>
 * <p>SpellChecker类</p>
 */
public class SpellChecker {
	   public SpellChecker(){
		      System.out.println("Inside SpellChecker constructor." );
		   }

		   public void checkSpelling(){
		      System.out.println("Inside checkSpelling." );
		   }
}
