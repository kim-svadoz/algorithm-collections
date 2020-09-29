package Exam;

public class Ahn01 {

	public static void main(String[] args) {
		String[] words = {
				"aeiou", "asdfgh", "yakkke", "abfedc", "xyzabc", "qwertyuiop"
		};
		solution(words);
	}
	
	public static int[] solution(String[] words) {
		int len = words.length;
		int[] answer = new int[len];
		for (int i=0; i<len; i++) {
			answer[i] += check(words[i], 0, 0, 0, 0, 0);
			System.out.println(answer[i]);
		}
		return answer;
	}
	
	public static int check(String mStr, int num, int cnt1, int cnt2, int cnt3, int cnt4) {
		String[] str = mStr.split("");
		
		
		if(cnt1 >=4 || cnt2 >=4 ) return 0;
		if(str[num].equals("a") || str[num].equals("i") || str[num].equals("e") || str[num].equals("o") || str[num].equals("u")) {
			cnt2 = 0;
			cnt3 = 0;
			cnt4 = 0;
			cnt1 ++;	// 모음
			check(mStr, num+1, cnt1, cnt2, cnt3, cnt4);
		} else {
			cnt1 = 0;
			cnt3 = 0;
			cnt4 =0;
			cnt2 ++; 	// 자음
			check(mStr, num+1, cnt1, cnt2, cnt3, cnt4);
		}
		
		if(num > 1) {
			if(str[num].equals(str[num-1])) {
				cnt1 = 0;
				cnt2 = 0;
				cnt4 = 0;
				cnt3 ++;
				check(mStr, num+1, cnt1, cnt2, cnt3, cnt4);
			}
			int a = ((int)str[num].toCharArray()[0]-64);
			int b = ((int)str[num-1].toCharArray()[0]-64);
			if(Math.abs(a-b) == 1) {
				cnt1 = 0;
				cnt2 = 0;
				cnt3 = 0;
				cnt4 ++;
				check(mStr, num+1, cnt1, cnt2, cnt3, cnt4);
			}
		}
		
		//check(str, num+1, cnt1, cnt2, cnt3, cnt4);
		
		return 1;
	}

}
