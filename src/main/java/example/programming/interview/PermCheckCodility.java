package example.programming.interview;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;


/**
 * Check whether array A is a permutation.
 * @author suryakhanna
 *
 */
public class PermCheckCodility {

	/*
	 * A non-empty array A consisting of N integers is given.

	   A permutation is a sequence containing each element from 1 to N once, and only once
	 */
	
	//need faster solution
	public static int solution(int[] A) {
	      int N = A.length;
	      return ((((N*(N+1))/2)-IntStream.of(A).distinct().filter(i-> i>=1 && i<=N).sum())==0)?1:0;
	}
	
	
	public static int solution1(int... A) {
	    Set<Integer> set = new HashSet<>();
	    // calculating sum of permutation elements
	    int sum = A.length * (A.length +1) /2;
	    for(int i=0; i<A.length;i++){
	        set.add(A[i]);
	        sum -=A[i];
	        }
	    // return 0 if either sizes don't much or there was some 
	    // number/s missing in permutation and thus sum !=0;
	    return ((set.size() == A.length) && sum ==0)? 1 : 0;    
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A= {4,0,3,3};  //0
		//int [] A= {4,0,2};  //0
		//int [] A= {4,1,2,3}; //1
		//int [] A = {3, 3, 3, 3, 3};//0
        int result = solution1(A); 
        System.out.println(result);
	}

}
