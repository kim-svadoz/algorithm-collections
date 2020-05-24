package Exam;

import java.util.ArrayList;

public class Pro01 {

	public static void main(String[] args) {
		int p = 1987;
		
		solution(p);
	}
	
	public static int solution(int p) {
		
        int answer = 0;
        String[] arr = ((p+"").split(""));
        int len = arr.length;
        
        answer = p+1;
        while(true) {
        	String[] cur = (answer+"").split("");
        	ArrayList<Integer> list = new ArrayList<>();
        	for(int i=0; i<cur.length; i++) {
        		for(int j=0; j<10; j++) {
        			if(!list.contains(j) && cur[i].equals(j+"")) {
        				list.add(j);
        			}
        		}
        	}
        	if(cur.length==list.size()) { 
        		break;
        	}else{
        		answer ++;
        	}
        }
        System.out.println(answer);
        return answer;
    }

}
