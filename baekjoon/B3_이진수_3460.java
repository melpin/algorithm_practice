package _0504;

import java.util.Scanner;

public class B3_이진수_3460 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			for(int i = 0; (1 << i) <= N; i++){
				if((N & (1 << i)) > 0)
					System.out.print(i+" ");
			}
			System.out.println();
		}
	}

}
