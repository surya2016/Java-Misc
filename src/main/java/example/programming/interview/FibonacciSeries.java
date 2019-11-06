package example.programming.interview;

import java.util.Scanner;

public class FibonacciSeries {

	static int fibo(int n)
	{
		if(n==1||n==2)
			return 1;
		else 
			return fibo(n-1)+fibo(n-2);
	}
	
	static int fiboLoop(int n)
	{
		if(n==1||n==2)
			return 1;
		else
		{
			int temp1 =1, temp2=1,fib =1;
			for(int i=3;i<=n;i++)
			{
				fib = temp1+temp2;
				temp1=temp2;
				temp2=fib;
				
			}
			
			return fib;
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("How many elents of fibonacci series you want to print?");
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		System.out.println("Fibonacci Series using recurssion:");
		
		for(int i=1; i<=num; i++)
		{
			System.out.print(fibo(i)+" ");
		}
		
		System.out.println("\nFibonacci Series using loop:");
		
		for(int i=1; i<=num; i++)
		{
			System.out.print(fiboLoop(i)+" ");
		}
		
		sc.close(); //if you don't put it, compile will throw a resource leak warning for scanner
	}
}
