package example.java8.lambda;

import java.util.Arrays;
import java.util.List;

import example.java8.Person;

public class LambdaCollectionIteration {

	public static void main(String[] args) {
		List<Person> p = Arrays.asList(
				new Person("Charles","Dicken",23,"Dancing"),
				new Person("Lewis","Carrol",67,"Writing"),
				new Person("Thomas","Carlyl",53,"Playing footbalg"),
				new Person("Charollete","Bryn",23,"Painting"),
				new Person("Marthew","Arnold",23,"Playing music"),
				new Person("Tom","Christian",23,"Dancing")

				);
		
		//Iteration is done by the compiler in an asynchronous way
		p.forEach(System.out::println);

	}

}
