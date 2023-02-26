package com.nestjavatraining.springfoundation;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside setter method setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Do 30 mins of cricket warmup exercise";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
