package _0302;

import java.util.Scanner;

public class S2_소수구하기_1929 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		boolean[] grap = new boolean[1000001];
		grap[1] = true;
		for (int i = 2; i < 1000001; i++) {
			if (!grap[i])
				for (int j = 2; i * j < 1000001; j++)
					grap[i * j] = true;
		}
		// false가 기본값이니 true 는 소수가 아닌것
		int cnt = 0;
		for (int i = M; i <= N; i++) {
			if (!grap[i])
				System.out.println(i);
		}
	}

}
