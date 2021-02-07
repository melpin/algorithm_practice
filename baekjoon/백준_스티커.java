package _0210;

import java.util.Scanner;

public class 백준_스티커 {
	static int N;
	static int [][] sticker;
	static int [][] sumarr;

	static int max(int a, int b, int c) {
		if(a >= b && a >= c)
			return a;
		else if(b >= a && b >= c)
			return b;
		else if(c >= a && c >= b)
			return c;
		return 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			N = sc.nextInt();
			sticker = new int[2][N+1];
			sumarr = new int[2][N+1];

			for (int i = 0; i < 2; i++) {
				for (int j = 1; j < N+1; j++) {
					sticker[i][j] = sc.nextInt();
				}
			}
			
			sumarr[0][1] = sticker[0][1];
			sumarr[1][1] = sticker[1][1];
			
			for(int i = 2; i < N+1; i++) {
				sumarr[0][i] = max(sumarr[0][i-2] + sticker[0][i], sumarr[1][i-2] + sticker[0][i], sumarr[1][i-1] + sticker[0][i]);
				sumarr[1][i] = max(sumarr[0][i-2] + sticker[1][i], sumarr[1][i-2] + sticker[1][i], sumarr[0][i-1] + sticker[1][i]);
			}
			ans = Integer.max(sumarr[0][N], sumarr[1][N]);
			
			System.out.println(ans);
		}
	}

}
