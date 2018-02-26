// Description.java
package com.jdojo.annotation;

public @interface Description {
    Name name();
    Version version();
    String comments() default "";
}
