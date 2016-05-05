/**
 * <p>Title: HelloSpring.java</p>
 * @Package com.smilingsome.spring
 * <p>Spring HelloWorld程序</p>
 * @author w
 * @date 2016年4月6日
 * @version V1.0
 */
package com.smilingsome.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * <p> 001. HelloSpring Example </p>
 *
 */
public class HelloSpring {
	private String message;

	/**
	 * @return the message
	 */
	public String getMessage() {
		System.out.println("Message: " + message);
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 006 Two important bean lifecycle callback methods.
	 * Initialization callbacks:
	 * org.springframework.beans.factory.InitializingBean interface specifies a single method:
	 * void afterPropertiesSet() throws Exception;
	 */
	@PostConstruct
	public void init() {
		System.out.println("Bean is going through init.");
	}
	/**
	 * 006 Two important bean lifecycle callback methods.
	 * Destruction callbacks
	 * org.springframework.beans.factory.DisposableBean interface specifies a single method:
	 * void destroy() throws Exception;
	 */
	@PreDestroy
	public void destroy() {
		System.out.println("Bean will destroy now.");
	}
}
