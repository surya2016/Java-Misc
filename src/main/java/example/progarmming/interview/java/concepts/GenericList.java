package example.progarmming.interview.java.concepts;

import java.util.ArrayList;
import java.util.List;

public class GenericList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Object> l = new ArrayList<Object>();
		
		l.add(1);
		l.add(2);
		l.add(3);
		l.add("abc");
		l.add("pqr");
		l.add(4);
		l.add("xyz");
		l.add(7);
		int sum = 0;
		String s="";
		for (Object obj: l) {
		    if (obj instanceof String){
		    	s=s+(String)obj;
		        
		    } else if (obj instanceof Integer) {
		    	sum=sum+(Integer)obj;
		    }
		}
		System.out.println(sum+"    "+s);
	}

}
