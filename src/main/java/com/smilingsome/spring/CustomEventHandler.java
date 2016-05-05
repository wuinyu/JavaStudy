package com.smilingsome.spring;

import org.springframework.context.ApplicationListener;
/**
 * 
 * <p> 003 Custom Events in Spring </p>
 *
 */
public class CustomEventHandler 
   implements ApplicationListener<CustomEvent>{

   public void onApplicationEvent(CustomEvent event) {
      System.out.println(event.toString());
   }

}