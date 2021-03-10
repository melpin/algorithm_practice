package _0311;

import java.util.Scanner;

public class S3_랜선자르기_1654 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();
		
		int[] line = new int[K];
		for(int i = 0; i < K; i++) {
			line[i] = sc.nextInt();
		}
		
		long min = 1;
		long max = line[0];
		long ans = 0;
		while(min <= max){
			long mid = (min + max)/2;
			long cnt = 0;
			for(int i = 0; i < K; i++) {
				cnt += line[i] / mid;
			}
			if(cnt < N){
				max = mid-1;
			}else{
				ans = Long.max(ans, mid);
				min = mid+1;
			}
		}
		System.out.println(ans);
	}
}
