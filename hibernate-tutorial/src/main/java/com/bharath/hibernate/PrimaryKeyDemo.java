package com.bharath.hibernate;

import com.bharath.hibernate.com.bharath.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by bharathrajakumar on 6/24/17.
 */
public class PrimaryKeyDemo {
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

            //Create mulitple student objects
            System.out.println("Creating multiple student objects");

            Student studentOne = new Student("Diego", "Lopez", "diego.lopez@foobar.com");
            Student studentTwo = new Student("Kimi", "Raikkonen", "kimmi.raikkonen@foobar.com");
            Student studentThree = new Student("Dan", "Moldovan", "dan.moldovan@foobar.com");

            //Start a transaction
            session.beginTransaction();

            //Save student object
            System.out.println("Saving the student objects");
            session.save(studentOne);
            session.save(studentTwo);
            session.save(studentThree);

            //Commit the transaction
            session.getTransaction().commit();
            System.out.println("Done !!!");

        } catch (Exception e) {

        } finally {
            sessionFactory.close();
        }
    }
}
