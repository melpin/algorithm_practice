package _0210;

import java.util.Scanner;

public class 백준_1로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int arr[] = new int[N+1];
		for(int i = 1; i < N; i++) {
			if(i*2 <= N)
				arr[i * 2] = Integer.min(arr[i * 2] != 0 ? arr[i * 2]:Integer.MAX_VALUE, arr[i]+1);
			if(i*3 <= N)
				arr[i * 3] = Integer.min(arr[i * 3] != 0 ? arr[i * 3]:Integer.MAX_VALUE, arr[i]+1);
			if(i+1 <= N)
				arr[i + 1] = Integer.min(arr[i + 1] != 0 ? arr[i + 1]:Integer.MAX_VALUE, arr[i]+1);
		}
		System.out.println(arr[N]);
	}
}
