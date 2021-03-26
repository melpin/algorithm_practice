package others;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G4_벽부수고이동하기_2206 {
	static int N, M, ans;
	static int[][] map;
	static int[][][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<pos> q;

	static boolean range(int r, int c) {
		if (0 <= r && r < N && 0 <= c && c < M)
			return true;
		return false;
	}

	static class pos {
		int r;
		int c;
		int breakb;

		pos(int r, int c, int breakb) {
			this.r = r;
			this.c = c;
			this.breakb = breakb;
		}
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			pos current = q.poll();
			if(current.r == N-1 && current.c == M-1) {
				ans = visited[current.breakb][current.r][current.c];
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = current.r + dr[d];
				int nc = current.c + dc[d];

				if (range(nr, nc) && visited[current.breakb][nr][nc] == 0){
					if (map[nr][nc] == 0) {
						visited[current.breakb][nr][nc] = visited[current.breakb][current.r][current.c] + 1;
						q.add(new pos(nr,nc,current.breakb));
						// go
					} else if (map[nr][nc] == 1 && current.breakb == 1){
						// break and go
						visited[0][nr][nc] = visited[current.breakb][current.r][current.c] + 1;
						q.add(new pos(nr,nc,0));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new int[2][N][M];
		ans = Integer.MAX_VALUE;
		q = new LinkedList<pos>();

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		visited[1][0][0] = 1;
		q.add(new pos(0,0,1));
		bfs();
		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
}
