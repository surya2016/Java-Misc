package example.programming.interview;

import java.util.ArrayList;
import java.util.List;

public class StringPermutationsEx {

	 public static void main(String a[]) {
		 
	        List<String> output = StringPermutationsEx.generatePermutations("xyz");
	        System.out.println("Result size: "+output.size());
	        output.stream().forEach(System.out::println);
	        System.out.println("------------------");
	 
	      /*  output = StringPermutationsEx.generatePermutations("ABCD");
	        System.out.println("Result size: "+output.size());
	        output.stream().forEach(System.out::println);*/
	    }
	 
	 	public static List<String> genPerm(String input)
	 	{
	 		List<String> strList = new ArrayList<String>();
	 		
	 		
	 		String consChars ="";
	 		for(int i=0; i<input.length(); i++) {
	        	
	 			
	            
	        }
	 		
	 		
	 		
	 		return strList;
	 	}
	 
	 
	    public static List<String> generatePermutations(String input) {
	 
	        List<String> strList = new ArrayList<String>();
	        StringPermutationsEx.permutations("", input, strList);
	 
	        return strList;
	    }
	 
	    private static void permutations(String consChars, String input, List<String> opContainer) {
	 
	       //System.out.println("consChars-->"+consChars+"   input-->"+input);
	    	
	    	if(input.isEmpty()) {
	            opContainer.add(consChars+input);
	            return;
	        }
	 
	        for(int i=0; i<input.length(); i++) {
	        	
	        	//System.out.println("In loop--"+input.substring(0, i));
	        	
	            permutations(consChars+input.charAt(i),
	                            input.substring(0, i)+input.substring(i+1),
	                            opContainer);
	        }
	    }
}
