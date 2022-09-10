package com.promineotech.sorting;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import com.promineotech.sorting.model.Person;
import com.promineotech.sorting.service.SortService;
import com.promineotech.sorting.service.SortType;
public class MySort {
	private Scanner scanner = new Scanner(System.in);
	private SortService sortService = new SortService();
	public static void main(String[] args) {
		new MySort().run();
	}
	private void run() {
		List<Person> people = sortService.getPeople(SortType.METHOD_REFERENCE);
		
		print(people, SortType.METHOD_REFERENCE);
		
		String names = people.stream().map(Person::getFirstName).collect(Collectors.joining(","));
		System.out.println("The names " + names + " will be written to names.csv");
		try {
			FileWriter writer = new FileWriter("names.csv");
			writer.write(names);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		boolean done = false;
		System.out.println("Enter the previosly printed names to check if they exist or not");
		while(!done) {
			System.out.print("Enter something: ");
			String search = scanner.nextLine();
			
			if(search.isEmpty()) {
				done = true;
			}
			else {
				try {
					String found = sortService.find(search);
					System.out.println("I found " + found + "!");
				}			
				catch(NoSuchElementException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	private void print(List<Person> people, SortType type) {
		switch(type) {
		case LAMBDA:
			people.forEach(person -> System.out.println(person.getFirstName()));
			break;
		case METHOD_REFERENCE:
			people.forEach(System.out::println);
				break;
		case ANONYMOUS_INNER_CLASS:
		case NORMAL_CLASS:
			for(Person person : people) {
				System.out.println(person.getFirstName());
			}
			break;	
		}	
	}
}
