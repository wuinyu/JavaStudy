package com.smilingsome.spring;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * 
 * <p> 003 Custom Events in Spring </p>
 *
 */
public class CustomEventPublisher implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher publisher;

	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	public void publish() {
		CustomEvent ce = new CustomEvent(this);
		publisher.publishEvent(ce);
	}

}