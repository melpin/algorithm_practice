package _0504;

import java.util.Scanner;

public class B3_지능형기차2_2460 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int total = 0;
		int ans = 0;
		for(int i = 0; i < 10; i++) {
			int out = sc.nextInt();
			int in = sc.nextInt();
			total -= out;
			total += in;
			ans= Integer.max(ans, total);
		}
		System.out.println(ans);
	}

}
