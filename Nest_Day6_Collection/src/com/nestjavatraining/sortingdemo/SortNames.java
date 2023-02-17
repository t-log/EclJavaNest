package com.nestjavatraining.sortingdemo;

import java.util.ArrayList;
import java.util.Collections;

public class SortNames {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("Akhil");
        list.add("Varun");
        list.add("Rahul");
        list.add("Amal");
        list.add("Jithin");
 
        System.out.println("Before Sorting : " + list);
 
        Collections.sort(list);
 
        System.out.println("After Sorting : " + list);

	}

}
