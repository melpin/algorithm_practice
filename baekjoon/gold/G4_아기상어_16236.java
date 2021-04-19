package _0416;

import java.util.PriorityQueue;
import java.util.Scanner;

public class G4_아기상어_16236 {
	static int N;
	static int sharkr;
	static int sharkc;
	static int sharksize;
	static int eat;
	static int move;
	static int[][] map;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };
	
	static class fish implements Comparable<fish>{
		int r;
		int c;
		int dis;
		fish(int r,int c,int dis){
			this.r=r;
			this.c=c;
			this.dis=dis;
		}
		
		@Override
		public int compareTo(fish o) {
			if(this.dis == o.dis) {
				if(this.r == o.r) {
					return this.c - o.c;
				}else {
					return this.r - o.r;
				}
			}
			return this.dis - o.dis;
		}
	}

	static boolean range(int r,int c) {
		if(0<= r && r < N &&0<= c && c < N )
			return true;
		return false;
	}
	static boolean pqbfs() {
		boolean [][]visited = new boolean[N][N];
		PriorityQueue<fish> pq = new PriorityQueue<>();
		pq.add(new fish(sharkr, sharkc, 0));
		visited[sharkr][sharkc] = true;
		
		while (!pq.isEmpty()) {
			fish current = pq.poll();
			if( !(current.r == sharkr && current.c == sharkc) && map[current.r][current.c] != 0 &&map[current.r][current.c]< sharksize) {
				move += current.dis;
				sharkr = current.r;
				sharkc = current.c;
				map[current.r][current.c] = 0;
				eat++;
				if(eat == sharksize) {
					sharksize++;
					eat = 0;
				}
				return true;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = current.r+dr[d];
				int nc = current.c+dc[d];
				if(range(nr,nc) && !visited[nr][nc] && map[nr][nc] <= sharksize){
					visited[nr][nc] = true;
					pq.add(new fish(nr,nc, current.dis+1));
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					map[i][j] = 0;
					sharkr = i;
					sharkc = j;
					sharksize = 2;
				}
			}
		}
		while(pqbfs());
		System.out.println(move);
	}
}
