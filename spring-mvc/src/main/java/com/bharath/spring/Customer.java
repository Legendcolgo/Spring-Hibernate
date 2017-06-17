package com.bharath.spring;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by bharathrajakumar on 6/15/17.
 */
public class Customer {
    private String firstName;

    //Add validation rule for this property
    @NotNull(message = "is required")
    @Size(min = 1, message = "should be atleast 1 character long")
    private String lastName;

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
}
