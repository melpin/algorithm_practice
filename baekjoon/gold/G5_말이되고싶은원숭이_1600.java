package others;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G5_말이되고싶은원숭이_1600 {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] hdr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] hdc = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int H, W;

	static class pos {
		int r;
		int c;
		int jump;

		pos(int r, int c, int jump) {
			this.r = r;
			this.c = c;
			this.jump = jump;
		}
	}

	static boolean range(int r, int c) {
		if (0 <= r && r < H && 0 <= c && c < W)
			return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		int[][] map = new int[H][W];
		int[][][] visit = new int[H][W][K + 1];
		Queue<pos> q = new LinkedList<pos>();
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		q.add(new pos(0, 0, 0));

		while (!q.isEmpty()) {
			pos current = q.poll();

			if (current.r == H - 1 && current.c == W - 1) {
				ans = visit[current.r][current.c][current.jump];
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = current.r + dr[d];
				int nc = current.c + dc[d];
				if (range(nr, nc) && map[nr][nc] == 0 && visit[nr][nc][current.jump] == 0) {
					visit[nr][nc][current.jump] = visit[current.r][current.c][current.jump] + 1;
					q.add(new pos(nr, nc, current.jump));
				}
			}
			if (current.jump < K) {
				for (int d = 0; d < 8; d++) {
					int nr = current.r + hdr[d];
					int nc = current.c + hdc[d];
					if (range(nr, nc) && map[nr][nc] == 0 && visit[nr][nc][current.jump + 1] == 0) {
						visit[nr][nc][current.jump + 1] = visit[current.r][current.c][current.jump] + 1;
						q.add(new pos(nr, nc, current.jump + 1));
					}
				}
			}
		}
		if(ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
}
