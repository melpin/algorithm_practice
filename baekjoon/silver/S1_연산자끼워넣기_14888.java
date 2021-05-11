package _0504;

import java.util.Scanner;

public class S1_연산자끼워넣기_14888 {
	static int N;
	static long[] arr;
	static long min;
	static long max;
	static void calc(long num, int idx, int add, int minus, int multi,int div) {
		if(idx == N) {
			min = Long.min(min, num);
			max = Long.max(max, num);
			return;
		}
		if(add > 0)
			calc(num + arr[idx], idx+1, add-1, minus, multi, div);
		if(minus > 0)
			calc(num - arr[idx], idx+1, add, minus-1, multi, div);
		if(multi > 0)
			calc(num * arr[idx], idx+1, add, minus, multi-1, div);
		if(div > 0)
			calc(num / arr[idx], idx+1, add, minus, multi, div-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new long[N];
		min = Long.MAX_VALUE;
		max = Long.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int add = sc.nextInt();
		int minus = sc.nextInt();
		int multi = sc.nextInt();
		int div = sc.nextInt();
		calc(arr[0], 1, add, minus, multi, div);
		System.out.println(max);
		System.out.println(min);
	}
}