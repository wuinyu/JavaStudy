/**
 * <p>Title: MainApp.java</p>
 * @Package com.smilingsome.spring
 * @author w
 * @date 2016年4月6日
 * @version V1.0
 */
package com.smilingsome.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * 主测试程序
 * </p>
 *
 */
public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		/*
		 * Bean life cycle
		 */
		HelloSpring objA = (HelloSpring) context.getBean("hellospring");
		objA.setMessage("I'm object A");
		objA.getMessage();

		HelloSpring objB = (HelloSpring) context.getBean("hellospring");
		objB.getMessage();
		/*
		 * Dependency Injection
		 */
		TextEditor te = (TextEditor) context.getBean("textEditor");
		te.spellCheck();
		/*
		 * Injection Collection
		 */
		JavaCollection jc = (JavaCollection) context.getBean("javaCollection");
		jc.getAddressList();
		jc.getAddressSet();
		jc.getAddressMap();
		jc.getAddressProp();
		/*
		 * Spring Required Anotation
		 */
		Student student = (Student) context.getBean("student");
		System.out.println("Name : " + student.getName());
		System.out.println("Age : " + student.getAge());
		/*
		 * AbstractApplicationContext
		 * If you are using Spring's IoC container in a non-web application environment; 
		 * for example, in a rich client desktop environment; you register a shutdown hook with the JVM. 
		 */
		context.registerShutdownHook();
		/*
		 * @Configuration & @Bean Annotations:
		 */
		ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfig.class);

		HelloSpring helloWorld = ctx.getBean(HelloSpring.class);

		helloWorld.setMessage("Hello World!");
		helloWorld.getMessage();
		/*
		 * ConfigurableApplicationContext
		 */
		ConfigurableApplicationContext cac = new ClassPathXmlApplicationContext("beans.xml");
		// Let us raise a start event.
		cac.start();

		// Let us raise a stop event.
		context.stop();
		// Custom Spring Event
		CustomEventPublisher cvp = (CustomEventPublisher) context.getBean("customEventPublisher");
		cvp.publish();
		cvp.publish();
	}

}
