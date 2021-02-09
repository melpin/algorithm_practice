package _0210;

import java.util.Scanner;

public class 백준_합분해 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		long [][]arr = new long [K+1][N+1];
		
		for(int j = 0;j<=N;j++) {
			arr[1][j] = 1;
		}
		
		for(int i = 2;i<=K;i++) { // i개로  j를 만드는 경우
			for(int j = 0;j<=N;j++) {// k를 더하면  이미 만들수 있는 경우의수+1개만큼  경우의수 추가
				for(int k = 0; j+k <= N;k++) {
					arr[i][j+k] = (arr[i][j+k] + arr[i-1][j]) % 1000000000;
				} 
			}
		}
		System.out.println(arr[K][N]);
	}

}
