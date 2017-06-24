package com.bharath.hibernate;

import com.bharath.hibernate.com.bharath.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by bharathrajakumar on 6/18/17.
 */
public class UpdateStudentDemo {
    public static void main(String args[]) {
        //Create session factory
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        //Create session
        Session session = sessionFactory.getCurrentSession();

        try {
            //Start a transaction
            session.beginTransaction();

            int studentId = 3;

            //Retrieve a student based on primary key
            System.out.println("Getting a student based on id: " + studentId);

            Student student = session.get(Student.class, studentId);

            System.out.println("Retrieved student record based on the give id");
            System.out.println(student);

            //Update the student record
            System.out.println("Updating student record");
            student.setFirstName("Scooby");
            student.setLastName("Dooby Doo");

            //Commit the transaction
            session.getTransaction().commit();
            System.out.println("Done !!!");

            //Start a new transaction for bulk update
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            //Update the email address for all students
            System.out.println("Updating email address for all students");

            session.createQuery("UPDATE Student SET emailAddress='foobar@gmail.com'").executeUpdate();

            //Commit the transaction
            session.getTransaction().commit();
            System.out.println("Done !!!");


        } catch (Exception e) {

        } finally {
            sessionFactory.close();
        }
    }
}
