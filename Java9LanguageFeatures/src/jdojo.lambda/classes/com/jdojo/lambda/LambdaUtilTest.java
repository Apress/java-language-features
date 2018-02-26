// LambdaUtilTest.java
package com.jdojo.lambda;

public class LambdaUtilTest {
    public static void main(String[] args)  {
        LambdaUtil util = new LambdaUtil();
        
        // Call the testAdder() method 
        util.testAdder((x, y) -> x + y);
        
        // Call the testJoiner() method
        util.testJoiner((x, y) -> x + y);
        
        // Call the testJoiner() method. The Joiner will add a space between the two strings
        util.testJoiner((x, y) -> x + " " + y);
        
        // Call the testJoiner() method. The Joiner will reverse the strings and join resulting 
        // strings in reverse order adding a comma in between
        util.testJoiner((x, y) -> {            
            StringBuilder sbx = new StringBuilder(x);
            StringBuilder sby = new StringBuilder(y);

            sby.reverse().append(",").append(sbx.reverse());

            return sby.toString();
        });
    }
}
