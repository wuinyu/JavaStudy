package com.smilingsome.spring;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.BeansException;
/**
 * 005 Spring - Bean Post Processors
 * <p> InitHelloWorld类继承BeanPostProcessor需要实现两个方法</p>
 * <p> postProcessBeforeInitialization方法 - 在类初始化之前执行</p>
 *  <p> postProcessAfterInitialization方法 -  在类初始化之后执行</p>
 */
public class InitHelloWorld implements BeanPostProcessor {
 
   public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
      System.out.println("BeforeInitialization : " + beanName);
      return bean;  // you can return any other object as well
   }

   public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
      System.out.println("AfterInitialization : " + beanName);
      return bean;  // you can return any other object as well
   }

}
