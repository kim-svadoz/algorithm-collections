package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class kakaoEnter_03 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken()); // 생산된 과자 갯수
		int K = Integer.parseInt(st.nextToken()); // 가공 후 완료되어야하는 과자 갯수
		ArrayList<Float> snackArr = new ArrayList<Float>();
		ArrayList<Double> possiNum = new ArrayList<Double>();
		Double num = 0.0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			float input = Float.parseFloat(st.nextToken());
			snackArr.add(input);
			num += snackArr.get(i);
		}
		double mNum = (num/K);
		double checkNum = (Math.round(mNum*100)/100.0);
		
		for(int i=0; i<snackArr.size(); i++) {
			double number = Math.round(((Math.round(snackArr.get(i)*100)/100.0) / N) *100)/100.0;
			if(number<checkNum) {
				possiNum.add(number);
			}
		}
		Collections.sort(possiNum);
		System.out.println(possiNum.get(possiNum.size()-1));
	}

}
