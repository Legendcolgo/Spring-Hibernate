package com.bharath.hibernate;

import com.bharath.hibernate.com.bharath.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by bharathrajakumar on 6/18/17.
 */
public class QueryStudentDemo {
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

            //Query for all student database
            List<Student> studentList = session.createQuery("from Student").getResultList();

            displayStudents(studentList);

            //Query for all students whose lastname is "Lopez"
            //Note - we need to use the java properties or field names instead of the database column name
            System.out.println("Students with last name as lopez");
            studentList = session.createQuery("from Student s where s.lastName='lopez'").getResultList();

            displayStudents(studentList);


            //Query for all students with lastname is "Moldovan" OR firstname is "Kimi"
            System.out.println("Students with lastname is moldovan or firstname is kimi");
            studentList = session.createQuery("from Student s where s.lastName='moldovan' OR s.firstName='kimi'").getResultList();

            displayStudents(studentList);

            //Query for all students whose email address ends with "foobar.com"
            System.out.println("Students whose email address ends with fooboar.com");
            studentList = session.createQuery("from Student s where s.emailAddress LIKE '%foobar.com'").getResultList();

            displayStudents(studentList);

            //Commit the transaction
            session.getTransaction().commit();
            System.out.println("Done !!!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }

    private static void displayStudents(List<Student> studentList) {
        //Output the student to the console log
        System.out.println();
        for(Student student : studentList) {
            System.out.println(student);
        }
        System.out.println();
    }
}


