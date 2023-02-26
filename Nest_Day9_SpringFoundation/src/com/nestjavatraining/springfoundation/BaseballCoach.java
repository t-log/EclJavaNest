package com.nestjavatraining.springfoundation;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService theFortuneService) {
		System.out.println("Inside constructor BaseballCoach()");
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Do 30 mins of baseball warmup practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
