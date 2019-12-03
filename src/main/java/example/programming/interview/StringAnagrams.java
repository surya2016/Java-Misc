package example.programming.interview;

/**
 * Anagram: Word or phrase formed by rearranging letters of another word or phrase
 */

import java.util.Arrays;

public class StringAnagrams {
	
	/* One way to find if two Strings are anagram in Java. This method 
	 * assumes both arguments are not null and in lowercase. 
	 * @return true, if both String are anagram */

	public static boolean isAnagram(String word, String anagram){ 
		if(word.length() != anagram.length())
		{ 
			return false; 
		} 
		char[] chars = word.toCharArray(); 
		
		for(char c : chars){
			int index = anagram.indexOf(c);
			if(index != -1)
			{ 
				anagram = anagram.substring(0,index) + anagram.substring(index +1, anagram.length()); 
			}
			else{ 
				return false; 
			} 
		} 
		return anagram.isEmpty(); 
	}
	
	/* Another way to check if two Strings are anagram or not in Java 
	 * This method assumes that both word and anagram are not null and lowercase 
	 * @return true, if both Strings are anagram. */ 
	public static boolean iAnagram(String word, String anagram){ 
		
		if(word.length() != anagram.length())
		{ 
			return false; 
		} 		
		char[] charFromWord = word.toCharArray(); 
		char[] charFromAnagram = anagram.toCharArray(); 
		Arrays.sort(charFromWord); 
		Arrays.sort(charFromAnagram); 
		return Arrays.equals(charFromWord, charFromAnagram); 
	}
	
	//third method -slight variation in 1st
	public static boolean checkAnagram(String first, String second){
		char[] characters = first.toCharArray(); 
		StringBuilder sbSecond = new StringBuilder(second); 
		for(char ch : characters)
		{ 
			int index = sbSecond.indexOf("" + ch); 
			if(index != -1){ 
				sbSecond.deleteCharAt(index); 
			}
			else
			{ 
				return false; 
			} 
		} 
		return sbSecond.length()==0 ? true : false; 
	}

	/**
	 * Test cases:
	 * 1. Anagram Strings: Listen, silent 
	 * 2. Reed, deer
	 * 3. Random strings: test,rest
	 * 5. different string length
	 * 6. Passing first string as null string
- passing second string as null string
- passing both strings as null string
- passing two different strings (non anagrams)
- passing two anagram strings, one with upper case
- passing two anagram strings containing integers
- passing two strings composed of whitespace only
 Test with strings containing a space in between
- passing two correct anagram strings
- passing two correct anagram non english strings
Test with non dictionary words
 Test with super long strings
 Test with one char strings
 Test with hyphenated words
 Repeatedly call the function 1000 times
  Call the method in a a multi threaded environment
  Test with alpha-numeric strings
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
