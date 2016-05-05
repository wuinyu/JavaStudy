package com.smilingsome.spring;
import java.util.*;
/**
 * <p>Injection Collection测试</p>
 * <p>Spring提供 <list> <set> <map> <props>四类元素</p>
 *
 * <p>Spring - Beans Auto-Wiring</p>
 * <p>Spring提供 no, byName, byType, constructor, autodetect</p>
 * <p>auto-wiring缺点: Overriding possibility, Primitive data types, Confusing nature</p>
 * <p>建议最好不用auto-wiring, 使用explicit wiring</p>
 * 
 */
public class JavaCollection {
   List addressList;
   Set  addressSet;
   Map  addressMap;
   Properties addressProp;

   // a setter method to set List
   public void setAddressList(List addressList) {
      this.addressList = addressList;
   }
   
   // prints and returns all the elements of the list.
   public List getAddressList() {
      System.out.println("List Elements :"  + addressList);
      return addressList;
   }

   // a setter method to set Set
   public void setAddressSet(Set addressSet) {
      this.addressSet = addressSet;
   }

   // prints and returns all the elements of the Set.
   public Set getAddressSet() {
      System.out.println("Set Elements :"  + addressSet);
      return addressSet;
   }

   // a setter method to set Map
   public void setAddressMap(Map addressMap) {
      this.addressMap = addressMap;
   }
   
   // prints and returns all the elements of the Map.
   public Map getAddressMap() {
      System.out.println("Map Elements :"  + addressMap);
      return addressMap;
   }

   // a setter method to set Property
   public void setAddressProp(Properties addressProp) {
      this.addressProp = addressProp;
   }
   
   // prints and returns all the elements of the Property.
   public Properties getAddressProp() {
      System.out.println("Property Elements :"  + addressProp);
      return addressProp;
   }
}
