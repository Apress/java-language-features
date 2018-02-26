// Box.java
package com.jdojo.annotation;

/**
 * This class is used to demonstrate how to deprecate APIs.
 */
public class Box {
    /**
     * Not deprecated
     */
    public static void notDeprecated() {
        System.out.println("notDeprecated...");
    }

    /**
     * Deprecated ordinarily.
     *
     * @deprecated Do not use it.
     */
    @Deprecated(since = "2")
    public static void deprecatedOrdinarily() {
        System.out.println("deprecatedOrdinarily...");
    }

    /**
     * Deprecated terminally.
     *
     * @deprecated It will be removed in a future release. Migrate your code now.
     */
    @Deprecated(since = "2", forRemoval = true)
    public static void deprecatedTerminally() {
        System.out.println("deprecatedTerminally...");
    }
}
