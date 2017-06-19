package com.bharath.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by bharathrajakumar on 6/18/17.
 */
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    //The course prefix that we need to validate against
    private String coursePrefix;

    public void initialize(CourseCode courseCode) {
        //This will assign the value argument of the custom annotation to coursePrefix
        coursePrefix = courseCode.value();
    }

    //code - The HTML form data entered by the user
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {

        //Business Logic - throw false for "null" value or for an invalid course prefix
        boolean result;

        if(code != null) {
            result = code.startsWith(coursePrefix);
        } else {
            result = true;
        }

        return result;
    }
}
