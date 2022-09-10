package com.promineotech.sorting.model;

public class Person {
	
	private String firstName;
	
	public Person(String name) {
		this.firstName = name;
	}
	
	@Override
	public String toString() {
		return firstName;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	public static int comparePeople(Person p1, Person p2) {
		return p1.firstName.compareTo(p2.firstName);
	}
}
