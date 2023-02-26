package com.nestjavatraining.springfoundation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoachApp {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Coach theCoach;

		//load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve bean from spring container
		System.out.print("1.Baseball, 2.Cricket, 3.Hockey");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice = Integer.parseInt(br.readLine());
		switch(choice) {
		case 1: theCoach = context.getBean("baseballCoach",Coach.class);
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		//close the context
		context.close();
		break;
		case 2: CricketCoach cCoach = context.getBean("cricketCoach",CricketCoach.class);
		//call methods on the bean
		System.out.println(cCoach.getDailyWorkout());
		System.out.println(cCoach.getDailyFortune());
//		System.out.println(cCoach.getEmailaddress());
//		System.out.println(cCoach.getTeamname());
		//close the context1
		context.close();
		break;
		case 3: theCoach = context.getBean("hockeyCoach",Coach.class);
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		//close the context
		context.close();
		break;
		
		
		

	}

}
	
}
