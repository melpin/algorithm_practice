import java.util.Scanner;

public class D5_최적경로 {
	static int N;
	static point[] cus;
	static boolean[] visit;
	static int ans;
	static point company;
	static point home;

	static class point {
		int x;
		int y;
		point() {
		}

		point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int distance(point a, point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}

	public static void go(point start, int idx, int sum) {
		if(sum > ans) // 이미 더 크면 검색할 필요없음
			return;
		if (idx == N) {
			ans = Integer.min(ans, sum + distance(start, home));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				go(cus[i], idx + 1, sum + distance(start, cus[i]));
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			ans = Integer.MAX_VALUE;
			N = sc.nextInt();
			cus = new point[N];
			visit = new boolean[N];
			company = new point(sc.nextInt(), sc.nextInt());
			home = new point(sc.nextInt(), sc.nextInt());

			for (int i = 0; i < N; i++) {
				point tmp = new point(sc.nextInt(), sc.nextInt());
				cus[i] = tmp;
			}
			go(company, 0, 0);

			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
