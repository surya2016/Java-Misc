package example.progarmming.interview.java.concepts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

	public static void main(String[] args) {
		
		
		String str ="she sells sea shells";
		String rex="SsS";
		String replace = "X";
		Pattern p = Pattern.compile(rex);
		Matcher m = p.matcher(str);
		String val = m.replaceAll(replace);
		System.out.println(val); // no changes in output as no pattern match

	}

}
