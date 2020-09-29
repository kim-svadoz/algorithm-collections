package Exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KAKAO_2021_BLINDTEST_02 {

	public static void main(String[] args) {
		String[] orders = {
				"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
		};
		int[] course = {
				2,3,4
		};
		
		solution(orders, course);
	}
	
	public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> arr;
        for(int i=0; i<orders.length; i++) {
        	arr = new ArrayList<>();
        	arr.add(orders[i]);
    		map.put(orders[i].length(), arr); // key : 주문의 갯수 , value : Menu(주문한 사람, 주문한 음식)
        }
        
        for(int i=0; i<course.length; i++) {
        	// 요래 n개 코스
        	int n = course[i];
        	
        	// n개 짜리 시킨 사람이 있는지 확인
        	if(map.containsKey(n)) {
        		for(int j=0; j<map.get(n).size(); j++) {
        			String food = map.get(n).get(j);
        			System.out.println(food);
        		}
        	}
        	
        }
        
        return answer;
    }

}
