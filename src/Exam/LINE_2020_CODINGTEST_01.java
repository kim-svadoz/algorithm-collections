package Exam;

import java.util.*;

public class LINE_2020_CODINGTEST_01 {

	public static void main(String[] args) {
		int[][] boxes = {
				{1, 2},
				{2, 1},
				{3, 3},
				{4, 5},
				{5, 6},
				{7, 8},
		};
		solution(boxes);
	}
	
	public static int solution(int[][] boxes) {
		int N = boxes.length;
        int answer = N;
        // ÃÑ Â¦ ¸ÂÃç¾ß ÇÏ´Â ¹Ú½ºÀÇ °¹¼ö
        ArrayList<Integer> arr = new ArrayList<>();
        int[][] myBoxes = new int[N][2];
        
        for(int i=0; i<N; i++) {
        	if(boxes[i][0]==i+1 && boxes[i][1]==i+1) {
        		myBoxes[i][0]=i+1;
        		myBoxes[i][1]=i+1;
        	}
        	myBoxes[i][0] = -1;
        	myBoxes[i][1] = -1;
        	
        	int tmp = -2;
        	if((boxes[i][0]==i+1 && boxes[i][1]!=i+1) || (boxes[i][0]!=i+1 && boxes[i][1]==i+1)) {
        		if(boxes[i][0]!=i+1) {
        			tmp = boxes[i][0];
        		}else {
        			tmp = boxes[i][1];
        		}
        		
        		for(int j=i+1; j<N; j++) {
        			if(boxes[j][0]==tmp || boxes[j][1] == tmp) {
        				myBoxes[i][0] = i+1;
        				myBoxes[i][1] = i+1;
        				if(boxes[j][0]==tmp) {
        					boxes[j][0] = tmp; 
        				}else {
        					boxes[j][1] = tmp;
        				}
        				continue;
        			}
        		}
        	}
        }
        
        for(int i=0; i<N; i++) {
        	if(myBoxes[i][0]==i+1 && myBoxes[i][1]==i+1) {
        		System.out.println();
        	}else {
        		answer--;
        	}
        }
        System.out.println(answer);
        return answer;
    }
	
	

}
