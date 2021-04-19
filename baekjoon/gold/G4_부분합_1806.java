package _0419;

import java.util.Scanner;

public class G4_부분합_1806 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int S = sc.nextInt();
		int[] numbers = new int[N];
		for(int i =0; i < N; i++) {
			numbers[i]= sc.nextInt();
		}
		
		int cnt = Integer.MAX_VALUE;
		int from = 0;
		int to = 0;
		int sum =0;
		while(from < N) {
			if(sum >= S) {
				cnt = Integer.min(cnt, to - from);
				sum -= numbers[from++];
			}else if(sum < S && to < N){
				sum += numbers[to++];
			}else if(sum < S && to >= N)
				break;
		}
		if(cnt == Integer.MAX_VALUE)
			cnt = 0;
		System.out.println(cnt);
		
	}
}