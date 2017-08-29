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
public class CreateInstructorDemo {
    private static Logger logger = Logger.getLogger(CreateInstructorDemo.class.getName());

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

            //Create the objects
            Instructor tempInstructor = new Instructor("Jane", "Roger", "jane.roger@gmail.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/janeRoger", "Artist");

            //Associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            //Start a transaction
            session.beginTransaction();

            //Save the instructor. This will also save the instructorDetail object.
            logger.info("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);

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
