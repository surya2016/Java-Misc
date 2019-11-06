package example.java8.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import example.java8.Person;

public class AdvancedStream {

	public static void main(String[] args)
	{
		List<Person> persons = Arrays.asList(
				new Person("Charles","Dicken",23,"Dancing"),
				new Person("Lewis","Carrol",67,"Writing"),
				new Person("Thomas","Carlyl",12,"Playing footbalg"),
				new Person("Charollete","Bryn",23,"Painting"),
				new Person("Marthew","Arnold",12,"Playing music"),
				new Person("Tom","Christian",53,"Dancing")

				);
		
		//first names starting with c
		List<Person> namesStartingC = persons.stream()
				.filter(p->p.getFirstname().startsWith("C"))
				.collect(Collectors.toList());

			System.out.println(namesStartingC); 
		
		//grouping by age
		Map<Integer,List<Person>> groupByAge = persons.stream()
				.collect(Collectors.groupingBy(p->p.getAge()));
		
		groupByAge.forEach((age,p)->System.out.format("Age %s: %s \n",age,p));
		
		
		Double averageAge = persons
			    .stream()
			    .collect(Collectors.averagingInt(p -> p.getAge()));

		System.out.println("Average age of the group:"+averageAge);
		
		//Built in statistics object
		IntSummaryStatistics ageSummary =
			    persons
			        .stream()
			        .collect(Collectors.summarizingInt(p -> p.getAge()));

			System.out.println(ageSummary);
			
		//persons of legal age in Germany
			
		String adults = persons.stream()
				.filter(p->p.getAge()>=18)
				.map(p->p.getFirstname())
				.collect(Collectors.joining(", ", "In Germany ", "are of legal age"));
		
		//Collectors.joining("delimiter that comes in between person elements","prefix","suffix");
		
		System.out.println(adults);
		
		/*In order to transform the stream elements into a map, we have to specify how both the 
		 * keys and the values should be mapped. Keep in mind that the mapped keys must be unique,
		 * otherwise an IllegalStateException is thrown. You can optionally pass a merge function 
		 * as an additional parameter to bypass the exception:
		 * 
		 */
		
		Map<Integer,String> personsMap = persons.stream()
				.collect(Collectors.toMap(p->p.getAge(), p->p.getFirstname(), 
						(name1,name2)-> name1+";"+name2 ));
		
		personsMap.forEach((age,p)-> System.out.println(age+":"+p));
		
		
		
		/*
		 * We want to transform all persons of the stream into a single string consisting of all 
		 * names in upper letters separated by the | pipe character. In order to achieve this we 
		 * create a new collector via Collector.of(). We have to pass the four ingredients of a 
		 * collector: a supplier, an accumulator, a combiner and a finisher.
		 */
		
		/*
		 * Interface Collector<T,A,R>
			Type Parameters:
			T - the type of input elements to the reduction operation
			A - the mutable accumulation type of the reduction operation (often hidden as an implementation detail)
			R - the result type of the reduction operation
		 */
		
		/*
		 * creation of a new result container (supplier())
			incorporating a new data element into a result container (accumulator())
			combining two result containers into one (combiner())
			performing an optional final transform on the container (finisher()
		 */
		
		Collector<Person,StringJoiner,String> personNameCollector = Collector.of(
				()-> new StringJoiner(" | "), //supplier --new StringJoiner("joiner","prefix","suffix")
				(j,p)-> j.add(p.getFirstname().toUpperCase()), //accumulator
				(j1,j2)-> j1.merge(j2),// combiner
				StringJoiner::toString);// characteristics
		
		String names = persons.stream()
				.collect(personNameCollector);
		System.out.println("Names : "+names);
		
		
		//determine the oldest person using reduce which accepts a BinaryOperator accumulator 
		
		persons.stream()
		.reduce((p1,p2)-> p1.getAge()>p2.getAge()?p1:p2)
		.ifPresent(p-> System.out.println("Oldest Person: "+p.getFirstname()));
		
		
		/*construct a new Person with the aggregated names and ages from all other persons in 
		the stream using reduce method which accepts both an identity value and a 
		BinaryOperator accumulator*/
		
		Person p = persons.stream()
				.reduce(new Person("","",0,""),
						(p1,p2)-> {
							p1.setFirstname(p1.getFirstname()+","+p2.getFirstname());
							p1.setAge(p1.getAge()+p2.getAge());
							return p1;
						});
		
		System.out.println("Aggregate of all names and ages : "+p.getFirstname()+"   "+p.getAge());
		
		
		
		
		
		
	}
		
}
