// CatchAllThreadExceptionHandler.java
package com.jdojo.threads;

public class CatchAllThreadExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Caught Exception from Thread: " + t.getName());
    }
}
