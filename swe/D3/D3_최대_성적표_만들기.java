package _0203;

import java.util.Scanner;

public class D3_최대_성적표_만들기 {
	public static void simplesort(int arr[]) {
		for(int i = 0; i<arr.length;i++) {
			for(int j = i+1; j <arr.length;j++) {
				if(arr[i] < arr[j]){
					arr[i] ^= arr[j];
					arr[j] ^= arr[i];
					arr[i] ^= arr[j];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc = 1; tc <=T; tc++) {
			int ans = 0;
			int N = sc.nextInt();
			int K = sc.nextInt();
			int arr[] = new int[N];
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			simplesort(arr);
			for(int i = 0;i<K; i++)
				ans += arr[i];
			
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
