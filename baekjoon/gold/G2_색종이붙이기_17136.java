import java.util.Scanner;

public class G2_색종이붙이기_17136 {
	static int[][] map;
	static int[] Cpaper = { 0, 5, 5, 5, 5, 5 };
	static int mincnt = 30;
	static int cnt;
	static int target;
	static int anslevel;

	static boolean iscover(int i, int j, int range) {
		if (Cpaper[range] <= 0)
			return false;
		for (int ci = i; ci < i + range; ci++) {
			for (int cj = j; cj < j + range; cj++) {
				if (ci >= 10 || cj >= 10 || map[ci][cj] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	static void DoCover(int i, int j, int range, int val) {
		for (int ci = i; ci < 10 && ci < i + range; ci++) {
			for (int cj = j; cj < 10 && cj < j + range; cj++) {
				map[ci][cj] = val;
			}
		}
	}

	static void search(int r, int c, int level, int currentPaper) {
		if (anslevel < level) {
			return;
		}
		if (target < currentPaper) {
			return;
		} else if (target == currentPaper) {
			mincnt = Integer.min(mincnt, cnt);
			anslevel = Integer.min(anslevel, level);
		}
		if(r >= 10)
			return;

		// 이미 갯수를 너무많이썻거나
		// 남은색종이로 가릴수가없거나
		// 너무 깊이온경우

		if (map[r][c] == 1) {
			for (int n = 5; n > 0; n--) {
				if (iscover(r, c, n)) {
					DoCover(r, c, n, 3);
					Cpaper[n]--;
					cnt++;
					search(r + ((c + 1) / 10), (c + 1) % 10, level + 1, currentPaper + n * n);
					cnt--;
					Cpaper[n]++;
					DoCover(r, c, n, 1);
				}
			}
		} else {
			search(r + ((c + 1) / 10), (c + 1) % 10, level, currentPaper);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[10][10];
		anslevel = Integer.MAX_VALUE;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1)
					target++;
			}
		}
		search(0, 0, 0, 0);
		if (mincnt != 30)
			System.out.println(mincnt);
		else
			System.out.println(-1);

	}
}
