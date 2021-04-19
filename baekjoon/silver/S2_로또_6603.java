package _0419;

import java.util.Scanner;

public class S2_로또_6603 {
	static int N;
	static int[] numbers;
	static int[] selectnum;
	
	static void combination(int sidx, int idx){
		if(idx == 6) {
			for(int i =0; i < 6; i++) {
				System.out.print(selectnum[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i =sidx; i < N; i++) {
			selectnum[idx] = numbers[i]; 
			combination(i+1, idx+1);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			N = sc.nextInt();
			if(N == 0)break;
			numbers = new int[N];
			selectnum = new int[6];
			
			for(int i =0; i < N; i++) {
				numbers[i] = sc.nextInt();
			}
			
			combination(0,0);
			System.out.println();
		}
	}
}