package com.nestjavatraining.objectsorting;

public class Customer implements Comparable<Customer> {
	
	private int age;
	private String name;
	
	public Customer(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Customer o) {
		
		return this.getName().compareTo(o.getName());
	}

}
