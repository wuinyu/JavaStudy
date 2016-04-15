package com.smilingsome.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * <p>004 Java Based Configuration</p>
 *
 */
@Configuration
public class HelloWorldConfig {

   @Bean 
   public HelloSpring helloWorld(){
      return new HelloSpring();
   }
}
