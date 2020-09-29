package Exam;

public class SIbil_01 {

	public static void main(String[] args) {
		String S = "baaa";
		solution(S);
	}
	
	public static int solution(String S) {
		int cnt = 0, answer = 0;
		String check = "";
		char[] c = S.toCharArray();
		int left=0, right=1, con=0;
		//System.out.println(c.length);
		if(c[0] !='a') answer +=2;
		if(c[c.length-1] != 'a') answer +=2;
		while(true) {
			if(right>=c.length) break;
			
			if(con==-1 && c[right] =='a') return -1;
			
			if(c[left]=='a' && c[right] =='a') {
				left++;
				right++;
				con = -1;
				continue;
			}else if(c[left]=='a' && c[right]!='a'){
				left++;
				right++;
				//answer++;
				con = 0;
				continue;
			}else if(c[left]!='a' && c[right]=='a'){
				left++;
				right++;
				answer++;
				con = 0;
				continue;
			}else if(c[left]!='a' && c[right]!='a'){
				left++;
				right++;
				answer+=2;
				con = 0;
				continue;
			}
		}
		
		System.out.println(answer);
		return answer;
	}

}
