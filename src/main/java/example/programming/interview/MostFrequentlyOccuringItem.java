package example.programming.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentlyOccuringItem {

	
	//O(n log n)
	//Sort the array and then find most frequently occurring
	//assuming only one unique element has highest frequency 
	public static int mosFrequent(int [] A) {
		
		if(A.length ==0)
			return -1;
		
		Arrays.sort(A);  // O(n log N)
		
		int max =0;
		int res=A[0];
		
		int count =0;
		
		for(int i=1; i<A.length; i++)
		{
			if(A[i-1]==A[i])
				count ++;
			else 
				count =1;
			
			if(count > max)
			{
				max = count;
				res = A[i];
			}
		}
		return res;
	}
	
	
	//printing all elements having highest frequency 
	//O(n)
	// space complexity = O(n + m) //n size of Array +m size of hashmap
	public static void mostFrequentElement(int [] A)
	{
		HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
		
		for( int a: A)
		{
			if(hm.containsKey(a))				//O(1)
			{
				hm.put(a, hm.get(a)+1);
			}
			else
			{
				hm.put(a, 1);
			}
		}
		
		int max =0; //int mostFreq=-1;
		
		for(Integer key : hm.keySet())
		{
			if(hm.get(key) > max)
			{
				max = hm.get(key).intValue();
				//mostFreq = key;
			}
		}
		
		for(Map.Entry<Integer, Integer> entry : hm.entrySet())
		{
			if(entry.getValue() >=max)
				System.out.println("Highest frequency element : "+entry.getKey()+" frequency :"+entry.getValue());
		}
		
		//return mostFreq;
	}
	
	
	public static void main(String[] args) {
		//int []  A  = {2,5,5,3,1,1,6,7,3,4,1,8,5,5,5,1,2,3,4,1,5,1,5,1,5,5,5,1,1,1,8,1, 5,-1, -2 };
		int [] A = {1,1,1,1,1,1,2,2,2,2,2,2};
	
		System.out.println("mostFrequentElement(int [] A) hashmap : ");
		
		mostFrequentElement(A);
		
		System.out.println("mosFrequent O(n log N):"+mosFrequent(A));

	}

}
