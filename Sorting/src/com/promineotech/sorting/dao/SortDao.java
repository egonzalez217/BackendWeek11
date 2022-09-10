package com.promineotech.sorting.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.promineotech.sorting.model.Person;

public class SortDao {
	List<Person> people = new ArrayList<>(List.of(
			new Person("Mary"),
			new Person("Arif"),
			new Person("Huan"),
			new Person("Uri"),
			new Person("Magy"),
			new Person("Moss"),
			new Person("Ebbe"),
			new Person("Tse"),
			new Person("Gino"),
			new Person("Udi")
			));
	
	public List<Person> getPeople() {
		return people;
	}

	public Optional<String> find(String search){
		
		if("missing".equals(search)) {
			return Optional.empty();
		}
		return Optional.of(search);
	}
}
