package com.nestjavatraining.springfoundation;

public class BaseballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		
		return "Do 30 mins of baseball warmup practice";
	}

	@Override
	public String getDailyFortune() {
		
		return "Try again later.";
	}

}
