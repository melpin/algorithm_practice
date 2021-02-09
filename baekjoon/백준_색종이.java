import java.util.Scanner;

public class 백준_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		boolean[][] paper = new boolean[101][101];

		for (int i = 0; i < N; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();

			for (int j = h; j < h + 10; j++) {
				for (int k = w; k < w + 10; k++) {
					paper[j][k] = true;
				}
			}
		}

		int cnt = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (paper[i][j]) cnt++;
			}
		}

		System.out.println(cnt);
	}

}
