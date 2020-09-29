package Exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Ebay01 {

	public static void main(String[] args) {
		int N = 2;
		int[][] simulation_data = {
				{0, 3},
				{2, 5},
				{4, 2},
				{5, 3}
		};
		solution(N, simulation_data);
	}
	
	public static int solution(int N, int[][] simulation_data) {
		Queue<HashMap> q = new LinkedList<HashMap>();
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		ArrayList<Integer> li = new ArrayList<Integer>();
        int answer = 0;
        int clk = 0;
        int len = simulation_data.length;
		
		for (int i = 0; i < len; i++) {
			hash.put(simulation_data[i][0], simulation_data[i][1]);
			q.add(hash);
		}
		Set set = hash.keySet();
		Iterator iterator = set.iterator();
		
		while (!q.isEmpty()) {
			HashMap<Integer, Integer> h = q.remove();
			clk++;

			for (int i = 0; i < N; i++) {

			}
		}
		
		for(int i=0; i<len; i++) {
			
			while(q.size()<=2) {
				hash.put(simulation_data[i][0], simulation_data[i][1]);
				q.add(hash);
			}
			
			while(!q.isEmpty()) {
				
			}
		}
		
        
        return answer;
    }

}
