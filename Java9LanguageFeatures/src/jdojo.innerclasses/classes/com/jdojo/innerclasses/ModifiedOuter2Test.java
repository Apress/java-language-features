// ModifiedOuter2Test.java
package com.jdojo.innerclasses;

public class ModifiedOuter2Test {
    public static void main(String[] args) {
        ModifiedOuter2 out = new ModifiedOuter2();
        ModifiedOuter2.Inner in = out.new Inner();

        // Print the value 
        out.printValue();
        in.printValue();

        // Set a new value 
        out.setValue(828);

        // Print the value 
        out.printValue();
        in.printValue();
    }
}
