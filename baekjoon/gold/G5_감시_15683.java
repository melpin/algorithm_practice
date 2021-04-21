package _0421;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class G5_감시_15683 {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] cctvrange = {{},{1}, {1,3}, {0,1}, {0,1,3}, {0,1,2,3}};
	static int N;
	static int M;
	static int[][] map;
	static cctv[] cctvs;
	static int [] rotate;
	static int ans;
	
	static class cctv{
		int r;
		int c;
		int type;
		cctv(int r,int c,int type){
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}
	
	static int[][] deepcopy(){
		int [][] copymap = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copymap[i][j] = map[i][j];
			}
		}
		return copymap;
	}
	
	static boolean range(int r,int c) {
		if(0<= r && r < N && 0 <= c && c < M)
			return true;
		return false;
	}
	
	static void rotatecombination(int select){
		if(select == cctvs.length) {
			watch(deepcopy());
			return;
		}
		
		for(int r= 0; r < 4; r++) {
			rotate[select] = r;
			rotatecombination(select+1);
		}
	}
	
	static void watch(int [][]copymap){
		for(int i = 0; i < cctvs.length; i++) {
			for(int d : cctvrange[cctvs[i].type]) {
				int nr = cctvs[i].r + dr[(d + rotate[i]) % 4];
				int nc = cctvs[i].c + dc[(d + rotate[i]) % 4];
				while(range(nr,nc) && copymap[nr][nc] != 6) {
					copymap[nr][nc] = 9;
					nr +=dr[(d + rotate[i]) % 4];
					nc +=dc[(d + rotate[i]) % 4];
				}
			}
		}
		ans = Integer.min(ans, count(copymap));
	}
	
	static int count(int [][] copymap) {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copymap[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		List<cctv> l = new LinkedList<cctv>();
		map = new int[N][M];
		ans = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] != 0 && map[i][j] != 6){
					l.add(new cctv(i,j,map[i][j]));
				}
			}
		}
		cctvs = l.toArray(new cctv[l.size()]);
		rotate = new int[cctvs.length];
		rotatecombination(0);
		System.out.println(ans);
	}
}