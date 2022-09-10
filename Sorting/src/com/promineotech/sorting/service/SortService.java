package com.promineotech.sorting.service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import com.promineotech.optionals.dao.OptionalDao;
import com.promineotech.sorting.dao.SortDao;
import com.promineotech.sorting.model.Person;

public class SortService {
	private SortDao sortDao = new SortDao();
	
	public List<Person> getPeople(SortType type){
		List<Person> people = sortDao.getPeople();
		Comparator<Person> comp = null;
		
		switch(type) {
		case ANONYMOUS_INNER_CLASS:
			comp = new Comparator<Person>() {

				@Override
				public int compare(Person o1, Person o2) {
					// TODO Auto-generated method stub
					return Person.comparePeople(o1,o2);
				}
				
			};
			break;
		case LAMBDA:
			comp = (p1,p2) -> Person.comparePeople(p1,p2);
			break;
		case METHOD_REFERENCE:
			comp = Person::comparePeople;
			break;
		case NORMAL_CLASS:
			comp = new MySort();
			break;
			
		default:
			throw new RuntimeException("Unhandled sort type" + type);
		}
		
		people.sort(comp);
		return people;
	}
	
	static class MySort implements Comparator<Person> {
		@Override
		public int compare(Person p1, Person p2) {
			return Person.comparePeople(p1,p2);
		}
	}
	
	/**
	 * 
	 * @param search
	 * @return
	 */
	public String find(String search) {
		return sortDao.find(search).orElseThrow(() -> new NoSuchElementException("It appears that " + search + " is missing."));
	}
}
