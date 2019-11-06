package example.programming.interview.utility;

import java.util.Arrays;

public class Util {

	/**
     * Utility method to return random array of Integers in a range of 0 to range
     */
    public static int[] getRandomArray(int length, int range){
        int[] randoms = new int[length];
        for(int i=0; i<length; i++){
            randoms[i] = (int) (Math.random()*range);
        }
		return randoms;
    }
    
    
}
