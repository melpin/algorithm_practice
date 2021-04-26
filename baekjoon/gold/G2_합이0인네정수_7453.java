package _0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class G2_합이0인네정수_7453 {
	static int lowerbound(long[] list, long target) {
		int st = 0;
		int end = list.length;
		while(st < end) {
			int mid = (end + st) / 2;
			if(target <= list[mid]) {
				end = mid;
			}else {
				st = mid+1;
			}
		}
		return st;
	}
	
	static int upperbound(long[] list, long target) {
		int st = 0;
		int end = list.length;
		while(st < end) {
			int mid = (end + st) / 2;
			if(list[mid] <= target) {
				st = mid+1;
			}else {
				end = mid;
			}
		}
		return st;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] A = new long[N];
		long[] B = new long[N];
		long[] C = new long[N];
		long[] D = new long[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			A[i] = Long.parseLong(stk.nextToken());
			B[i] = Long.parseLong(stk.nextToken());
			C[i] = Long.parseLong(stk.nextToken());
			D[i] = Long.parseLong(stk.nextToken());
		}
		
		long[] AB = new long[N*N];
		long[] CD = new long[N*N];
		int idx = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				AB[idx] = A[i] + B[j];
				CD[idx] = C[i] + D[j];
				idx++;
			}
		}
		
		Arrays.sort(AB);
		Arrays.sort(CD);
		long cnt = 0;
		for(int i = 0; i < N*N;i++) {
			int l = lowerbound(CD, -AB[i]);
			int u = upperbound(CD, -AB[i]);
			cnt+= u - l;
		}
		System.out.println(cnt);
	}
}