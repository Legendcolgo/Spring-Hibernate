package com.bharath.spring;

import java.util.LinkedHashMap;

/**
 * Created by bharathrajakumar on 6/14/17.
 */
public class Student {

    private String firstName;

    private String lastName;

    private String country;

    private LinkedHashMap<String, String> countryOptions;

    private String favoriteLanguage;

    private String[] favoriteOperatingSystems;

    public Student() {
        //Populate the countryOptions while loading the student-form page

        //NOTE: the properties file reference from the servlet xml file if you would
        //like to populate the drop down list from the java class below

//        countryOptions = new LinkedHashMap<String, String>();
//
//        countryOptions.put("Bra","Brazil");
//        countryOptions.put("Fra","France");
//        countryOptions.put("Ger","Germany");
//        countryOptions.put("Ind","India");
//        countryOptions.put("Usa","United States of America");
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String[] getFavoriteOperatingSystems() {
        return favoriteOperatingSystems;
    }

    public void setFavoriteOperatingSystems(String[] favoriteOperatingSystems) {
        this.favoriteOperatingSystems = favoriteOperatingSystems;
    }
}
