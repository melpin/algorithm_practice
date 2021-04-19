package _0419;

import java.util.Scanner;

public class S2_부분수열의합_1182 {
	static int N;
	static int S;
	static int cnt;
	static int[] numbers;
	
	static void combination(int sidx, int sum){
		if(sum == S) {
			cnt++;
		}
		
		for(int i =sidx; i < N; i++) {
			combination(i+1,sum + numbers[i]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			S = sc.nextInt();
			numbers = new int[N];
			
			for(int i =0; i < N; i++) {
				numbers[i] = sc.nextInt();
			}
			
			combination(0, 0);
			if(S == 0) cnt--; // no one selected result
			System.out.println(cnt);
	}
}