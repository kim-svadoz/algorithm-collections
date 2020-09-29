package Exam;

import java.util.ArrayList;

public class Ebay02 {
	public static int answer = 0;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		int num = 8;
		int[] cards = {1, 4, 6};
		solution(num, cards);
	}
	
	public static int solution(int num, int[] cards) {
		int len = cards.length;
		int cnt = 0;
		int min = solution2(cnt, len, num, cards);
		for(int i=0; i<len-1; i++) {
			min = Math.min(min, solution2(cnt, len, num, cards));
			cnt++;
		}
		System.out.println(min);
		return min;
	}
	
	public static int solution2(int cnt, int len, int num, int[] cards) {
		answer = answer + num/cards[len-cnt];
		int cal = num%cards[len-cnt];
		if(cnt > len) return -1;
		else if(cal == 0 ) {
			return answer;
		}
		else {
			solution2(cnt+1, len, cal, cards);
		}
		return answer;
	}
}
