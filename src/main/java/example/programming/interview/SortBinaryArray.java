package example.programming.interview;

public class SortBinaryArray {
	
	public static void sortBinaryArr(int a[])
	{
		int len = a.length;
		
		int j=-1; //pointer till last sorted 0
		
		for(int i=0; i<len;i++)
		{
			//if no is less than 1, swap else do nothing - swapping whenever zero is encountered
			if(a[i]<1)
			{
				j++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
	}
	
	
	public static void sortArrOf012(int a[])
	{
		int len = a.length;
		
		int count0 =0;
		int count1 =0;
		int count2=0;
		
		for(int i=0;i<len;i++)
		{
			if(a[i]==0)
				count0++;
			else if(a[i]==1)
				count1++;
			else
				count2++;
		}
		
		int j=0;
		
		for(int i=0;i<count0;i++)
		{
			a[j]=0;
			j++;
		}
		
		for(int i=0;i<count1;i++)
		{
			a[j]=1;
			j++;
		}
		
		for(int i=0;i<count2;i++)
		{
			a[j]=2;
			j++;
		}
		
	}

	public static void main(String[] args) {
		
		
		int a[] = { 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 
                1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0 };
		
		sortBinaryArr(a);
		
		for(int i=0; i<a.length;i++)
			System.out.print(a[i]+" ");
		
		System.out.println("Sort 0, 1,2");
		int b[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		sortArrOf012(b);
		for(int i=0; i<b.length;i++)
			System.out.print(b[i]+" ");
		

	}

}
