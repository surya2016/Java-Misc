package example.programming.interview;

import java.util.Arrays;

import common.Utility;

public class UnionAndIntersectionOfArrays {
	
	
	//O(n) where m>n - for already sorted arrays
	public void printIntersection(int [] A, int [] B)
	{
		int lenA = A.length;
		int lenB = B.length;
		
		int i=0,j=0;
		
		while(i<lenA && j<lenB)
		{
			if(A[i]==B[j])
			{
				if(i==0||j==0)
					System.out.println(A[i]+" ");
				else if(A[i]!= A[i-1] && B[j]!=B[j-1]) // to handle duplicates
					System.out.println(A[i]+" ");
				i++;
				j++;
			}
			else if(A[i]<B[j])
				i++;
			else
				j++;
		}
		
	}
	
	//use set for finding common elements
	
	
	//O(n) where m>n - for already sorted arrays
	public void printUnion(int [] A, int [] B)
	{
		int lenA = A.length;
		int lenB = B.length;
		
		int i=0,j=0;
		
		while(i<lenA && j<lenB)
		{
			if(A[i]==B[j])
			{
				if(i==0||j==0)
					System.out.println(A[i]+" ");
				else if(A[i]!= A[i-1] && B[j]!=B[j-1]) // to handle duplicates
					System.out.println(A[i]+" ");
				i++;
				j++;
			}
			else if(A[i]<B[j])
			{
				if(i==0)
					System.out.println(A[i]+" ");
				else if(A[i]!= A[i-1])
					System.out.println(A[i]+" ");
				i++;
			}
				
			else
			{
				if(j==0)
					System.out.println(B[j]+" ");
				else if(B[j]!= B[j-1])
					System.out.println(B[j]+" ");
				j++;
			}
		}
		
		while(i<lenA)
		{
			if(i==0)
				System.out.println(A[i++]+" ");
			else if(A[i]!= A[i-1])				// to handle duplicates
				System.out.println(A[i++]+" ");
		}
		
		while(j<lenB)
		{
			if(j==0)
				System.out.println(B[j++]+" ");
			else if(B[j]!= B[j-1])					// to handle duplicates
				System.out.println(B[j++]+" ");
		}
	}
	
	public static void main(String[] args) {
		
		UnionAndIntersectionOfArrays UnI = new UnionAndIntersectionOfArrays();
		
		Utility util = new Utility();
		
		int [] A = util.getRandomArray(11,5);
		int [] B = util.getRandomArray(14, 5);
		
		//int [] A = {1,1,1,2,3,4};
		//int [] B = {0,0,0,0,1,4};
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		System.out.println("Array A is:");
		for (int ele : A) {
			System.out.print(ele+",");
		}
		
		System.out.println("\nArray B is:");
		for (int ele : B) {
			System.out.print(ele+",");
		}
		
		
		System.out.println("Intersection:");
		UnI.printIntersection(A, B);
		
		System.out.println("Union");
		UnI.printUnion(A, B);
		
		
	}
	

}
