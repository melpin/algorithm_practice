import java.util.Arrays;
import java.util.Scanner;

public class 실버2_섬의개수 {
	static int W;
	static int H;
	static int[][] map;

	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static boolean rangecheck(int i, int j) {
		if (0 <= i && i < H && 0 <= j && j < W)
			return true;
		return false;
	}

	static void deletemap(int i, int j) {
		int tmpi = 0;
		int tmpj = 0;
		for (int d = 0; d < 8; d++) {
			tmpi = i + dr[d];
			tmpj = j + dc[d];
			if (rangecheck(tmpi, tmpj) && map[tmpi][tmpj] == 1) {
				map[tmpi][tmpj] = 0;
				deletemap(tmpi, tmpj);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			W = sc.nextInt();
			H = sc.nextInt();
			if (W == 0 && H == 0)
				break;
			map = new int[H][W];

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1) {
						cnt++;
						map[i][j] = 0;
						deletemap(i, j);
					}
				}
			}

			System.out.println(cnt);
		}
	}

}
