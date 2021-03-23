package _0325;

import java.util.Scanner;

public class S2_외판원순회2_10971 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int ans = 0;
	
	static void go(int start, int from, int sum, int selected){
		if(selected == N) {
			if(map[from][start] != 0)
				ans = Integer.min(ans, sum + map[from][start]);
			return;
		}
		
		for(int i = 0 ; i <N;i++){
			if(!visited[i] && map[from][i]!=0) {
				visited[i] = true;
				go(start, i, sum+map[from][i], selected+1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		visited = new boolean[N];
		ans = Integer.MAX_VALUE;
		
		for(int i = 0 ; i <N;i++) {
			for(int j = 0 ; j <N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0 ; i <N;i++) {
			visited[i] = true;
			go(i, i, 0,1);
			visited[i] = false;
		}
		System.out.println(ans);

	}

}
