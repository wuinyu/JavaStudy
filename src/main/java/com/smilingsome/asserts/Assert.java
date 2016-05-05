/**
 * Java 断言机制允许程序测试期间插入一些代码。
 * 当代码发布时，这些检测代码就被自动移走。
 * Java语言使用 assert 关键字表示断言
 * 有两种形式: 
 * 	assert condition;
 * 	assert condition: expression ;
 * 如果condition= =false, 抛出(unchecked Exception).AssertionError，不可捕获
 * 
 * 启用/关闭断言举例:
 * 	java 	-enableassertions(ea)[:<packagename>…|:<classname>]
 * 				-disableassertions(da)
 * 				-enablesystemassertions 启用系统断言
 * 				-disablesystemassertions 关闭系统断言
 * 
 * 断言用途:
 * 	参数检查(前置条件)
 * 	为文档假设使用断言
 * 
 * 断言相关API(java.lang.ClassLoader 1.0):
 *   void setDefaultAssertionStatus(boolean b)
 *     void setClassAssertionStatus(String className, boolean b)
 *       void setPackagetAssertionStatus(String packageName, boolean b)
 *         void clearAssertionStatus(Boolean b)
 */
package com.smilingsome.asserts;


public class Assert {
	/**
	 * 
	 * java -ea com.smilingsome.asserts.Assert
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 0;
		System.out.println(x);
		// 结果:
		// 0
		// Exception in thread "main" java.lang.AssertionError: error
		// at com.smilingsome.asserts.Assert.main(Assert.java:38)
		assert x > 0 : "error";
		
	}
	
	/**
	 * @param file 表示文件名
	 * @param path 表示路径
	 * @param username 表示用户名
	 * @return String 返回值
	 * 
	 */
	public String test(String file, String path, String username){
		return null;		
	}

}
