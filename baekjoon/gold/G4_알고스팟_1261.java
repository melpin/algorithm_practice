package _0426;

import java.util.PriorityQueue;
import java.util.Scanner;

public class G4_알고스팟_1261 {
	static int N, M;
	static int[][] map;
	static int[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static class state implements Comparable<state>{
		int r, c;
		int cnt;
		int bc;
		state(int r,int c, int cnt, int bc){
			this.r = r;
			this.c =c;
			this.cnt = cnt;
			this.bc =bc;
		}
		@Override
		public int compareTo(state o) {
			return Integer.compare(this.bc, o.bc);
		}
		
	}
	
	static boolean range(int r,int c) {
		if(0<= r && r < N && 0<= c && c < M)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		visited = new int[N][M];
		for(int i =0; i < N; i++) {
			String s=sc.next();
			for(int j =0; j < M; j++) {
				map[i][j] = s.charAt(j) -'0';
				visited[i][j] = 9999;
			}
		}
		PriorityQueue<state> q = new PriorityQueue<>();
		q.add(new state(0,0,0,0));
		visited[0][0] = 0;
		int ans = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			state current = q.poll();
			
			if(current.r == N-1 && current.c == M-1) {
				ans = Integer.min(ans, current.bc);
				break;
			}
			
			for(int d= 0; d< 4; d++) {
				int nr = current.r+dr[d];
				int nc = current.c+dc[d];
				if(range(nr,nc)) {
					if(visited[nr][nc] > current.cnt+1){
						if(map[nr][nc]== 0) {
							visited[nr][nc] = current.cnt+1;
							q.add(new state(nr,nc,current.cnt+1,current.bc));
						}else {
							visited[nr][nc] = current.cnt+1;
							q.add(new state(nr,nc,current.cnt+1,current.bc+1));
						}
						//지금 상태보다 늦게 도착했다면 할필요가없음
					}
				}
			}
		}
		System.out.println(ans);
	}
}
