package Exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pro02 {
	public static void main(String[] args) {
		long n = 10;
		solution(n);
	}
	
	public static long solution(long n) {
        long answer = 0;
        List<Long> third = new ArrayList<>();
        List<Long> list = new ArrayList<>();
        List<Double> bList = new ArrayList<>();
        
        //3의 거듭제곱을 list에
        long mNum=0;
        double b = 0;
        while(mNum < (long)Math.pow(10, 10)) {
        	bList.add(b);
        	mNum = (long)(Math.pow(3, b));
        	list.add(mNum);
        	third.add(mNum);
        	b++;
        }
		
		
		for(int i=0; i<bList.size(); i++) { 
			System.out.println(bList.get(i)); 
		}
		 
		 
        // 더하기 두번
        for(int i=0; i<bList.size(); i++) {
        	for(int j=i+1; j<bList.size(); j++) {
        		long ins = (long)(Math.pow(3, bList.get(i))) + (long)(Math.pow(3, bList.get(j)));
        		list.add(ins);
        		
        	}
        }
        
        long ins = (long)(Math.pow(3, bList.get(0))) + (long)(Math.pow(3, bList.get(1)));
        
        for(int i=2; i<bList.size(); i++) {
        	
    		ins = ins + (long)(Math.pow(3, bList.get(i)));
    		list.add(ins);
        }
        
        Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i)); 
		}
		 
        
        answer = list.get((int)n-1);
        System.out.println(answer);
        return answer;
    }

}
