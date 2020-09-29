package Exam;

import java.util.ArrayList;

public class KAKAO_2021_BLINDTEST_03 {
	public static int N;
	public static void main(String[] args) {
		String[] info = {
				"java backend junior pizza 150",
				"python frontend senior chicken 210",
				"python frontend senior chicken 150",
				"cpp backend senior pizza 260",
				"java backend junior chicken 80",
				"python backend senior chicken 50"
		};
		String[] query = {
				"java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250",
				"- and backend and senior and - 150",
				"- and - and - and chicken 100",
				"- and - and - and - 150"
		};

		solution(info, query);
	}

	public static int[] solution(String[] info, String[] query) {
		N = info.length;
        int[] answer = new int[query.length];
        ArrayList<Apply> arr = new ArrayList<>();
        for(String s : info) {
        	String lang = s.split(" ")[0];
        	String occu = s.split(" ")[1];
        	String carrer = s.split(" ")[2];
        	String food = s.split(" ")[3];
        	int score = Integer.parseInt(s.split(" ")[4]);
        	
        	Apply man = new Apply(lang, occu, carrer, food, score);
        	arr.add(man);
        }
        
        for(int i=0; i<query.length; i++) {
        	String lang = query[i].split(" and ")[0];
        	String occu = query[i].split(" and ")[1];
        	String carrer = query[i].split(" and ")[2];
    		String food = query[i].split(" and ")[3].split(" ")[0];
    		int score = Integer.parseInt(query[i].split(" and ")[3].split(" ")[1]);
    		
    		answer[i] = check(arr, new Apply(lang, occu, carrer, food, score));
        }
        	
        return answer;
    }
	
	public static int check(ArrayList<Apply> arr, Apply chk) {
		int answer = 0;
		for(int i=0; i<N; i++) {
			boolean bool = false;
			String lang = arr.get(i).lang;
        	String occu = arr.get(i).occu;
        	String carrer = arr.get(i).carrer;
        	String food = arr.get(i).food;
        	int score = arr.get(i).score;
        	
        	if((chk.lang.equals(lang) || chk.lang.equals("-")) && (chk.occu.equals(occu) || chk.occu.equals("-")) &&  
        			(chk.carrer.equals(carrer) || chk.carrer.equals("-")) && (chk.food.equals(food) || chk.food.equals("-")) &&
        			chk.score<=score) {
        		answer ++;
        	}
        	
		}
		
		return answer;
	}
	
	public static class Apply{
		String lang;
		String occu;
		String carrer;
		String food;
		int score;
		
		public Apply(String lang, String occu, String carrer, String food, int score) {
			this.lang = lang;
			this.occu = occu;
			this.carrer = carrer;
			this.food = food;
			this.score = score;
		}
	}

}
