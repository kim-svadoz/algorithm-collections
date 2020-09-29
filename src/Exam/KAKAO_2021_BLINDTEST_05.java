package Exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KAKAO_2021_BLINDTEST_05 {
	public static int N = 0;
	public static void main(String[] args) {
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = {
				"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"
		};
		solution(play_time, adv_time, logs);
	}
	
	public static String solution(String play_time, String adv_time, String[] logs) {
		String answer ="";
		if(play_time.equals(adv_time)) return "00:00:00";
		
		N = changeSecond(play_time);
		int[] check = new int[N+1];
		Arrays.fill(check, 0);
		for(int i=0; i<logs.length; i++) {
			String startStr = logs[i].split("-")[0];
			String endStr = logs[i].split("-")[1];
			int start = changeSecond(startStr);
			int end = changeSecond(endStr);
			
			for(int j=start+1; j<=end; j++) {
				check[j] ++;
			}
		}
		
		int max = 0;
		for(int num : check) {
			max = Math.max(num, max);
		}
		//System.out.println(max);
		
		ArrayList<Integer> aL = new ArrayList<>();
		for(int i=0; i<check.length; i++) {
			if(check[i] == max) {
				aL.add(i);
			}
		}
		
		Collections.sort(aL);
		//System.out.println("중복이 가장 많은 첫째 상영 시간 :"+aL.get(0)+"초 째");
		
		int adv = changeSecond(adv_time);
		//System.out.println("adv time :" + adv+"초");
		int res = aL.get(0) - (adv/2);
		
		int ans = 0;
		for(int i=0; i<check.length; i++) {
			if(i >= res && i < res+adv ) {
				if(check[i] == max-1 || check[i] == max) {
					ans = i-1;
					break;
				}
			}
		}
		//System.out.println(ans);
		
        int min = (ans % 3600) / 60;
        int hour = ans / 3600;
        int sec = ans % 60;
        
        String minS = String.valueOf(min);
        String hourS = String.valueOf(hour);
        String secS = String.valueOf(sec);
        
        if(hourS.length()==1) {
        	hourS = "0"+hourS;
        }
        if(minS.length()==1) {
        	minS = "0"+minS;
        }
        if(secS.length()==1) {
        	secS = "0"+secS;
        }
        answer = hourS+":"+minS+":"+secS;
        System.out.println(answer);
        return answer;
    }
	public static int changeSecond(String time) {
		int answer = 0;
		String[] Ss = time.split(":");
		
		for(int i=0; i<Ss.length; i++) {
			if(i==0) {
				answer += Integer.parseInt(Ss[i]) * 3600;
			}else if(i==1) {
				answer += Integer.parseInt(Ss[i]) * 60;
			}else {
				answer += Integer.parseInt(Ss[i]);
			}
		}
		
		return answer;
	}
}
