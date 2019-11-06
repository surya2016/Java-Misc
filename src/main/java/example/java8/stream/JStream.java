package example.java8.stream;

import java.util.function.Supplier;
import java.util.stream.*;
public class JStream {

	public static void main(String[] args) {
		Stream.of("d2", "a2", "b1", "b3", "c","a1","a3")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .sorted((s1, s2) -> {
	        System.out.printf("sort: %s; %s\n", s1, s2);
	        return s1.compareTo(s2);
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
		
		Supplier<Stream<String>> streamSupplier =
			    () -> Stream.of("d2", "a2", "b1", "b3", "c","a3")
			            .filter(s -> s.startsWith("a"));

			if(streamSupplier.get().anyMatch(s -> true))
				System.out.println("Match");
			if(streamSupplier.get().noneMatch(s -> true))
				System.out.println("No Match");

	}

}
