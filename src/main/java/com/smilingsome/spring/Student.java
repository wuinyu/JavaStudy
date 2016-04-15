package com.smilingsome.spring;
import org.springframework.beans.factory.annotation.Required;
/**
 * <p>Spring - Annotation Based Configuration</p>
 * <p>Starting from Spring 2.5 it became possible to configure the dependency injection using annotations. </p>
 * <p>Annotation injection is performed before XML injection,</p>
 * <p>Spring提供的Annotation有 @Required @Autowired @Qualifier</p>
 * <p>JSR-250 Annotations @Resource @PostConstruct @PreDestroy</p>
 * <p>Student类演示 @Required Annotation的使用</p>
 * 
 * <p>The @Autowired annotation can apply to bean property setter methods, non-setter methods, constructor and properties.</p>
 * <p>@Autowired on Setter Methods</p>
 * <p>@Autowired on Properties</p>
 * <p>@Autowired on Constructors</p>
 * <p>@Autowired with (required=false) option</p>
 * 
 * <p>he @Qualifier annotation along with @Autowired can be used to remove the confusion by specifiying which exact bean will be wired.</p>
 * 
 */
public class Student {
   private Integer age;
   private String name;

   @Required
   public void setAge(Integer age) {
      this.age = age;
   }
   public Integer getAge() {
      return age;
   }

   @Required
   public void setName(String name) {
      this.name = name;
   }
   public String getName() {
      return name;
   }
}