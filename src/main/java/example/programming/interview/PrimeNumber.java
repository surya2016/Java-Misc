package example.programming.interview;

import java.util.Scanner;

public class PrimeNumber {

	boolean isPrime(int n)
	{
		if(n==0||n==1||n<0)
			return false;
		else if(n==2||n==3)
			return true;
		else if (n%2==0)
			return false;
		else
		{
			int sqrt = (int) Math.sqrt(n);
			
			for(int i=3;i<=sqrt;i+=2)
			{
				if(n%i==0)
					return false;
			}
			return true;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		PrimeNumber prime = new PrimeNumber();
		
		System.out.println("Enter number to be checked:");
		
		int no = Integer.MAX_VALUE;
		System.out.println("Max Integer value:"+no);
		while(no!=0)
		{
			no = sc.nextInt();
			
			System.out.println("Number "+no+" is prime "+ prime.isPrime(no));
			
		}
		
		sc.close();
	}

}
