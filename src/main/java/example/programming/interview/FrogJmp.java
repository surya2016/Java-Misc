package example.programming.interview;

/**
 * Problem 1: Count minimal number of jumps from position X to Y.
 * Problem 2: Find the earliest time when a frog can jump to the other side of a river.
 * @author suryakhanna
 *
 */
public class FrogJmp {

	
	/*
	 * A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.
	   Count the minimal number of jumps that the small frog must perform to reach its target.
	   
	   Given:
	   X = 10,Y = 85,  D = 30  Ans=3
	 */
	//Time Complexity = O(1)
	public static int solution(int X, int Y, int D)
	{
		return (int) Math.ceil((double)(X-Y)/D);
		
	}
	
	/*A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the 
	 * opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.
	   You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, 
	   measured in seconds.The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves 
	   appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by 
	   leaves). You may assume that the speed of the current in the river is negligible small, i.e. the leaves do not change their positions once they fall in 
	   the river.
	 * 
	 * For example, you are given integer X = 5 and array A such that:

		  A[0] = 1
		  A[1] = 3
		  A[2] = 1
		  A[3] = 4
		  A[4] = 2
		  A[5] = 3
		  A[6] = 5
		  A[7] = 4
	   In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.
	   If the frog is never able to jump to the other side of the river, the function should return −1.
	 * 
	 */
	
	public int sol(int X, int[] A)
	{
		
		
		
		return X;
		
	}
	
	
	
}
