package example.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import example.java8.model.Bar;
import example.java8.model.Foo;

public class FlatMapOps {
	
	public static void main(String[] args)
	{
		/**
		 * Target : Transforming the stream of three Foo objects into a stream 
		 *  of twelve bar objects.
		 */
		
		List<Foo> foos = new ArrayList<Foo>();
		
		//adding Foo objects to list foos
		IntStream.range(1, 4)
		.forEach(i-> foos.add(new Foo("Foo"+i)));
		
		//creating bars
		foos.forEach(
				f -> IntStream.range(1, 5)
						.forEach(i-> f.bars.add(new Bar("Bar"+i+"<-"+f.getName())))		
			);
		
		//using flat map to stream all bars 
		
		foos.stream()
		.flatMap(f-> f.bars.stream())
		.forEach(b-> System.out.println(b.getName()));
		
		System.out.println("-------------------------");
		
		//the above code example can be simplified into a single pipeline of stream operations:
		
		IntStream.range(1, 4)
		.mapToObj(i-> new Foo("Foo"+i))
		.peek(f-> IntStream.range(1, 3)
				//.mapToObj(i -> new Bar("Bar"+i+"<-"+f.getName()))
				//.forEach(f.bars::add))
				.forEach(i-> f.bars.add(new Bar("Bar"+i+"<-"+f.getName())))
				)
		.flatMap(f->f.bars.stream())
		.forEach(b->System.out.println(b.getName()));
	}

}
