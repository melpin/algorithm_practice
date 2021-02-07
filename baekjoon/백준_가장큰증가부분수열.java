package _0210;

import java.util.Scanner;

public class 백준_가장큰증가부분수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] sumarr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = N-1; i >=0; i--) {
			int tmp_max = 0;
			sumarr[i] += arr[i];
			for (int j = i; j < N; j++) {
				if(arr[i] < arr[j])
					tmp_max = Integer.max(tmp_max, sumarr[j]);
			}
			sumarr[i] += tmp_max;
		}
		
		
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Integer.max(max, sumarr[i]);
		}
		System.out.println(max);

	}

}
