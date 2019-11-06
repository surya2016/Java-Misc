package example.java8.stream;

import java.util.Optional;

import example.java8.model.Outer;

public class OptionalFlatMap {

	public static void main(String[] args) {
		
		
		Optional.of(new Outer())
			.flatMap(o -> Optional.ofNullable(o.getNested()))
			.flatMap(n -> Optional.ofNullable(n.getInner()))
			.flatMap(i -> 
						{
							i.setFoo("helloo");
							return Optional.ofNullable(i.getFoo());
						})
			.ifPresent(System.out::println); //????not getting any ouptu///need more work
		

	}

}
