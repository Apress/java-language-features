// LambdaUtil2Test.java
package com.jdojo.lambda;

public class LambdaUtil2Test {
    public static void main(String[] args) {
        LambdaUtil2 util = new LambdaUtil2();

        // Calls the testAdder() method         
        util.test((double x, double y) -> x + y);

        // Calls the testJoiner() method
        util.test((String x, String y) -> x + y);

        // Calls the testJoiner() method. The Joiner will add a space between the two strings
        util.test((Joiner) (x, y) -> x + " " + y);

        // Calls the testJoiner() method. The Joiner will reverse the strings and join 
        // resulting strings in reverse order adding a comma in between
        util.test((Joiner) (x, y) -> {
            StringBuilder sbx = new StringBuilder(x);
            StringBuilder sby = new StringBuilder(y);
            
            sby.reverse().append(",").append(sbx.reverse());
            
            return sby.toString();
        });
    }
}
