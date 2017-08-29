package com.bharath.hibernate;

import com.bharath.hibernate.entity.Course;
import com.bharath.hibernate.entity.Instructor;
import com.bharath.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Logger;

/**
 * Created by bharathrajakumar on 6/18/17.
 */
public class CreateCoursesDemo {
    private static Logger logger = Logger.getLogger(CreateCoursesDemo.class.getName());

    public static void main(String args[]) {
        //Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        //Create session
        Session session = sessionFactory.getCurrentSession();

        try {
            //Use the session object to save Java object to the database

            //Start a transaction
            session.beginTransaction();

            //Get the instructor from the database
            int id=1;
            Instructor tempInstructor = session.get(Instructor.class, id);

            //Create some courses
            Course course1 = new Course("Guitar");
            Course course2 = new Course("Surfing");

            //Associate the courses with the instructor
            tempInstructor.add(course1);
            tempInstructor.add(course2);

            //Save the courses back to the database
            //NOTE: We dont have to save the instructor object because we have a cascading add operation happening here
            session.save(course1);
            session.save(course2);

            //Commit the transaction
            session.getTransaction().commit();
            logger.info("Done !!!");

        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
