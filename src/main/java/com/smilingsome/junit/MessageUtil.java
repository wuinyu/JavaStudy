package com.smilingsome.junit;
/**
 *  001 Junit基础用法
 * <p>一个打印消息的消息工具类</p>
 *
 */
public class MessageUtil {

	   private String message;

	   /**
	    * 
	    * 创建一个新的实例 MessageUtil.
	    *
	    * @param message  to be printed
	    */
	   public MessageUtil(String message){
	      this.message = message;
	   }
	      
	   /**
	    * 
	    * <p>prints and return the message</p>
	    * @return message
	    */
	   public String printMessage(){
	      System.out.println(message);
	      return message;
	   }   
	}  
