package example.programming.interview;

import java.util.Arrays;
import java.util.HashSet;

public class DetermineSubset {
	
	/**
	 * Time Complexity: O(m*n)
	 * @param arr1
	 * @param arr2
	 * @param m
	 * @param n
	 * @return
	 */
	/* Return true if arr2[] is a subset 
    of arr1[] */
    static boolean isSubsetComplex(int arr1[], 
                int arr2[], int m, int n)
    {
        int i = 0;
        int j = 0;
        for (i = 0; i < n; i++)
        {
            for (j = 0; j < m; j++)
                if(arr2[i] == arr1[j])
                    break;
             
            /* If the above inner loop 
            was not broken at all then
            arr2[i] is not present in
            arr1[] */
            if (j == m)
                return false;
        }
         
        /* If we reach here then all
        elements of arr2[] are present
        in arr1[] */
        return true;
    }
	
	
	/**
	 * Alternate method using sort and merge like technique and handles duplicates
	 * Time Complexity: O(mLogm + nLogn)
	 * @param arr1
	 * @param arr2
	 * @param m
	 * @param n
	 * @return
	 */
	/* Return true if arr2[] is a subset of arr1[] */
    static boolean isSubset(int arr1[], int arr2[], int m,
                                                   int n)
    {
        int i = 0, j = 0;
             
        if(m < n)
        return false;
         
        Arrays.sort(arr1); //sorts arr1
        Arrays.sort(arr2); // sorts arr2
 
        while( i < n && j < m )
        {
            if( arr1[j] < arr2[i] )
                j++;
            else if( arr1[j] == arr2[i] )
            {
                j++;
                i++;
            }
            else if( arr1[j] > arr2[i] )
                return false;
        }
         
        if( i < n )
            return false;
        else
            return true;
    } 
	
	
	/**
	 * ALternate method using hashing doesn't handle duplicates
	 * Complexity:
	 * @param arr1
	 * @param arr2
	 * @param m
	 * @param n
	 * @return
	 */
	/* Return true if arr2[] is a subset of arr1[] */
    static boolean isHashingSubset(int arr1[], int arr2[], int m,
                                                 int n)
    {
        HashSet<Integer> hset= new HashSet<Integer>();
         
        // hset stores all the values of arr1
        for(int i = 0; i < m; i++)
        {
            if(!hset.contains(arr1[i]))
                hset.add(arr1[i]);
        }
             
        // loop to check if all elements of arr2 also
        // lies in arr1
        for(int i = 0; i < n; i++)
        {
            if(!hset.contains(arr2[i]))
                return false;
        }
        return true;
    } 
 
    public static void main(String[] args) 
    { 
        int arr1[] = {11, 1, 13, 21, 3, 7};
        int arr2[] = {11, 3, 7, 1};
         
        int m = arr1.length;
        int n = arr2.length;
             
        if(isHashingSubset(arr1, arr2, m, n))
        System.out.println("arr2 is a subset of arr1");
        else
        System.out.println("arr2 is not a subset of arr1");
        
        
        int a1[] = {11, 1, 13, 21, 3, 7,4,2};
        int a2[] = {1, 4, 4, 2};
         
        int l1 = a1.length;
        int l2 = a2.length;
        
        if(isSubset(a1, a2, l1, l2))
            System.out.println("arr2 is a subset of arr1");
            else
            System.out.println("arr2 is not a subset of arr1");
    }
}
