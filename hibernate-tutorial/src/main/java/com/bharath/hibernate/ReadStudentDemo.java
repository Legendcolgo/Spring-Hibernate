package com.bharath.hibernate;

import com.bharath.hibernate.com.bharath.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by bharathrajakumar on 6/18/17.
 */
public class ReadStudentDemo {
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
            Student tempStudent = new Student("Saltwater", "Taffy", "saltwater.taffy@foobar.com");

            //Start a transaction
            session.beginTransaction();

            //Save student object
            System.out.println("Saving the student object");
            System.out.println(tempStudent);
            session.save(tempStudent);

            //Find out the primary key of the student object that got saved into the database
            System.out.println("Saved the student object");
            System.out.println("id : " + tempStudent.getId());

            //Retrieve the student based on the transaction
            System.out.println("Getting student with id : " + tempStudent.getId());

            Student student = session.get(Student.class, tempStudent.getId());

            System.out.println("Reading student record : ");
            System.out.println(student);


            //Commit the transaction
            session.getTransaction().commit();
            System.out.println("Done !!!");

        } catch (Exception e) {

        } finally {
            sessionFactory.close();
        }
    }
}
