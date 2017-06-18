package com.bharath.spring;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by bharathrajakumar on 6/15/17.
 */
public class Customer {
    private String firstName;

    //Add validation rule for this property
    @NotNull(message = "is required")
    @Size(min = 2, message = "should be atleast 1 character long")
    private String lastName;

    @NotNull(message = "cannot be empty")
    @Min(value = 0, message = "must be greater than equal to zero")
    @Max(value = 10, message = "must be less than equal to ten")
    private int freePasses;

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

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }
}
