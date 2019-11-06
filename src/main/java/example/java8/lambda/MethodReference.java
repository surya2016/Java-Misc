package example.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import example.java8.Person;

public class MethodReference {

	public static void main(String[] args) {
		
		
		Thread t = new Thread(()->printMessage());
		Thread t1 = new Thread(MethodReference::printMessage); //this method reference is equivalent to ()->printMessage()
		
		MethodReference ref = new MethodReference();
		Thread t2 = new Thread(ref::printMessageByInstance);
		/*
		 * So, any lambda of type ()->method() can be replaced by ClassName/Instance::MethodName
		 * Or any lambda of type x->method(x) can be replaced by ClassName/Instance::MethodName
		 */
		
		t.run();
		t1.run();
		t2.run();
		
		List<Person> p = Arrays.asList(
				new Person("Charles","Dicken",23,"Dancing"),
				new Person("Lewis","Carrol",67,"Writing"),
				new Person("Thomas","Carlyl",53,"Playing footbalg"),
				new Person("Charollete","Bryn",23,"Painting"),
				new Person("Marthew","Arnold",23,"Playing music"),
				new Person("Tom","Christian",23,"Dancing")

				);
		
		//printALL
		System.out.println("Using Lamda:");
		performConditionally(p, x->true, x->System.out.println(x));
		System.out.println("Using Method Reference:");
		performConditionally(p, x->true, System.out::println); //out -instance of class System, println - method of class System
				
		
	}

	private static void printMessage() {
		System.out.println("Hello");
	}
	
	private void printMessageByInstance(){
		System.out.println("Hello Instance");
	}
	
	private static void performConditionally(List<Person> per, Predicate<Person> condition, Consumer<Person> action)
	{
		for(Person p:per)
			if(condition.test(p))
				action.accept(p);
	}

}
