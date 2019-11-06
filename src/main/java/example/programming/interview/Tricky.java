package example.programming.interview;

public class Tricky {

	public static void main(String[] args) 
	{ 
		System.out.println(Double.MIN_VALUE);
		System.out.println("Double min:"+Math.min(Double.MIN_VALUE, 0.0d)); 
		
		System.out.println("Integer min:"+Math.min(Integer.MIN_VALUE, 0)); 
		
		/*
		 * Output:
		 * Double min:0.0
		 * Integer min:-2147483648
		 */
	} 
	
}
