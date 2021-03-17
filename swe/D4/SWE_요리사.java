package _0315;

import java.util.Scanner;

public class SWE_요리사 {
	static int N;
	static int[][] comb;
	static boolean[] selected;
	static int ans;
	
	static void comb(int selCount, int stidx){
		if(selCount == N/2) {
			ans = Integer.min(ans, Math.abs(calcfood(true) - calcfood(false)));
			return;
		}
		
		for(int i = stidx; i < N; i++) {
			if(!selected[i]) {
				selected[i] = true;
				comb(selCount+1, i + 1);
				selected[i] = false;
			}
		}
	}
	
	//true A food, false B food
	static int calcfood(boolean sign){
		int []arr = new int[N/2];
		int idx =0;
		for(int i = 0; i < N; i++) {
			if(selected[i] == sign){
				arr[idx++] = i;
			}
		}
		
		int sum = 0;
		for(int i : arr) {
			for(int j : arr) {
				sum += comb[i][j];
			}
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			comb = new int[N][N];
			selected = new boolean[N];
			ans = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					comb[i][j] = sc.nextInt();
				}
			}
			
			comb(0, 0);
			
			System.out.printf("#%d %d\n", tc, ans);
		}

	}

}
