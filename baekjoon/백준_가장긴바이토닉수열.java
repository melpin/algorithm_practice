package _0210;

import java.util.Scanner;

public class 백준_가장긴바이토닉수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		int[][] seq = new int[N][2];
		//increase count 0, decrease count 1;
		
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int tmp_mincnt = 0;
			for (int j = N-i - 1; j < N; j++) {
				if (arr[N-i - 1] > arr[j] && seq[j][1] > tmp_mincnt) {
					tmp_mincnt = seq[j][1];
				}
			}
			seq[N - i - 1][1] = tmp_mincnt + 1;
			//right decrease
			
			int tmp_maxcnt = 0;
			for (int j = i; j >= 0; j--) {
				if (arr[i] > arr[j] && seq[j][0] > tmp_maxcnt) {
					tmp_maxcnt = seq[j][0];
				}
			}
			seq[i][0] = tmp_maxcnt + 1;
			//left decrease
		}

		int max = 0;

		for (int i = 0; i < N; i++)
			max = Integer.max(max, seq[i][0] + seq[i][1] - 1);
		//자기 자신을 두번셌으니 한번뺌
		System.out.println(max);		
	}
}