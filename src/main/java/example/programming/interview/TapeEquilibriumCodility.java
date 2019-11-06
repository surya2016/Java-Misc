package example.programming.interview;

import java.util.Arrays;

/**
 * Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])| where A is an array of length N.
 * @author suryakhanna
 *
 */

import java.util.stream.IntStream;

public class TapeEquilibriumCodility {

	/*A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
We can split this tape in four places:

P = 1, difference = |3 − 10| = 7 
P = 2, difference = |4 − 9| = 5 
P = 3, difference = |6 − 7| = 1 
P = 4, difference = |10 − 3| = 7 
Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

the function should return 1, as explained above
	 * 
	 * 
	 */
	
	public int sol(int[] A) {
        //doesn't work for[-1000,1000]--- should return 200, but returns 0
        
        int midSum = IntStream.of(A).sum()/2;
        
        int sum =0;
        int sum1=0;
        boolean flag=true;
        for(int i =0; i < A.length; i++)
        {
        	sum +=A[i];
        	if((sum == midSum||sum ==midSum+1) && flag)
        	{
        		sum1=sum;
        		sum =0;
        		flag = false;
        	}
        		
        }
               
        return Math.abs(sum - sum1);
        
    }
	
	
	public static int solution(int[] A) {
        
		int sumLeft =A[0];
        
		int N = A.length;
		
        int[] rightSide = Arrays.copyOfRange(A, 1, N);
        int sumRyt = IntStream.of(rightSide).sum();
        
        int minDiff=(int) Math.abs(sumRyt - sumLeft);
        
        for(int i =1; i < N; i++)
        {
        	int diff = (int) Math.abs(sumRyt - sumLeft);
        	
        	minDiff = diff< minDiff? diff : minDiff;
        	
        	sumLeft +=A[i];
        	sumRyt -=A[i];//subtracting same number from ryt
        }
               
        return minDiff;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] A= {-1000,1000};
		System.out.println(solution(A));
		
	}

}
