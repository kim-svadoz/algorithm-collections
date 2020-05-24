package Exam;

import java.util.LinkedList;
import java.util.Queue;

public class MIDAS_03 {
	public static int[][] map, copymap;
	public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static boolean[][] visited;
    public static int n, m, rx, ry, cnt;
    public static Queue<Pair> q = new LinkedList<>();
	public static class Pair{
		int rx, ry, score;
		public Pair(int rx, int ry, int score) {
			this.rx = rx; //За
			this.ry = ry; //ї­
			this.score = score;
		}
	}
	
	public static void main(String[] args) {
		int[][] board = {
				{1,1,3,3},
				{4,1,3,4},
				{1,2,1,1},
				{2,1,3,2}
		};
		
		bfs(board);
	}
	
	public static int bfs(int[][] board) {
		int ans = 0;
		n = board.length;
		m = board[0].length;
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		q.add(new Pair(0, 0, 0));
		visited[0][0] = true;
		while(!q.isEmpty()) {
			copymap = new int[n][m];
			copymap = map;
			
			Pair p = q.poll();
			if(copymap[rx][ry]==4) return p.score;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(p.rx==0) {
						copymap[p.rx][p.ry] = 0;
					}else if(p.rx==1) {
						copymap[p.rx][p.ry] = 0;
						copymap[p.rx][p.ry] = map[p.rx-1][p.ry];
					}else if(p.rx==2) {
						copymap[p.rx][p.ry] = 0;
						copymap[p.rx][p.ry] = map[p.rx-1][p.ry];
						copymap[p.rx-1][p.ry] = map[p.rx-2][p.ry];
					}else if(p.rx==3) {
						copymap[p.rx][p.ry] = 0;
						copymap[p.rx][p.ry] = map[p.rx-1][p.ry];
						copymap[p.rx-1][p.ry] = map[p.rx-2][p.ry];
						copymap[p.rx-2][p.ry] = map[p.rx-3][p.ry];
					}
					System.out.print(copymap[i][j]);
				}
				System.out.println();
			}
			
			dfs(p);
			
			if(!visited[p.rx+1][p.ry]) {
				
				if(rx+1>m) {
					visited[p.rx+1][p.ry] = true;
					q.add(new Pair(p.rx+1, p.ry, 0));
				}
				visited[p.rx][p.ry+1] = true;
				q.add(new Pair(p.rx, p.ry+1, 0));
			}
			
			ans = Math.max(cnt+1, Integer.MIN_VALUE);
		} // end while
		System.out.println("answ==>> "+ans);
		return ans;
	} //end bfs
	
	public static void dfs(Pair p) {
		int x = p.rx;
		int y = p.ry;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && ny>=0 && nx<n && ny<m) {
				if(copymap[nx][ny]==copymap[x][y]) {
					cnt++;
					dfs(new Pair(nx, ny, cnt));
				}else {
					return;
				}
			}
		}
	}
	

}
