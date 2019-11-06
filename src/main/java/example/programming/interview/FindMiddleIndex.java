package example.programming.interview;
/**
 * Problem Statement: You are given an array of numbers. Find out the array index or position
	where sum of numbers preceding the index is equals to sum of numbers
	succeeding the index i.e sum of elements meet.
 */

public class FindMiddleIndex {
	
	//logic complexity O(log n)
	public int getMiddleIndex(int [] a) throws Exception
	{
		int sumRight=0,sumLeft=0, begIndex=0;
		int endIndex = a.length -1;
		
		while(true)
		{
			if(sumRight>sumLeft)
				sumLeft +=a[begIndex++];
			else
				sumRight +=a[endIndex--];
			
			if(begIndex>endIndex)
				if(sumLeft==sumRight)
					break;
				else
					throw new Exception("Invalid array");
			
		}
		return endIndex;
	}
	
	//alternate way: find sum of all elements - iterate till half the sum again

	public static void main(String[] args) {
		
		int [] arr = {1,2,3,2,1,3};
		
		FindMiddleIndex mid = new FindMiddleIndex();
		try {
			int middle = mid.getMiddleIndex(arr);
			System.out.println(middle);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//logic complexity = O(n)
		/*int sum =0;
		
		for(int i=0; i<arr.length;i++)
		{
			sum +=arr[i];
		}
		
		int sum1=0;
		for(int i=0;i<arr.length;i++)
		{
			if(sum1<(sum/2))
				sum1+=arr[i];
			else
			{
				System.out.println("Middle element "+arr[i-1]+" is at index:"+(i-1));
				break;
			}
				
		}*/

	}

}
