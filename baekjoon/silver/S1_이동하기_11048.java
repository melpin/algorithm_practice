package others;

import java.util.Scanner;

public class S1_이동하기_11048 {
	static int[] dr = {-1,0,-1};
	static int[] dc = {0,-1,-1};
	static int R;
	static int C;
	static int[][] map;
	static int[][] maxvisit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		maxvisit = new int[R][C];
		
		for(int i = 0; i < R;i++) {
			for(int j = 0; j < C;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		maxvisit[0][0] = map[0][0];
		
		for(int r = 0; r < R;r++) {
			for(int c = 0; c < C;c++) {
				int maxval =0;
				for(int d = 0; d< 3; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr >=0 && nc >= 0) {
						maxval = Integer.max(maxval, maxvisit[nr][nc]);
					}
				}
				maxvisit[r][c] = maxval + map[r][c];
			}
		}
		System.out.println(maxvisit[R-1][C-1]);

	}
}
