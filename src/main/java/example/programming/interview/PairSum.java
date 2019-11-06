package example.programming.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Find all pair of elements of array having sum X
 * @author suryakhanna
 *
 */

public class PairSum {

	//O(NlogN)
	public static void pairSum(int [] A, int sum)
	{
		if(A.length < 2){
            return;
        }
		
		Arrays.sort(A); //O(Nlog N) -- sorting algorithm is a Dual-Pivot Quicksort i.e Insertion sort + Quick sort
		
		int leftIndex = 0;
		int rightIndex = A.length-1;
		
		while(leftIndex<rightIndex) //O(N)
		{
			if(A[leftIndex]+A[rightIndex]== sum)
			{
				System.out.println("Pair:"+A[leftIndex]+","+A[rightIndex]);
				leftIndex++;
				rightIndex--;
			}
			else if(A[leftIndex]+A[rightIndex]<sum)
			{
				leftIndex++;
			}
			else
			{
				rightIndex--;
			}
		}
	}
	
	
	/*
	 * Questions based upon problem statement given above :
		1. Does array contains only positive or negative numbers?
		2. What if the same pair repeats twice, should we print it every time?
		3. Is reverse of pair is acceptable e.g. can we print both (4,1) and (1,4) if given sum is 5.
		4. Do we need to print only distinct pair? does (3, 3) is a valid pair forgiven sum of 6?
		5. How big the array is?
	 */
	//O(N)
	public static void printPairsUsingSet(int[] numbers, int sum){
        if(numbers.length < 2){
            return;
        }        
        Set<Integer> set = new HashSet<Integer>(numbers.length);
        
        for(int value : numbers){
            int target = sum - value;
            
            // if target number is not in set then add
            if(!set.contains(target)){
                set.add(value);
            }else {
                System.out.printf("(%d, %d) %n", value, target);
            }
        }
    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//pairSum(new int[]{ 12, 14, 17, 15, 19, 20, -11}, 9);
		//,2,4,5,7,
		printPairsUsingSet(new int[]{ 2, 4, 7,4,7, 5,3,5, 9, 10, -1}, 9);
	}

}
