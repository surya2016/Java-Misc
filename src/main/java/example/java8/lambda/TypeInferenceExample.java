package example.java8.lambda;

public class TypeInferenceExample {

	
	@FunctionalInterface
	interface print
	{
		void println();
	}
	
	public static void main(String args[])
	{
		//String s = "Hellooo";
		CustString len = s -> s.length();
		
		print println = ()-> System.out.println(len.getLength("Helllooo"));
		
		println.println();
 	}
	
}
