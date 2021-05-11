package _0504;

import java.util.Scanner;

public class S5_쉽게푸는문제_1292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[1001];
		
		int idx = 1;
		stop:for(int i =1; i <= 1000; i++) {
			for(int j = 1; j <= i; j++) {
				arr[idx++] = i;
				if(idx == 1001) break stop;
			}
		}
		int A = sc.nextInt();
		int B = sc.nextInt();
		int sum = 0;
		for(int i = A; i<=B; i++) {
			sum+=arr[i];
		}
		System.out.println(sum);
	}
}