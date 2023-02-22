package com.nestjavatraining.springfoundation;

public class CricketCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		
		return "Do 30 mins of cricket warmup exercise";
	}

	@Override
	public String getDailyFortune() {
		
		return "Try again later..";
	}

}
