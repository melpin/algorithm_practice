package _0210;

import java.util.Scanner;

public class 백준_제곱수의합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		
		for(int i = 0; i <=N; i++) {
			for(int j = 1; i + j*j <= N; j++) {
				if(arr[i+j*j] == 0)
					arr[i+j*j] = arr[i]+1;
				else
					arr[i+j*j] = Integer.min(arr[i]+1, arr[i+j*j]);
			}
		}
		System.out.println(arr[N]);
	}
}
