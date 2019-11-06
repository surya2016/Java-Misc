package example.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import example.java8.Person;

public class PersonEerciseImprovedVersion {

	/*
	 * this is an extra thing we have to write, but we can avoid it by using java.util.function which has Predicate functional interface
	 * Predicate - in built function given by Java 8 which can be used for our lambda expression as it has only one abstract method
	 * ref class : PersonExUsingUtilFunction
	 */
	@FunctionalInterface  
	interface Condition
	{
		boolean condn(Person p);
	}
	
	static void printAll(List<Person> p)
	{
		for(Person per : p)
			System.out.println(per.toString());
	}
	
	static void printConditionally(List<Person> p , Condition c)
	{
		for(Person per:p)
			if(c.condn(per))
				System.out.println(per.toString());
	}
	
	public static void main(String  args[])
	{
		List<Person> p = Arrays.asList(
				new Person("Charles","Dicken",23,"Dancing"),
				new Person("Lewis","Carrol",67,"Writing"),
				new Person("Thomas","Carlyl",53,"Playing footbalg"),
				new Person("Charollete","Bryn",23,"Painting"),
				new Person("Marthew","Arnold",23,"Playing music"),
				new Person("Tom","Christian",23,"Dancing")

				);
		
		//Sorting corresponding to last name
		
		Comparator<Person> byLastName = (o1,o2)-> o1.getLastname().compareTo(o2.getLastname());
		
		p.sort(byLastName);
		
		//printAll(p);
		printConditionally(p, x -> true);
	
		Condition c = x -> x.getLastname().startsWith("C");
		
		printConditionally(p, c);
		
		
	}
}
