package _0504;

import java.util.Scanner;

public class S5_소수_2581 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean[] chea = new boolean[10001];
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 2; i <= 10000;i++) {
			if(!chea[i]) {
				if(M<= i && i <= N){
					min = Integer.min(min, i);
					sum += i;
				}
				
				for(int t = 2;i*t <= 10000; t++) {
					chea[i*t] = true;
				}
			}
		}
		if(sum == 0) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(min);			
		}
	}
}