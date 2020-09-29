package Exam;

import java.util.*;

public class LINE_2020_CODINGTEST_04 {
	public static int N;
	public static int[][] map;
	public static int[] dirX = {0, 1, 2, 3}; // 0:�� , 1:��, 2:��, 3:��
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		int[][] maze = {
					{0, 1, 0, 1},
					{0, 1, 0, 0}, 
					{0, 0, 0, 0},
					{1, 0, 1, 0}
				};
		solution(maze);
	}
	
	public static int solution(int[][] maze) {
        int answer = 0;
        map = maze;
        N = maze.length;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 2, 0));
        boolean[][][] visit = new boolean[N][N][4];
        
        return bfs(q, visit);
    }
	
	public static int bfs(Queue<Pair> q, boolean[][][] visit) {
		int x, y, dir, time;	// q���� ���� x,y ��ǥ�� dir,time
		int nx, ny, ndir;		// �̵� �� ������ �� ��ġ �� ����
		int rx, ry;		// ȸ���� �� �Ǵ��ؾ��� ����
		
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			x = pair.x;
			y = pair.y;
			dir = pair.dir;
			time = pair.time;
			
			if(isFinish(x, y)) {
				System.out.println(time);
				return time;	// �����ϸ� time ����
			}
			
			//���� ���� �̶�� �Ŵ� dir���� -90�� �� ���� ������ üũ�ϸ� �ȴ�. ������ 2�̹Ƿ� ������ üũ�ϸ�ȴ�. 3�̸� ����,, 0�̸� ����,, 1�̸� ���� 
			for(int i=0; i<4; i++) {	//��������
				nx = x + dx[i];
				ny = y + dy[i];
				
				if(!isValid(nx, ny)) continue;
				if(map[nx][ny] !=1) continue;
				if(visit[nx][ny][dir]) continue;	//�̹̹湮?
				
				visit[nx][ny][dir] = true;
				q.add(new Pair(nx, ny, dir, time+1));
			}
			
			for(int i=1; i<4; i+=2) {
				ndir = (dir + i) % 4;
				nx = x + dx[ndir];
				ny = y + dy[ndir];
				
				int tempDir = (i==1) ? ndir : dir;
				
				if(!isValid(nx, ny)) continue;
				if(map[nx][ny] !=1) continue;
				if(visit[nx][ny][ndir]) continue;	//�̹̹湮?
				
				visit[nx][ny][ndir] = true;
				q.add(new Pair(nx, ny, ndir, time+1));
			}
		}
		
		return -1;
	}
	
	public static boolean isFinish(int x, int y) {
		return x==N-1 && y==N-1;
	}
	
	public static boolean isValid(int x, int y) {
		return x>=0 && y>=0 && x<N && y<N;
	}
	
	public static class Pair{
		int x, y;
		int dir;
		int time;
		
		public Pair(int x, int y, int dir, int time) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.time = time;
		}
	}
	

}
