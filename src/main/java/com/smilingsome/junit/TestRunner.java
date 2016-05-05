package com.smilingsome.junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
/**
 * 001 Junit 入门
 * 第一个Junit runner类 TestRunner
 *
 */
public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestJunit.class);
		for (Failure failure : result.getFailures()){
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
		
	}

}
