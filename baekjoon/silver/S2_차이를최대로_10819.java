package _0322;

import java.util.Scanner;

public class S2_차이를최대로_10819 {
	static int N;
	static int[] arr;
	static boolean[] used;
	static int[] selected;
	static int maxsum;
	
	static void permu(int idx) {
		if(idx == N) {
			int sum = 0;
			for(int i = 0; i < N-1; i++) {
				sum += Math.abs(selected[i] - selected[i+1]);
			}
			maxsum = Integer.max(maxsum, sum);
			return;
		}
		
		for(int i = 0 ; i < N; i++) {
			if(!used[i]) {
				used[i] = true;
				selected[idx] = arr[i];
				permu(idx+1);
				used[i] = false;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc =new Scanner( System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		used = new boolean[N];
		selected = new int[N];
		maxsum = 0;
		
		for(int i = 0; i< N;i++) {
			arr[i] = sc.nextInt();
		}
		permu(0);
		
		System.out.println(maxsum);
	}

}
