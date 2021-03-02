package _0302;

import java.util.Scanner;

public class S2_연결요소의개수_11724 {
	static int[][] map;
	static int N;
	static boolean[] visited;
	
	static void visit(int start) {
		for(int i =1; i <=N; i++) {
			if(map[start][i] == 1 && !visited[i]){
				visited[i] = true;
				visit(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();

		map = new int[N+1][N+1];
		visited = new boolean [N+1];
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				visit(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
