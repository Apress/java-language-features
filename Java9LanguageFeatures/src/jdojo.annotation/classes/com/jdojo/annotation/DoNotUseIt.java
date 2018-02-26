// DoNotUseIt.java
package com.jdojo.annotation;

import java.lang.annotation.Annotation;

public class DoNotUseIt implements Version {
    // Implemented method from the Version annotation type
    @Override
    public int major() {
        return 0;
    }

    // Implemented method from the Version annotation type
    @Override
    public int minor() {
        return 0;
    }

    // Implemented method from the Annotation annotation type, 
    // which is the supertype of the Version annotation type
    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
