package example.progarmming.interview.java.concepts;

import java.util.ArrayList;
import java.util.List;
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
		
		
		//compare in https://regex101.com/
		
		String text = "{Value incorrect in mySQL for key172130_2_2590_265_session_percentage\n" + 
				"=BQ data ={course_id=184, entity_id=265, created_by=admin@simplilearn.com, session_percentage=87.50, elearning_id=2590, submission_date=1577543307, createdAt=1577543307, entity_type=test, attempt_number=1, user_id=172130, group_id=2, entity_sub_type=simtest, updated_by=admin@simplilearn.com, status=passed, updatedAt=1577543307}\n" + 
				"MySQL data={user_id=172130, course_id=184, elearning_id=2590, entity_type=test, entity_id=265, group_id=2, entity_sub_type=simtest, submission_date=1577543307, attempt_number=1, status=passed, session_percentage=100.00, createdAt=1577543307, updatedAt=1577543307, created_by=admin@simplilearn.com, updated_by=admin@simplilearn.com}, Value incorrect in mySQL for key172130_2_2590_259_session_percentage\n" + 
				"=BQ data ={course_id=184, entity_id=259, created_by=admin@simplilearn.com, session_percentage=82.50, elearning_id=2590, submission_date=1577492657, createdAt=1577492658, entity_type=test, attempt_number=1, user_id=172130, group_id=2, entity_sub_type=simtest, updated_by=admin@simplilearn.com, status=passed, updatedAt=1577492658}\n" + 
				"MySQL data={user_id=172130, course_id=184, elearning_id=2590, entity_type=test, entity_id=259, group_id=2, entity_sub_type=simtest, submission_date=1577492657, attempt_number=1, status=passed, session_percentage=85.00, createdAt=1577492658, updatedAt=1577492658, created_by=admin@simplilearn.com, updated_by=admin@simplilearn.com}, Value incorrect in mySQL for key172130_2_2590_264_session_percentage\n" + 
				"=BQ data ={course_id=184, entity_id=264, created_by=admin@simplilearn.com, session_percentage=87.50, elearning_id=2590, submission_date=1577496187, createdAt=1577496187, entity_type=test, attempt_number=1, user_id=172130, group_id=2, entity_sub_type=simtest, updated_by=admin@simplilearn.com, status=passed, updatedAt=1577496187}\n" + 
				"MySQL data={user_id=172130, course_id=184, elearning_id=2590, entity_type=test, entity_id=264, group_id=2, entity_sub_type=simtest, submission_date=1577496187, attempt_number=1, status=passed, session_percentage=100.00, createdAt=1577496187, updatedAt=1577496187, created_by=admin@simplilearn.com, updated_by=admin@simplilearn.com}, Value incorrect in mySQL for key172130_2_2590_258_session_percentage\n" + 
				"=BQ data ={course_id=184, entity_id=258, created_by=admin@simplilearn.com, session_percentage=90.00, elearning_id=2590, submission_date=1577542343, createdAt=1577542344, entity_type=test, attempt_number=1, user_id=172130, group_id=2, entity_sub_type=simtest, updated_by=admin@simplilearn.com, status=passed, updatedAt=1577542344}\n" + 
				"MySQL data={user_id=172130, course_id=184, elearning_id=2590, entity_type=test, entity_id=258, group_id=2, entity_sub_type=simtest, submission_date=1577542343, attempt_number=1, status=passed, session_percentage=85.00, createdAt=1577542344, updatedAt=1577542344, created_by=admin@simplilearn.com, updated_by=admin@simplilearn.com}}";
		
		String regex = "session_percentage=[\\d]+.[\\d]*";
		Pattern pat = Pattern.compile(regex);
		Matcher match = pat.matcher(text);
		
		List<String> matches = new ArrayList<String>();
		
		while(match.find())
		{
			//System.out.println(match.group(0));
			matches.add(match.group(0)); //for each match put in list
			
		}

		for(String result : matches)
		{
			System.out.println(result);
		}
	}

}
