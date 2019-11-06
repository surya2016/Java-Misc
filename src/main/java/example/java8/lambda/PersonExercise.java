package example.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import example.java8.Person;

public class PersonExercise {

	@FunctionalInterface
	interface filter
	{
		void filterByLastNameStartingwithC(List<Person> per, String c);
	}
	
	public static void main(String args[])
	{
		List<Person> p = Arrays.asList(
				new Person("Charles","Dicken",23,"Dancing"),
				new Person("Lewis","Carrol",67,"Writing"),
				new Person("Thomas","Carlyl",53,"Playing footbalg"),
				new Person("Charollete","Bryn",23,"Painting"),
				new Person("Marthew","Arnold",23,"Playing music"),
				new Person("Tom","Christian",23,"Dancing")

				);
		
		//classic comparator for sorting by last name
		/*Comparator<Person> cp = new Comparator<Person>() {
			
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastname().compareTo(o2.getLastname());
			}
		};*/
		
		//Using lambda for comparator
		
		Comparator<Person> byLastname = (o1,o2)-> o1.getLastname().compareTo(o2.getLastname());
		
		//sorting by last name
		p.sort(byLastname);
		
		System.out.println("Sorted by Last name");
		//classic way
		for(Person p1 : p)
		{
			System.out.println(p1.toString());
		}
		
		
		//lambda way
		
		//Person p2 = people -> System.out.println(people.toString);
		
		//whose last name start with c
		
		filter f = (per,c)-> {
			
			for(Person p3:per)
				if(p3.getLastname().startsWith(c))
					System.out.println(p3.toString());
		};
		
		System.out.println("Starting wih Char");
		f.filterByLastNameStartingwithC(p,"D");
		
		System.out.println("Starting wih Char");
		
		filter f2 = (per,c)-> {
			
			for(Person p3:per)
				if(p3.getFirstname().startsWith(c))
					System.out.println(p3.toString());
		}; 
		
		f2.filterByLastNameStartingwithC(p, "C");
		
		
	}
}
