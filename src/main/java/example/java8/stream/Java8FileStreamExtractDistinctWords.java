package example.java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8FileStreamExtractDistinctWords {

	
	
	public void mostFrequent()
	{
		//try {
			/*List<String> lines = Files.lines(Paths.get("/home/suryakhanna/test.txt"))
					.map(line -> line.split("[\\s]+"))
					.flatMap(line -> line.toString());
					//.collect(Collectors.toList());
			
			
			for(String s:lines )
			{
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	public static void main(String[] args) {
        try {
        	
        	Stream<String> lines = Files.lines(Paths.get("/home/suryakhanna/test.txt"))
        				.map(line -> line.split("[\\s]+"))
        				.flatMap(Arrays::stream)
        				.distinct();
        	
        	lines.forEach(System.out::println);
        	lines.close();
        	
        	
        	
        }
        catch(IOException e)
        {
        	e.printStackTrace();
        }
	}
}
