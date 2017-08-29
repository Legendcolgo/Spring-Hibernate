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
public class GetInstructorCoursesDemo {
    private static Logger logger = Logger.getLogger(GetInstructorCoursesDemo.class.getName());

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

            logger.info("Instructor : " + tempInstructor);

            //Get the course for the given instructor
            logger.info("Courses : " + tempInstructor.getCourseList());

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
