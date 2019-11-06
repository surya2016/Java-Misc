package example.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JavaStream {

	private static Stream<Integer> sumStream(List<Integer> list) {
		return list.stream().filter(i -> i > 10); //.mapToInt(i -> i).sum();
	}
	
	public static void main(String args[])
	{
		List<Integer> num = new ArrayList<Integer>();
		
		for(int i=0;i<50;i++)
		{
			num.add(i);
		}
		
		
		System.out.println(sumStream(num));
	}
}
