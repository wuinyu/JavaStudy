package com.smilingsome.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
/**
 * 
 * <p>002 Event Handling in Spring</p>
 * <p>ContextRefreshedEvent ContextStartedEvent ContextStoppedEvent ContextClosedEvent RequestHandledEvent</p>
 * <p>o listen a context event, 
 * a bean should implement the ApplicationListener interface 
 * which has just one method onApplicationEvent()</p>
 *
 */
public class CStartEventHandler implements ApplicationListener<ContextStartedEvent> {

	@Override
	public void onApplicationEvent(ContextStartedEvent event) {

		System.out.println("ContextStartedEvent Received");
	}

}
