package _0126;

import java.util.Scanner;

public class D3_준환이의_운동관리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc = 1; tc <=T; tc++) {
			int L = sc.nextInt();
			int U = sc.nextInt();
			int X = sc.nextInt();
			int ans = 0;
			
			if(X > U)
				ans = -1;
			else if(X < L)
				ans = L - X;
			else
				ans = 0;
			
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
