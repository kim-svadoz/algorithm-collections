package Exam;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LINE_2020_CODINGTEST_02 {
	public static int len;
	public static List<Integer> temp;
	public static List<Integer> al;
	public static void main(String[] args) {
		int[] ball = {
				1, 2, 3, 4, 5, 6
		};
		int[] order = {
				6 ,2, 5, 1, 4, 3	
		};
		solution(ball, order);
	}
	
	public static int[] solution(int[] ball, int[] order) {
		int[] answer = new int[len];
        len = order.length;
        int start = ball[0];
        int end = ball[len-1];
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, end));
        
        return answer;
    }
	
	public static class Pair{
		int start, end;
		
		Pair(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	

}
