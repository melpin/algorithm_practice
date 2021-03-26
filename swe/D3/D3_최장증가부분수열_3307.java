package others;

import java.util.Scanner;

public class D3_최장증가부분수열_3307 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1 ;tc <=T; tc++) {
			int ans = 0;
			int N = sc.nextInt();
			int[] arr = new int [N];
			int[] incress = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			incress[N-1] = 1;
			for(int i = N-1; i>=0; i--) {
				int next = 0;
				for(int j = i+1; j < N; j++) {
					if(arr[i] < arr[j]) {
						next = Integer.max(next, incress[j]);
					}
				}
				incress[i] = next + 1;
			}
			
			for(int i = 0; i < N; i++) {
				ans = Integer.max(ans, incress[i]);
			}
			
			System.out.printf("#%d %d\n", tc, ans);
		}

	}

}
