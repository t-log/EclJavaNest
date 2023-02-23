package com.nestjavatraining.springfoundation;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoachApp {

	public static void main(String[] args) {
		
		Coach theCoach;
		
		//load the spring configuration file 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		boolean flag = true;
		do {
			System.out.println("-------Choose a Coach--------- \n 1.Baseball \n 2.Hockey \n"
					+ " 3.Cricket \n 4.Exit");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				theCoach = context.getBean("baseballCoach",Coach.class);
				//call methods on the bean
				System.out.println(theCoach.getDailyWorkout());
				break;
			case 2:
				theCoach = context.getBean("hockeyCoach",Coach.class);
				//call methods on the bean
				System.out.println(theCoach.getDailyWorkout());
				break;
			case 3:
				theCoach = context.getBean("cricketCoach",Coach.class);
				//call methods on the bean
				System.out.println(theCoach.getDailyWorkout());
				break;
			case 4:
				flag = false;
				//close the context
				context.close();
				break;
			default:
				System.out.println("Invalid Option!");
			}
		
		}
		while(flag);
		
		
		

	}

}
