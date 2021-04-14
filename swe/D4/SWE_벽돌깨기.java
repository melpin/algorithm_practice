package _0419;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWE_벽돌깨기 {
	static int N;
	static int ans;
	static int W;
	static int H;
	static int [][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] select;
	
	static class info{
		int r;
		int c;
		int val;
		info(int r,int c, int val){
			this.r = r;
			this.c = c;
			this.val = val - 1;
		}
	}
	
	static int[][] deepcopy(){
		int[][] result = new int[H][W];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				result[i][j] = map[i][j];
			}
		}
		return result;
	}
	
	static boolean range(int r, int c) {
		if(0<= r && r < H && 0<= c && c < W)
			return true;
		return false;
	}
	
	static void permutation(int idx){
		if(idx == N) {
			int[][] copymap = deepcopy();
			
			for(int i =0; i < N; i++) {
				balldrop(select[i], copymap);
			}
			ans = Integer.min(ans, count(copymap));
			return;
		}
		
		for(int j = 0; j < W; j++) {
			select[idx] = j;
			permutation(idx+1);
		}
	}
	
	static void balldrop(int c, int[][] copymap){
		for(int i =0; i < H; i++){
			if(copymap[i][c] != 0) {
				explode(i, c, copymap);
				cleanup(copymap);
				return;
			}
		}
	}
	
	static void explode(int r,int c, int[][] copymap) {
		Queue<info> q = new LinkedList<>();
		q.add(new info(r,c,copymap[r][c]));
		copymap[r][c] = 0;
		
		while(!q.isEmpty()) {
			info current = q.poll();
			
			for(int d= 0; d<4; d++) {
				for(int v = 1; v <= current.val; v++) {
					int nr = current.r + dr[d] * v;
					int nc = current.c + dc[d] * v;
					if(range(nr,nc) && copymap[nr][nc] != 0){
						q.add(new info(nr,nc, copymap[nr][nc]));
						copymap[nr][nc] = 0;
					}
				}
			}
		}
	}
	
	static void cleanup(int[][] copymap) {
		for(int i =0; i < W; i++){
			int to = H-1;
			int from = H-1;
			while(to>=0 && from>=0) {
				if(copymap[to][i] != 0) {
					to--;
					from--;
				}
				else if(copymap[from][i] == 0) {
					from--;
				}else {
					copymap[to][i] = copymap[from][i];
					copymap[from][i] = 0;
					to--;
					from--;
				}
			}
		}
	}
	
	static int count(int[][] copymap) {
		int cnt = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(copymap[i][j] != 0)cnt ++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc<=T;tc++) {
			ans = Integer.MAX_VALUE;
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			select = new int[N];
			map = new int[H][W];
			
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			permutation(0);
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
