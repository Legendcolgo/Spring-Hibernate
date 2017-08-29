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
public class DeleteDemo {
    private static Logger logger = Logger.getLogger(DeleteDemo.class.getName());

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

            //Get the instructor by id
            int id = 2;
            logger.info("Searching Instructor whose id is : " + id);

            Instructor tempInstructor = session.get(Instructor.class, id);

            if(tempInstructor != null) {
                logger.info("Found Instructor for the given id : " + tempInstructor);

                logger.info("Deleting the instructor from the database");

                //This will also delete the Instructor detail associated for this Instructor
                session.delete(tempInstructor);
            }

            //Commit the transaction
            session.getTransaction().commit();
            logger.info("Done !!!");

        } catch (Exception e) {

        } finally {
            sessionFactory.close();
        }
    }
}
