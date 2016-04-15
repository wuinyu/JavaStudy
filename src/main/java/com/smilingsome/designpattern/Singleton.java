package com.smilingsome.designpattern;
// 单例模式 - 懒汉式
//public class Singleton {
//	private volatile static Singleton instance = null;
//	private Singleton() {	}
//	public static Singleton getInstance(){
//		if (instance == null) {
//			synchronized (Singleton.class) {
//				if(instance == null){
//					instance = new Singleton();
//				}
//			}
//		}
//		return instance;
//	}
//	public static void main(String[] args) {
//		Singleton s1 = Singleton.getInstance();
//		Singleton s2 = Singleton.getInstance();
//		System.out.println(s1 == s2);
//	}
//}

// 单例模式 - 饿汉式
public class Singleton{
	private static final Singleton instance = new Singleton();
	private Singleton(){}
	public static Singleton getInstance(){
		return instance;
	}
}

