package example.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import example.java8.Person;

public class PersonExUsingUtilFunction {

	static void performConditionally(List<Person> per, Predicate<Person> condition, Consumer<Person> action)
	{
		for(Person p:per)
			if(condition.test(p))
				action.accept(p);
	}
	
	
	public static void main(String[] args) {
		

		List<Person> p = Arrays.asList(
				new Person("Charles","Dicken",23,"Dancing"),
				new Person("Lewis","Carrol",67,"Writing"),
				new Person("Thomas","Carlyl",53,"Playing footbalg"),
				new Person("Charollete","Bryn",23,"Painting"),
				new Person("Marthew","Arnold",23,"Playing music"),
				new Person("Tom","Christian",23,"Dancing")

				);
		
		//Sorting corresponding to last name
		
		Comparator<Person> byLastName = (o1,o2) -> o1.getLastname().compareTo(o2.getLastname());
		
		p.sort(byLastName);
		
		//printALL
		performConditionally(p, x->true, x->System.out.println(x));
		
		//print whose last name begins with c
		
		performConditionally(p, x->x.getLastname().startsWith("C"), x->System.out.println(x));
		
		//print whose last name begins with t
		performConditionally(p, x->x.getFirstname().startsWith("T"), x->System.out.println(x.getFirstname()));
	}

}
