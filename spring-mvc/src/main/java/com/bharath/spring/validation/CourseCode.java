package com.bharath.spring.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by bharathrajakumar on 6/18/17.
 */
//Helper class that contains the business logic for course code validation
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
//Where can this annotation be applied to - Methods or fields
@Target({ElementType.METHOD, ElementType.FIELD})
//Retains this annotation during runtime
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    //Define default course code
    public String value() default "CSS";

    //Define default error message
    public String message() default "must start with CSS";

    //Define defaults groups -- No Idea what this guy does???
    public Class<?>[] groups() default {};

    //Define default payloads - provide details about validation failure like severity level and error code - No Idea??
    public Class<? extends Payload>[] payload() default {};
}
