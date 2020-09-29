package Exam;

import java.util.*;

public class LINE_2020_CODINGTEST_04 {
	public static int N;
	public static int[][] map;
	public static int[] dirX = {0, 1, 2, 3}; // 0:북 , 1:동, 2:남, 3:서
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
		int x, y, dir, time;	// q에서 꺼낸 x,y 좌표와 dir,time
		int nx, ny, ndir;		// 이동 후 가지게 될 위치 및 방향
		int rx, ry;		// 회전할 때 판단해야할 방향
		
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			x = pair.x;
			y = pair.y;
			dir = pair.dir;
			time = pair.time;
			
			if(isFinish(x, y)) {
				System.out.println(time);
				return time;	// 도착하면 time 리턴
			}
			
			//왼쪽 방향 이라는 거는 dir에서 -90도 한 곳이 벽인지 체크하면 된다. 지금은 2이므로 동쪽을 체크하면된다. 3이면 남쪽,, 0이면 서쪽,, 1이면 북쪽 
			for(int i=0; i<4; i++) {	//동서남북
				nx = x + dx[i];
				ny = y + dy[i];
				
				if(!isValid(nx, ny)) continue;
				if(map[nx][ny] !=1) continue;
				if(visit[nx][ny][dir]) continue;	//이미방문?
				
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
				if(visit[nx][ny][ndir]) continue;	//이미방문?
				
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
