package com.smilingsome.spring;

import javax.annotation.Resource;

/**
 * <p>Inner Bean测试类</p>
 * <p>TextEditor类持有一个SpellChecker类</p>
 * <p>在bean文件中, TextEditor的bean会内嵌一个SpellChecker的bean</p>
 * <p>TextEditor类</p>
 */
public class TextEditor {
	   private SpellChecker spellChecker;

	   // a setter method to inject the dependency.
	   /*You can use @Resource annotation on fields or setter methods 
	    * and it works the same as in Java EE 5. 
	    * The @Resource annotation takes a 'name' attribute which 
	    * will be interpreted as the bean name to be injected. 
	    * You can say, it follows by-name autowiring semantics 
	    * as demonstrated in the below example.
	    */
	   @Resource(name= "spellChecker")
	   public void setSpellChecker(SpellChecker spellChecker) {
	      System.out.println("Inside setSpellChecker." );
	      this.spellChecker = spellChecker;
	   }
	   
	   // a getter method to return spellChecker
	   public SpellChecker getSpellChecker() {
	      return spellChecker;
	   }

	   public void spellCheck() {
	      spellChecker.checkSpelling();
	   }
}

/* Injecting Bean Dependencies
 * Java Based Configuration
 * @Configuration  @Bean(initMethod = "init", destroyMethod = "cleanup" ) @Import @Scope("prototype"||"singleton")
 */
/*
@Configuration
public class TextEditorConfig {

   @Bean 
   public TextEditor textEditor(){
      return new TextEditor( spellChecker() );
   }

   @Bean 
   public SpellChecker spellChecker(){
      return new SpellChecker( );
   }
}
*/