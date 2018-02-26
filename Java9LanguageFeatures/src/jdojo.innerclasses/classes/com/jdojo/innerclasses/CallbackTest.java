// CallbackTest.java
package com.jdojo.innerclasses;

import java.util.ArrayList;

public class CallbackTest {
    // To hold all registered Callable objects 
    private final ArrayList<Callable> callableList = new ArrayList<>();

    public static void main(String[] args) {
        CallbackTest cbt = new CallbackTest();

        // Create three Callable objects and register them 
        cbt.register(new Callable() {
            @Override
            public void call() {
                System.out.println("Called #1");
            }
        });

        cbt.register(new Callable() {
            @Override
            public void call() {
                System.out.println("Called #2");
            }
        });

        cbt.register(new Callable() {
            @Override
            public void call() {
                System.out.println("Called #3");
            }
        });

        // Callback all the registered Callable objects 
        cbt.callback();
    }

    private void callback() {        
        // Callback all the registered Callable objects 
        for (Callable c: callableList) {            
            c.call();
        }
    }

    public void register(Callable c) {
        this.callableList.add(c);
    }    
}
