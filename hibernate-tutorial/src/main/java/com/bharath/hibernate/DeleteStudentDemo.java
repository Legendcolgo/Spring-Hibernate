package com.bharath.hibernate;

import com.bharath.hibernate.com.bharath.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by bharathrajakumar on 6/18/17.
 */
@SuppressWarnings("JpaQlInspection")
public class DeleteStudentDemo {
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

            int studentId = 2;

            //Retrieve a student based on primary key
            System.out.println("Getting a student based on id: " + studentId);

            Student student = session.get(Student.class, studentId);

            System.out.println("Retrieved student record based on the give id");
            System.out.println(student);

            //Delete the student
            System.out.println("Deleting the student for the given id");

            //You can delete an object this way as as well
            session.delete(student);

            session.createQuery("DELETE FROM Student where id = 4").executeUpdate();

            //Commit the transaction
            session.getTransaction().commit();
            System.out.println("Done !!!");


        } catch (Exception e) {

        } finally {
            sessionFactory.close();
        }
    }
}
