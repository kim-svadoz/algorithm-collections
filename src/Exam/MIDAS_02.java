package Exam;

public class MIDAS_02 {

	public static void main(String[] args) {
		int x = -1;
		int y = 2;
		int r = 2;
		int d = 60;
		int[][] target = {
				{0,1},
				{-1,1},
				{1,0},
				{-2,2}
		};
			
		solution(x, y, r, d, target);
	}
	
	public static int solution(int x, int y, int r, int d, int[][] target) {
		int len = target.length;
		int cnt=0;
		double ang1 = (180*Math.atan2(y,x)/Math.PI)-d;
		double ang2 = (180*Math.atan2(y,x)/Math.PI)+d;
		
		for(int i=0; i<len; i++) {
			int dx = target[i][0];
			int dy = target[i][1];
			double dAngle = 180*Math.atan2(dy, dx)/Math.PI;
			if((int)dAngle>=(int)ang1 && (int)dAngle<=(int)ang2) {
				if(calDistance(dx, dy)<=r) {
					System.out.println(dx+", "+dy);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		return cnt;
	}
	
	public static double calDistance(int x, int y) {
		
		double distance = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
		
		return distance;
	}
	
	

}
