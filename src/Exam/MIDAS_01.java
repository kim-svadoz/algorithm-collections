package Exam;

public class MIDAS_01 {

	public static void main(String[] args) {
		String[] strs = {
				"abcaefg",
				"abcdefg",
				"abcdhfg"
		};
		solution(strs);
	}
	
	public static String solution(String[] strs) {
		String answer = "";
		char tmp;
		int size = strs.length;
		int cnt = 0;
		
		for(int i=0; i<strs[0].length(); i++) {
			tmp = strs[0].charAt(i);
			for(int j=1; j<size; j++) {
				if(tmp==strs[j].charAt(i)) {
					answer += tmp;
					break;
				}else {
					System.out.println(answer);
					return answer;
				}
			}
		}
		return answer;
	}

}
