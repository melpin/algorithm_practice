package _0421;

import java.util.Scanner;

public class B2_오르막길_2846 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		int[] num = new int[N];
		for(int i =0; i < N; i++) {
			num[i] = sc.nextInt();
		}
			
		for(int i =0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				if(num[j] > num[j-1]) {
					ans = Integer.max(ans, num[j] - num[i]);
				}else {
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
