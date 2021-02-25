package _0225;

import java.util.Scanner;

public class S3_GCD합_9613 {
	static long gcd(long a, long b) {
		long tmp;
		if(a < b) {
			tmp = b;
			b = a;
			a = tmp;
		}
		while(b > 0) {
			a %= b;
			tmp = b;
			b = a;
			a = tmp;
		}
		return a;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int [] arr= new int[N];
			long sum = 0;
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = i+1; j < N; j++) {
					sum+= gcd(arr[i],arr[j]);
				}
			}
			
			if(N == 1)
				sum = arr[0];
			System.out.println(sum);
		}
	}
}
