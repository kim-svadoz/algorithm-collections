package Exam;

import java.awt.List;
import java.util.ArrayList;

public class Ahn02 {

	public static void main(String[] args) {
		String block = ">><";
		int pos = 1;
		solution(block, pos);
	}
	
	public static long solution(String block, int pos) {
		long answer = 0;
		int len = block.length();
		boolean[] load = new boolean[len];
		int[] mPos = new int[len];
		
		
		pos = 1;
		for(int i=0; i<len; i++) {
			String str = block.split("")[i];
			if(str.equals(">")) {
				load[i] = true;
			} else {
				load[i] = false;
			}
		}
		
		while(pos>0 && pos<=len) {
			
		}
		return answer;
	}

}
