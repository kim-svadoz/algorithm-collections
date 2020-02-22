package baekjoon;

import java.util.Scanner;

public class danji_2667 {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int x= key.nextInt();
		int[][] dan = new int[x][x];
		for(int i=0; i<x; i++) {
			for(int j=0; j<x; j++) {
				dan[i][j] = key.nextInt();
			}
		}
		
		int cnt1 = 0;
		for(int i=0; i<x; i++) {
			for(int j=0; j<x; j++) {
				if(dan[i][j] == 1) {
					cnt1 ++;
					if(dan[i][j+1] == 1) {
						cnt1++;
					}else if(dan[i+1][j] == 1) {
						
					}
				}
			}
		}
		
	}
	
	public int solution(int x, int a, int b) {
		int count=0;
		int[][] dan = new int[x][x];
		if(dan[a][b] ==dan[a][b+1]) {
			
		}
		
		for(int i=0; i<x; i++) {
			for(int j=0; j<x; j++) {
				dan[a][b] = 
			}
		}
		return count;
	}
}
