package example.programming.interview;

import java.util.Scanner;

public class PhoneNumToString {
	
	
	/*private static  char getCharForNumber(long i) {
	    return i >= 0 && i < 27 ?(char)(i + 65) : null;
	}*/
	

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter phone number:");
		
		long num = sc.nextLong();
		
		Long digit;
		
		//String ph = "";
		String phone="";
		
		System.out.println("number entered:"+num);
		
		while(num>0)
		{
			digit = num%10;
			
			//int digi = digit.intValue();
			
			//ph=getCharForNumber(digit)+ph;
			phone = (char) (digit + 65)+phone;
			
			num = num /10;
			
		}
		
		//System.out.println(ph);
		System.out.println(phone);
		
		//System.out.println( String.valueOf((char)(0 + 65)));
		sc.close();
		

	}

}
