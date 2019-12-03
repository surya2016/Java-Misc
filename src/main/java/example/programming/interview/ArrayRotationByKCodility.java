package example.programming.interview;

/**
 * Rotate an array to the right by a given number of steps.
 * @author suryakhanna
 *
 */

public class ArrayRotationByKCodility {

	
	//complexity = O(n*k)
public static int[] solution(int[] A, int K) {
        
        int len = A.length;
        
        if(len==0)
        	return A;
        
        int last;
        
        for(int j=0;j<K;j++)
        {
            last = A[len-1];
            for(int i=len-2;i>=0;i--)
                A[i+1]=A[i];
            
            A[0]=last;
        }
        
        return A;
    }
//time complexity = O(n), Space complexity = 2n
public static int[] sol(int[] A,int K)
{
	int len =A.length;
	
	int [] result= new int[len];
	 
	for(int i=0;i<len;i++)
	{
		result[(i+K)%len] = A[i]; //(i+K)%len -> adding k rotation to index and then modulating with length so that index remains within array bounds
		//modulus with length gives us the effective rotation
		/*
		 *eg. [3,8,9,7,6]  --gives original array after n(length of array) rotations  
		 * let k = 12
		 * As after every 5 rotations, we get original array on rotating towards right
		 * therefore, 12%5 =2 .... we will get same array on 12th and 2nd rotation ( 10th rotation will give same array as original)
		 */
	}
	//result = 76389
	return result;
	
}

/**
 * Reverse an array using rotations
 * On rotation towards left gives us reverse of and array after n(length of array) rotations 
 * 
 */
//wrongggggggg
/*public static int[] reverse(int A[])
{
	int len = A.length;
	int rev[] = new int[len];
	int step = len-1;
	for(int i=len-1;i>=0;i--)
		rev[(i-step)%len]=A[i];
	return rev;
}*/


public static void main(String args[])
{
	int A[] = {3, 8, 9, 7, 6};
	int [] rotate = solution(A,12);
	
	for (int i : rotate) {
		System.out.print(i);
	}
	/*System.out.println("\nreverse");
	int[] reverse = reverse(A);
	
	for (int i : reverse) {
		System.out.print(i);
	}*/
	
	
}
}
