package _0304;

import java.util.Scanner;

public class S1_순열사이클_10451 {

	static int N;
	static int[] map;
	static boolean[] visit;

	static void DFS(int from) {
		if (!visit[from]){
			visit[from] = true;
			DFS(map[from]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();

			map = new int[N + 1];
			visit = new boolean[N + 1];

			for (int i = 1; i <= N; i++) {
				map[i] = sc.nextInt();
			}

			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (!visit[i]){
					cnt++;
					visit[i] = true;
					DFS(map[i]);
				}
			}
			System.out.println(cnt);
		}
	}
}
