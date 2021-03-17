package _0315;

import java.util.Scanner;

public class SWE_등산로조성 {
	static int N;
	static int K;
	static int[][] map;
	static boolean [][] visit;
	static int ans;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static boolean range(int i, int j) {
		if (0 <= i && i < N && 0 <= j && j < N)
			return true;
		return false;
	}


	static void dfs(int i, int j, int depth, boolean candig) {
		if(ans < depth)
			ans = depth;
		
		for (int d = 0; d < 4; d++) {
			int ni = i + dr[d];
			int nj = j + dc[d];

			if (range(ni, nj) && !visit[ni][nj]) {
				visit[ni][nj] = true;
				if (map[ni][nj] < map[i][j]) {
					dfs(ni, nj, depth + 1, candig);
				}else if(candig && map[ni][nj] - map[i][j] +1<= K){
					int tmp = map[ni][nj];
					map[ni][nj] = map[i][j] - 1;
					dfs(ni, nj, depth + 1, false);
					map[ni][nj] = tmp;
				}
				visit[ni][nj] = false;
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			visit = new boolean[N][N];
			ans = 0;

			int maxheight = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					maxheight = Integer.max(maxheight, map[i][j]);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == maxheight) {
						visit[i][j] = true;
						dfs(i, j ,1, true);
						visit[i][j] = false;
					}
				}
			}
			

			System.out.printf("#%d %d\n", tc, ans);
		}

	}

}
