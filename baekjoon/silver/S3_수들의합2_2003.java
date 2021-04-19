package _0419;

import java.util.Scanner;

public class S3_수들의합2_2003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] numbers = new int[N];
		for(int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		
		int cnt = 0;
		int from = 0;
		int to = 0;
		int sum =0;
		while(from < N) {
			if(sum == M){
				cnt++;
				sum -= numbers[from++];
			}else if(sum > M) {
				sum -= numbers[from++];
			}else if(sum < M && to < N){
				sum += numbers[to++];
			}else if(sum < M && to >= N)
				break;
		}
		System.out.println(cnt);
	}
}
