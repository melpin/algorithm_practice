package _0210;

import java.util.Scanner;

public class 백준_카드구매하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] cp = new int [N+1];
		int[] cpsum = new int[N+1];
		
		for(int i = 1; i <= N; i++) 
			cp[i] = sc.nextInt();
		
		for(int i = 0; i <= N; i++) { // i개를 살때 최대값
			for(int j = 0; i + j <= N; j++){ // j개를 더살때
				cpsum[i+j] = Integer.max(cpsum[i] + cp[j], cpsum[i+j]);
			}
		}
		
		System.out.println(cpsum[N]);
	}

}
