package com.nestjavatraining.springfoundation;

public class HockeyCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		
		return "Do 30 mins of hockey warm-up practice";
	}
	
	@Override
	public String getDailyFortune() {
		
		return "Try again next time...";
	}

}
