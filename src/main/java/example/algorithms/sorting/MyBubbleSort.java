package example.algorithms.sorting;

import java.util.Scanner;

public class MyBubbleSort {
	
	
	
	public int[] sort(int[] a)
	{
		int len = a.length;
		
		for(int i=len;i>0;i--)
		{
			for(int j=0;j<len-1;j++)
			{
				if(a[j]>a[j+1])
					swap(j,j+1,a);
			}
		}
		return a;
	}
	
	public void swap(int temp1,int temp2,int[] arr)
	{
		int temp = arr[temp1];
		arr[temp1]=arr[temp2];
		arr[temp2]=temp;
	}

	public static void main(String[] args) {
		
		MyBubbleSort bubble = new MyBubbleSort();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array length:");
		
		int length = sc.nextInt();
		
		int a[] = new int[length];
		
		System.out.println("Enter array elements:");
		
		for (int i = 0; i < length; i++) { 
			a[i] = sc.nextInt();  
		}
		
		int sortedArr []=bubble.sort(a);
		
		System.out.println("Array after sorting is:");
		for(int i=0;i<sortedArr.length;i++)
			System.out.print(a[i]+"\t");
		
		sc.close();
	}

}
