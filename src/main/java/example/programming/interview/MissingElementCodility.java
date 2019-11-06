package example.programming.interview;

import java.util.stream.IntStream;

/**
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], 
 * which means that exactly one element is missing.Find missing element
 * @author suryakhanna
 * @testexample [2, 3, 1, 5],[2,3,4,5] 
 */
public class MissingElementCodility {

	 public int solution(int[] A) {
	        
	        long N = A.length+1; //taking n+1 because extra element n+1 is present in array
	        
	        return (int) (((N*(N+1))/2)-IntStream.of(A).sum()); // difference between sum of actual elements and (expected elements+one extra element gives the element)
	        
	        
	    }
}
