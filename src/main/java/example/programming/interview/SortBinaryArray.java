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

	public static void main(String[] args) {
		
		
		int a[] = { 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 
                1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0 };
		
		sortBinaryArr(a);
		
		for(int i=0; i<a.length;i++)
			System.out.print(a[i]+" ");

	}

}
