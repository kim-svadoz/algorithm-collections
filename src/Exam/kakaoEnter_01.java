package Exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class kakaoEnter_01 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println("Hello Goorm! Your input is " + input);
		
		int cnt = 0;
		
		char[] strArr = input.split("").toString().toCharArray();
		ArrayList<String> check = new ArrayList<String>();
		ArrayList<Character> strArr2 = new ArrayList<Character>(); 
		for(char s : strArr) {
			System.out.print(s);
			strArr2.add(s);
		}
		
		for(int i=0; i<5; i++) {
			if(!strArr2.isEmpty()) {
				if(input.toUpperCase() == input) {
					String insert = "�빮��";
					if(!check.contains(insert)) check.add(insert);
				}else if(input.toLowerCase() == input) {
					String insert = "�ҹ���";
					if(!check.contains(insert)) check.add(insert);
				}else {
					String insert = "�빮��";
					String insert2 = "�ҹ���";
					if(!check.contains(insert)) check.add(insert);
					if(!check.contains(insert2)) check.add(insert2);
				}
			}
			
			if(input.length()>=10) {
				String insert = "10�ڸ� �̻�";
				if(!check.contains(insert)) check.add(insert);
			}
			String match = ".*[0-9].*";
			if(input.matches(match)) {
				String insert = "���� ����";
				if(!check.contains(insert)) check.add(insert);
			}
			String specialMatch = ".*\\W";
			if(input.matches(match)) {
				String insert = "Ư������ ����";
				if(!check.contains(insert)) check.add(insert);
			}
		}
		
		cnt = check.size();
		System.out.println("LEVEL"+cnt);
	}
}
