package example.programming.interview;

/**
 * @Problem Given 2 strings, find out if one is the rotation of another
 * @Solution Take string one and concatenate with itself. Search if the 2nd string is the substring of the resultant. Eg. Str1 =water
 * str2 =rwate, concatenated = waterwater  or rwaterwate
 * @author surya
 *
 */
public class RotationProblem {
	
	
	public static void main(String args[])
	{
		String s = "water";
		//String s1 = "rwater"; // not a rotation
		//String s1 = "rwate";  // rotation
		//String s1 = "rw123";  // not a rotation
		String s1 = "rwtae";	// not a rotation
		
		
		String concate = s+s;  //concatenate parent string to itself
		
		if(s.length() == s1.length())
		{
			if(concate.contains(s1))
				System.out.println(s1+" is a rotation of "+s);
			else
				System.out.println("Not a rotation");
		}
		else
		{
			System.out.println("Strings are not equal, hence not a rotation");
		}
		
	}
	

}
