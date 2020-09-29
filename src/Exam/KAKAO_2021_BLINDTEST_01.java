package Exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KAKAO_2021_BLINDTEST_01 {

	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		solution(new_id);
	}
	
	public static String solution(String new_id) {
        String answer = "";
        
        answer = new_id.toLowerCase();
        Pattern pt = Pattern.compile("[^a-z0-9._-]");
        Matcher match = pt.matcher(answer);
        
        while(match.find()) {
        	String s = match.group();
        	answer = answer.replaceAll("\\"+s, "");
        }
        System.out.println(answer);
        
        Pattern pt2 = Pattern.compile("[^.]{2,}");
        Matcher match2 = pt2.matcher(answer);
        while(match2.find()) {
        	String s = match2.group();
        	answer = answer.replaceAll("\\"+s, "");
        }
        
        System.out.println(answer);
        
        return answer;
    }

}
