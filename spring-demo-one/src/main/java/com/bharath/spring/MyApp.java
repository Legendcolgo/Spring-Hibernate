package com.bharath.spring;

/**
 * Hello world!
 *
 */
public class MyApp
{
    public static void main( String[] args )
    {
        //Create the BasballCoach object
        Coach coachOne = new BaseballCoach();
        Coach coachTwo = new TrackCoach();
        //Use the Object
        System.out.println(coachOne.getDailyWorkout());
        System.out.println(coachTwo.getDailyWorkout());
    }
}
