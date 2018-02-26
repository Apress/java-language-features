// Test.java
package com.jdojo.prime;

import java.util.List;

public class Test {
   public static void main(String[] args) {
       List<String> providers = PrimeChecker.providerNames();
       System.out.println(providers);
       
       List<PrimeChecker> p2 = PrimeChecker.providers();
       System.out.println(p2);
   } 
}
