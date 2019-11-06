package example.programming.interview;

public class OddOccurrencesInArray {

	/*
	 * test cases :
	 * [9, 3, 9, 3, 9, 7, 9] 
	 * [0, 1, 0] 
	 * [1, 1, 0]
	 * 
	 * Time Complexity : O(n)
	 * Space Complexity : O(1)
	 * 
	 */
	public static int solution(int[] A) {
        
        int result =0;
        
        for(int i=0;i<A.length;i++)
            result = result ^ A[i];   // XOR of all elements gives us odd occurring element. 
        //Please note that XOR of two elements is 0 if both elements are same and XOR of a number x with 0 is x.
            
        return result;
        
        
    }
	
	public static void main(String[] args) {
		
		
		int [] A = {0, 1, 0};
		
		System.out.println(solution(A));
		

	}

}
