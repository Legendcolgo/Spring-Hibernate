package com.bharath.spring;

import com.bharath.spring.validation.CourseCode;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

/**
 * Created by bharathrajakumar on 6/15/17.
 */
public class Customer {
    private String firstName;

    //Add validation rule for this property
    @NotNull(message = "is required")
    @Size(min = 2, message = "should be atleast 1 character long")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than equal to zero")
    @Max(value = 10, message = "must be less than equal to ten")
    private Integer freePasses;


    //Use regex to validate the field and throw the error when it doesnt match the pattern
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "postal code should be either 5 char/digits long")
    private String postalCode;

    //Custom annotation is being used here - the default course code prefix is CSS
    @CourseCode(value = "ECE", message = "must start with ECE")
    private String courseCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
