package _0408;

import java.util.Arrays;
import java.util.Scanner;

public class G3_문자판_2186 {
	static int N;
	static int M;
	static int K;
	static char[][] map;
	static int[][][] visited;
	static String target;
	static int tlength;
	static int cnt;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static boolean range(int i, int j) {
		if(0 <= i && i < N && 0<=j && j < M)
			return true;
		return false;
	}
	
	static int dfs(int i, int j, int idx) {
		if(visited[i][j][idx] != -1){
			return visited[i][j][idx];
		}
		if(idx == tlength - 1) {
			visited[i][j][idx] = 1;
			return visited[i][j][idx];
		}
		visited[i][j][idx] = 0;
		
		for(int d = 0; d < 4; d++) {
			for(int k = 1; k <=K; k++) {
				int nr = i+dr[d] * k;
				int nc = j+dc[d] * k;
				if(range(nr, nc) && target.charAt(idx+1) == map[nr][nc]){
					visited[i][j][idx] += dfs(nr,nc,idx+1);
				}
			}
		}
		return visited[i][j][idx];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String s= sc.next();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		target = sc.next();
		tlength = target.length();
		visited = new int[N][M][tlength];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				Arrays.fill(visited[i][j], -1);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == target.charAt(0)) {
					cnt += dfs(i, j, 0);
				}
			}
		}
		System.out.println(cnt);
	}

}
