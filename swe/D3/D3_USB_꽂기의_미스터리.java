package _0203;

import java.util.Scanner;

public class D3_USB_꽂기의_미스터리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc = 1; tc <=T; tc++) {
			String ans;
			
			double p = sc.nextDouble();
			double q = sc.nextDouble();
			
			ans = (1-p < p * (1-q)) ? "YES" : "NO";
			
			System.out.printf("#%d %s\n", tc, ans);
		}
	}
}
