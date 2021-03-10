package _0311;

import java.util.Scanner;

public class S3_나무자르기_2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		int st = 0;
		int end = 0;
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			end = Integer.max(end, arr[i]);
		}
		
		int ans = 0;
		while(st <= end) {
			int mid = (st + end) / 2;
			long sum = 0;
			for(int i = 0; i < N; i++) {
				if(arr[i] - mid > 0) {
					sum += arr[i] - mid;
				}
			}
			if(sum >= M) {
				ans = Integer.max(ans, mid);
				st = mid+1;
			}else {
				end = mid-1;
			}
		}
		System.out.println(ans);
	}

}
