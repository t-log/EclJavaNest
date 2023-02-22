package com.nestjavatraining.comparator;

import java.util.Comparator;

import com.nestjavatraining.objectsorting.Customer;

public class CustomerAgeComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		
		return o1.getAge() - o2.getAge();
	}

}
