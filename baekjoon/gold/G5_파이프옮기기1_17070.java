import java.util.Scanner;

public class G5_파이프옮기기1_17070 {
	static int N;
	static int[][] map;
	static int cnt;
	static int[] dr = { 1, 1, 0 };
	static int[] dc = { 0, 1, 1 };

	public static boolean WHCheck(int i, int j) {
		if (i < N && j < N && map[i][j] != 1)
			return true;
		return false;
	}

	public static boolean CCheck(int i, int j) {		
		for (int d = 0; d < 3; d++) {
			if (i+dr[d] < N && j+dc[d] < N) {
				if(map[i+dr[d]][j+dc[d]] == 1)
					return false;
			}
			else return false;
		}
		return true;
	}

	public static void pipeinstall(int i, int j, int state) {
		if (i == N - 1 && j == N - 1) {
			cnt++;
			return;
		}
		if (state == 0) { // right move
			if (WHCheck(i, j + 1)) {
				pipeinstall(i, j + 1, 0);
			}
			if (CCheck(i, j)) {
				pipeinstall(i + 1, j + 1, 2);
			}
		} else if (state == 1) { // down move
			if (WHCheck(i+1, j)) {
				pipeinstall(i+1, j, 1);
			}
			if (CCheck(i, j)) {
				pipeinstall(i + 1, j + 1, 2);
			}
		} else if (state == 2) { // cross move
			if (WHCheck(i, j + 1)) {
				pipeinstall(i, j + 1, 0);
			}
			if (WHCheck(i+1, j)) {
				pipeinstall(i+1, j, 1);
			}
			if (CCheck(i, j)) {
				pipeinstall(i + 1, j + 1, 2);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		map = new int[N][N];
		cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		pipeinstall(0, 1, 0);
		System.out.println(cnt);
	}

}
