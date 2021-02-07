package _0210;

import java.util.Scanner;

public class 백준_가장긴증가하는부분수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] cnt = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = N-1; i >=0; i--) {
			int tmp_maxcnt = 0;
			for (int j = i; j < N; j++) {
				if (arr[i] < arr[j] && cnt[j] > tmp_maxcnt) {
					tmp_maxcnt = cnt[j];
				}
			}
			cnt[i] = tmp_maxcnt + 1;
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Integer.max(max, cnt[i]);
		}
		System.out.println(max);

	}

}
