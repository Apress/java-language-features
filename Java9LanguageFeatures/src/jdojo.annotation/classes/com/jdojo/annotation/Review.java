// Review.java
package com.jdojo.annotation;

public @interface Review {
    ReviewStatus status() default ReviewStatus.PENDING;
    String comments() default "";
    
    // ReviewStatus enum is a member of the Review annotation type
    public enum ReviewStatus {PENDING, FAILED, PASSED, PASSEDWITHCHANGES};
}
