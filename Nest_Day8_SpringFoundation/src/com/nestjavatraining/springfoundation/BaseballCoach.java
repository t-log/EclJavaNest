package com.nestjavatraining.springfoundation;

public class BaseballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		
		return "Do 30 mins of warmup practice";
	}

	@Override
	public String getDailyFortune() {
		
		return "Try again later.";
	}

}
