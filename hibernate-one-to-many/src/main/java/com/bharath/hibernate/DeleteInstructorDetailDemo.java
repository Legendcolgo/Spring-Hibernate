package com.bharath.hibernate;

import com.bharath.hibernate.entity.Instructor;
import com.bharath.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Logger;

/**
 * Created by bharathrajakumar on 6/18/17.
 */
public class DeleteInstructorDetailDemo {
    private static Logger logger = Logger.getLogger(DeleteInstructorDetailDemo.class.getName());

    public static void main(String args[]) {
        //Create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        //Create session
        Session session = sessionFactory.getCurrentSession();

        try {
            //Use the session object to save Java object to the database

            //Start a transaction
            session.beginTransaction();

            //Get instructor detail
            int id = 5;

            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, id);

            //Log the instructor detail
            logger.info("Instructor detail : " + tempInstructorDetail);

            //Get the instructor associated with the instructor detail object
            logger.info("Instructor : " + tempInstructorDetail.getInstructor());

            //Delete the instructor detail - This will perform a cascade delete on the instructor table
            logger.info("Deleting instructor detail : " + tempInstructorDetail);

            //Remove the bi-directional reference between the two tables before you delete the instructor detail
            //This will delete the instructor detail and keep the instructor entry in the database
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(tempInstructorDetail);

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
