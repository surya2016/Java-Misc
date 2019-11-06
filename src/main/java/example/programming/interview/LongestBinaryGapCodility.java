package example.programming.interview;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends 
 * in the binary representation of N.Find longest sequence of zeros in binary representation of an integer.
 * @author suryakhanna
 *
 */

public class LongestBinaryGapCodility {
	
	//char = 2 bytes
	// time complexity : O(log N) , space completixty = N+ binaryForm.length * 2+  binaryGap.legth * (each string length * 2)
	public static int solution(int N) {
		
		String binaryForm = Integer.toBinaryString(N);
		
		String [] binaryGap = binaryForm.split("1");
		
		int longestGap =0;
		
		for(String s:binaryGap)
		{
			System.out.println(s);
			if(s.length()>longestGap && binaryForm.contains("1"+s+"1"))
			{
				longestGap=s.length();
			}
				
		}
		
		return longestGap;
    }
	
	
	public static int sol2(int N)
	{
		String binaryForm = Integer.toBinaryString(N);
		
		int max = 0;
		int count =0;
		for(int i=0;i<binaryForm.length();i++)
		{
			if(binaryForm.charAt(i) == '0')
			{
				count++;
			}
			else
			{
				if(count > max && binaryForm.contains("1"+StringUtils.repeat("0", count)+"1"))
					max =count;
				count =0;
			}
		}
		
		return max;
	}
	
	//using java 8 method 
	 public int sol1(int N) {
	        String binaryForm = Integer.toBinaryString(N);
			
			int max = 0;
			int count =0;
			for(int i=0;i<binaryForm.length();i++)
			{
				if(binaryForm.charAt(i) == '0')
				{
					count++;
				}
				else
				{
					if(count > max && binaryForm.contains("1"+Stream.generate(() -> "0").limit(count).collect(Collectors.joining())+"1"))
						max =count;
					count =0;
				}
			}
			
			return max;
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      //testcase : 1041 = 5, 32=0, 15=0
		System.out.println("longestGap:"+solution(15));
		
		System.out.println("longestGap with min space complexity:"+sol2(1041));
		System.out.println("longestGap with min space complexity:"+sol2(15));
		System.out.println("longestGap with min space complexity:"+sol2(32));
	}

}
