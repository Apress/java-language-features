// WrapperUtilTest.java
package com.jdojo.generics;

public class WrapperUtilTest {
   public static void main(String[] args) {
       Wrapper<Integer> n1 = new Wrapper<>(10);
       Wrapper<Double> n2 = new Wrapper<>(15.75);
       
       // Print the details
       WrapperUtil.printDetails(n1);
       WrapperUtil.printDetails(n2);
       
       // Add numeric values in two WrapperUtil
       double sum = WrapperUtil.sum(n1, n2);
       System.out.println("sum: " + sum);
       
       // Copy the value of a Wrapper<Double> to a Wrapper<Number>
       Wrapper<Number> holder = new Wrapper<>(45);
       System.out.println("Original holder: " + holder.get());
       WrapperUtil.copy(n2, holder);
       System.out.println("After copy holder: " + holder.get());
   } 
}
