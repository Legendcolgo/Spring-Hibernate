package com.bharath.hibernate;

import com.bharath.hibernate.com.bharath.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by bharathrajakumar on 6/18/17.
 */
public class CreateStudentDemo {
    public static void main(String args[]) {
        //Create session factory
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        //Create session
        Session session = sessionFactory.getCurrentSession();

        try {
            //Use the session object to save Java object to the database

            //Create the student object
            System.out.println("Creating a new student object");
            Student student = new Student("Barry", "Von", "barry.von@foobar.com");

            //Start a transaction
            session.beginTransaction();

            //Save student object
            System.out.println("Saving the student object");
            session.save(student);

            //Commit the transaction
            session.getTransaction().commit();
            System.out.println("Done !!!");

        } catch (Exception e) {

        } finally {
            sessionFactory.close();
        }
    }
}
