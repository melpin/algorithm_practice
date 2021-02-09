package _0210;

import java.util.Scanner;

public class 백준_파도반수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int tc = 1; tc<=T;tc++) {
			int N = sc.nextInt();
			
			long []arr = new long[N+5]; // n이 1일수도있으니 조금 크게 초기화
			arr[1] = 1;
			arr[2] = 1;
			arr[3] = 1;
			arr[4] = 2;
			
			for(int i = 5; i<=N; i++)
				arr[i] = arr[i-5] + arr[i- 1];
			System.out.println(arr[N]);
		}
	}
}
