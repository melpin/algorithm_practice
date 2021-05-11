package _0511;

import java.util.Scanner;

public class G5_최소비용구하기_1916 {
	final static int INF = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int map[][] = new int[N+1][N+1];
		for(int i = 0; i <=N; i++) {
			for(int j = 0; j <=N; j++) {
				map[i][j] = INF;
			}
		}
		
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int val = sc.nextInt();
			map[from][to] = Integer.min(map[from][to], val);
		}
		int start = sc.nextInt();
		int target = sc.nextInt();
		
		long []distance = new long[N+1];
		for(int i = 0; i <=N; i++)
			distance[i] = INF;
		distance[start] = 0;
		boolean []used =new boolean[N+1];
		for(int i = 1; i <= N;i++) {
			int minnode = 0;
			long minnodeval = INF;
			
			for(int j = 1; j <= N; j++) {
				if(!used[j] && minnodeval > distance[j]) {
					minnode = j;
					minnodeval = distance[j];
				}
			}
			used[minnode] = true;
			
			for(int j = 1; j <= N; j++) {
				distance[j] = Long.min(distance[j], distance[minnode] + map[minnode][j]);
			}
		}
		
		System.out.println(distance[target]);
	}
}