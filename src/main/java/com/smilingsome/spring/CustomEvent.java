package com.smilingsome.spring;
import org.springframework.context.ApplicationEvent;
/**
 * 
 * <p>003 Custom Events in Spring</p>
 *
 */
public class CustomEvent extends ApplicationEvent{
   
   public CustomEvent(Object source) {
      super(source);
   }

   public String toString(){
      return "My Custom Event";
   }
}