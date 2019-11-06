package example.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import example.java8.Person;

public class CollectionStream {

	public static void main(String[] args) {
		List<Person> p = Arrays.asList(
				new Person("Charles","Dicken",23,"Dancing"),
				new Person("Lewis","Carrol",67,"Writing"),
				new Person("Thomas","Carlyl",53,"Playing footbalg"),
				new Person("Charollete","Bryn",23,"Painting"),
				new Person("Marthew","Arnold",23,"Playing music"),
				new Person("Tom","Christian",23,"Dancing")

				);
		
		//print first name of people whose last name start with C
		
		p.stream()
			.filter(x->x.getLastname().startsWith("C"))
			.forEach(x->System.out.println(x.getFirstname()));
		
		System.out.println("Getting first name starting with T!!!");
		p.stream().map(Person::getFirstname).filter(x-> x.startsWith("T")).forEach(System.out::println);
		
		System.out.println("Printing ages of all persons");
		p.stream().mapToInt(Person::getAge).forEach(System.out::println);
		
		List<String> hobbies = p.parallelStream().map(Person::getHobby).collect(Collectors.toList());
		
		hobbies.forEach(System.out::println);

	}

}
