package _0423;

import java.util.Scanner;

public class SWE_보호필름 {
	static int D, W, K;
	static int[][] map;
	static int ans;
	static boolean[] selectedD;
	
	static boolean linecheck(int[][] copymap, int R, int c){
		int before = copymap[R][c];
		int cnt = 1;
		for(int r = R+1; r <D;r++) {
			if(copymap[r][c] == before) {
				cnt++;
			}else {
				before = copymap[r][c];
				cnt = 1;
			}
			if(cnt >= K)
				return true;
		}
		if(cnt >= K)
			return true;
		return false;
	}
	
	static boolean mapcheck(int[][] copymap) {
		for(int i =0; i < W; i++) {
			if(!linecheck(copymap, 0, i))
				return false;
		}
		
		return true;
	}
	
	static int[][] deepcopy(int [][] originmap) {
		int[][] copymap = new int[D][W];
		for(int i = 0; i < D; i++) {
			for(int j=0;j < W; j++) {
				copymap[i][j] = originmap[i][j];
			}
		}
		return copymap;
	}
	
	static void dfs(int cnt, int idx, int[][]copymap) {
		if(cnt >= ans)
			return;
		if(mapcheck(copymap)) {
			ans = cnt;
			return;
		}
		if(idx == D)
			return;
		
		dfs(cnt, idx+1, copymap);
		
		int[][] Acopy = deepcopy(copymap);
		for(int i =0; i < W; i++)
			Acopy[idx][i] = 0;
		dfs(cnt+1, idx+1, Acopy);
		
		int[][] Bcopy = deepcopy(copymap);
		for(int i =0; i < W; i++)
			Bcopy[idx][i] = 1;
		dfs(cnt+1, idx+1, Bcopy);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1;tc<= T; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			map = new int[D][W];
			ans = Integer.MAX_VALUE;
			
			for(int i = 0; i < D; i++) {
				for(int j=0;j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			if(K == 1) {
				ans = 0;
			}else {
				dfs(0,0,map);
			}
			System.out.println("#"+tc+" "+ans);
			
		}
	}

}
