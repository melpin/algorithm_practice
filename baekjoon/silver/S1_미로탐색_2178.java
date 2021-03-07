package _0308;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1_미로탐색_2178 {
	static int M;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static boolean range(int i, int j) {
		if (0 <= i && i < N && 0 <= j && j < M)
			return true;
		return false;
	}

	static class pos {
		int i;
		int j;

		pos(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];

		Queue<pos> s = new LinkedList<pos>();

		for (int i = 0; i < N; i++) {
			String cs = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = cs.charAt(j)- '0';
			}
		}
		s.add(new pos(0, 0));
		visited[0][0] = true;

		while (!s.isEmpty()) {
			pos current = s.poll();
			for (int d = 0; d < 4; d++) {
				int tmpi = current.i + dr[d];
				int tmpj = current.j + dc[d];
				if (range(tmpi, tmpj) && !visited[tmpi][tmpj] && map[tmpi][tmpj] != 0) {
					map[tmpi][tmpj] = map[current.i][current.j] + 1;
					visited[tmpi][tmpj] = true;
					s.add(new pos(tmpi, tmpj));
				}
			}
		}

		System.out.println(map[N-1][M-1]);

	}

}
