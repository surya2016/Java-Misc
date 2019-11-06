package example.java8.lambda;

@FunctionalInterface
public interface CustString {

	int getLength(String s);
	//void println(); -> gives error
	
	static String concat(String s, String s1)
	{
		return s+s1;
	}
}
