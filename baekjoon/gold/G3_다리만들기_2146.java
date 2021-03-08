package _0308;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G3_다리만들기_2146 {

	static int[][][] map;
	static int N;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int ans;

	static boolean range(int i, int j) {
		if (0 <= i && i < N && 0 <= j && j < N)
			return true;
		return false;
	}

	static void landMarking(int landNum, int i, int j) {
		for (int d = 0; d < 4; d++) {
			int nexti = i + dr[d];
			int nextj = j + dc[d];
			if (range(nexti, nextj) && map[nexti][nextj][0] == 1) {
				map[nexti][nextj][0] = landNum;
				landMarking(landNum, nexti, nextj);
			}
		}
	}

	// BFS Queue
	static class pos {
		int i;
		int j;

		pos(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static Queue<pos> q;

	static void extendLand() {
		while (!q.isEmpty()) {
			pos currentpos = q.poll();
			for (int d = 0; d < 4; d++) {
				int nexti = currentpos.i + dr[d];
				int nextj = currentpos.j + dc[d];
				if (range(nexti, nextj) && map[nexti][nextj][0] == 0) {
					map[nexti][nextj][0] = map[currentpos.i][currentpos.j][0];
					map[nexti][nextj][1] = map[currentpos.i][currentpos.j][1] + 1;
					q.add(new pos(nexti, nextj));
				} else if (range(nexti, nextj) && map[nexti][nextj][0] != map[currentpos.i][currentpos.j][0]) {
					ans = Integer.min(ans, map[nexti][nextj][1] + map[currentpos.i][currentpos.j][1]);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N][2]; // 0 map info, 1 map extend level
		ans = Integer.MAX_VALUE;
		q = new LinkedList<pos>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j][0] = sc.nextInt();
			}
		}

		int landNum = 2; // 1 alread exist
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j][0] == 1) {
					map[i][j][0] = landNum;
					landMarking(landNum++, i, j);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j][0] != 0) {
					q.add(new pos(i, j));
				}
			}
		}
		extendLand();

		System.out.println(ans);
	}
}
