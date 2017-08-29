package com.bharath.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by bharathrajakumar on 6/18/17.
 */
public class TestJDBC {
    public static void main(String args[]) {
        String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
        String user = "hbstudent";
        String password = "Hb@110988";
        try {
            System.out.println("Connecting to local database " + jdbcURL);

            Connection connection = DriverManager.getConnection(jdbcURL, user, password);

            System.out.println("Connection successful !!! ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
