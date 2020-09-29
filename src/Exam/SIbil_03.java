package Exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SIbil_03 {

	public static void main(String[] args) {
		int[] A = {
				4, 2, 1, 3
		};
		solution(A);
	}
	// 1 1 2
	// 에서 1을 먼저 꺼내서
	public static int solution(int[] A) {
		int answer = 0;
		List<Integer> list = new ArrayList<>();
		int a = 0;
		for(int i=0; i<A.length; i++) {
			for(int j=i+1; j<A.length; j++) {
				if(A[i] == A[j]) {
					if(!list.contains(A[i])) list.add(A[i]);
				}
			}
		}
		int min=0, max=0;
		Arrays.sort(A);
		min = A[0];
		max = A[A.length-1];
		Collections.reverse(list);
		for(int num : list) {
			int chk = num;
			if(num <= min) {
				for(int i=0; i<A.length; i++) {
					if(chk==A[i]) {
						answer++;
						chk++;
					}
				}
			}else if(num > min) {
				for(int i=A.length-1; i>=0; i--) {
					if(chk==A[i]) {
						answer++;
						chk--;
					}
				}
			}
		}
		System.out.println(answer);
		return answer;
	}

}
