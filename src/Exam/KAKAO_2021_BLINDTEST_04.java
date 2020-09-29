package Exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KAKAO_2021_BLINDTEST_04 {
	public static int[] parent;
	public static int N, E;
	public static ArrayList<ArrayList<Node>> al; // 인접리스트
	public static int[] dist;	// 시작점에서 각 정점으로 가는 최단거리
	public static boolean[] check; 	// 방문 확인
	public static final int INF = 8000000;
	public static void main(String[] args) {
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares = {
				{4, 1, 10},
				{3, 5, 24},
				{5, 6, 2},
				{3, 1, 41},
				{5, 1, 24},
				{4, 6, 50},
				{2, 4, 66},
				{2, 3, 22},
				{1, 6, 25},
		};
		solution(n, s, a, b, fares);
	}
	
	public static int solution(int n, int s, int a, int b, int[][] fares) {
        //정점의 갯수
        N = n;
        //간선의 갯수
        E = fares.length;
        al = new ArrayList<>();
        dist = new int[N+1];
        check = new boolean[N+1];
        
        Arrays.fill(dist, INF);
        
        for(int i=0; i<=N; i++) {
        	al.add(new ArrayList<>());
        }
        
        //양방향 인접리스트 구현
        for(int i=0; i<E; i++) {
        	int start = fares[i][0];
        	int end = fares[i][1];
        	int cost = fares[i][2];
        	
        	//start에서 end로 가는 cost
        	al.get(start).add(new Node(end, cost));
        	
        	//end에서 start로 가는 cost
        	al.get(end).add(new Node(start, cost));
        }
        
        //반드시 거쳐야 하는 정점
        // s -> a -> b로 가는 경우
        int sa = 0;
        int res = 0;
        sa = dijkstra(s, a);
        res = sa + +dijkstra(a, b);
        
        // s -> b -> a로 가는 경우
        int sb = 0;
        int res2 = 0;
        sb = dijkstra(s, b);
        res2 = sb + dijkstra(b, a);
        
        int ans = (res >= INF && res2 >= INF) ? -1 : Math.min(res, res2);
        
        int self = sa + sb;
        ans = Math.min(ans, self);
        
        System.out.println(ans);
        return ans;
    }
	
	public static int dijkstra(int start, int end) {
		if(start == end) return 0;
		Arrays.fill(dist, INF);
		Arrays.fill(check, false);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[N + 1];
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end;
			if(cur==end) return dist[curNode.end];
			
			if(!check[cur]) {
				check[cur] = true;
				
				for (Node node : al.get(cur)) {
					if(!check[node.end] && dist[node.end] > dist[cur] + node.cost) {
						dist[node.end] = dist[cur] + node.cost;
						pq.add(new Node(node.end, dist[node.end]));
					}
				}
			}
		}
		
		return dist[end];
	}
	
	public static class Node implements Comparable<Node>{
		int end;
		int cost;
		
		Node(int end, int cost){
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
		
		
	}

}
